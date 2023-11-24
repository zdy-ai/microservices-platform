package com.central.common.handler;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.central.common.annotation.ImportExcel;
import com.central.common.exception.BusinessException;
import com.central.common.model.Result;
import com.central.common.utils.ImportExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zdy
 * @ClassName ExcelHandler
 * @description: TODO
 * @date 2023年10月26日
 * @version: 1.0
 */
@Slf4j
@Component
public class ExcelHandler implements InitializingBean {

    private final ImportExcelUtil importExcelUtil = new ImportExcelUtil();
    @Resource
    private List<SingleExcelHandler> singleExcelHandlers;
    ConcurrentHashMap<String, SingleExcelHandler> singleExcelHandlerMap = new ConcurrentHashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        if (Objects.nonNull(singleExcelHandlers)) {
            for (SingleExcelHandler singleExcelHandler : singleExcelHandlers) {
                Class<?> actualClass = AopProxyUtils.ultimateTargetClass(singleExcelHandler);
                singleExcelHandlerMap.put(actualClass.getAnnotation(ImportExcel.class).handlerName(),
                        singleExcelHandler);
            }
        }
    }


    /**
     * excel处理上层处理方法
     *
     * @param excelFile
     * @param handlerName
     * @return
     */
    public Result dealExcel(MultipartFile excelFile, String handlerName) {
        Result baseResult = new Result();
        SingleExcelHandler singleExcelHandler = singleExcelHandlerMap.get(handlerName);
        // 1、获取文件名
        String fileName = excelFile.getOriginalFilename();
        if (Objects.isNull(fileName) || StringUtils.isBlank(fileName) || fileName.lastIndexOf("//.") < 0) {
            throw new BusinessException(StrUtil.format("导入文件名称错误：{}", String.valueOf(fileName)));
        }
        // 2、获取filetype
        String fileType = fileName.substring(fileName.lastIndexOf("//.") + 1);
        // 3、获取workbook
        Workbook workbook = null;
        try {
            workbook = importExcelUtil.getWorkbook(excelFile.getInputStream(), fileType);
            // 4、获取每行数据
            List<Row> rows = importExcelUtil.getSheet(workbook);
            // 5、获取每行数据
            List rowList = singleExcelHandler.getRowsDate(rows);
            // 6、校验数据
            singleExcelHandler.checkData(rowList);
            // 7、解析落表
            JSONObject jsonObject = singleExcelHandler.dataProcess(rowList);
            baseResult.setDatas(jsonObject);
        } catch (Exception e) {
            log.error("文件解析失败", e);
            throw new BusinessException(StrUtil.format("文件解析异常：{}", e.getMessage()));
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return baseResult;
    }
}
