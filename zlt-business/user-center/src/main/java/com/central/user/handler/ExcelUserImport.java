package com.central.user.handler;

import com.alibaba.fastjson.JSONObject;
import com.central.common.annotation.ImportExcel;
import com.central.common.handler.SingleExcelHandler;
import com.central.user.model.SysUserExcel;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zdy
 * @ClassName ExcelUserImport
 * @description: TODO
 * @date 2023年10月26日
 * @version: 1.0
 */
@Slf4j
@Component
@ImportExcel(handlerName = "excelUserImport")
public class ExcelUserImport extends SingleExcelHandler<SysUserExcel> {
    @Override
    public List<SysUserExcel> getRowsDate(List<Row> rows) {
        List<SysUserExcel> excels = new ArrayList<>();
        rows.forEach(item -> {
            excels.add(dealCell(item));
        });
        return excels;
    }

    @Override
    public SysUserExcel dealCell(Row row) {
        SysUserExcel excel = new SysUserExcel();
        int cellNum = 0;
        Cell cell;
        //cellId
        cell = row.getCell(cellNum++);
        String userName = readCellToStringValue(cell);
        excel.setUsername(userName);

        cell = row.getCell(cellNum++);
        String nickname = readCellToStringValue(cell);
        excel.setNickname(nickname);

        cell = row.getCell(cellNum++);
        String mobile = readCellToStringValue(cell);
        excel.setMobile(mobile);

        cell = row.getCell(cellNum++);
        Integer sex = readCellToIntegerValue(cell);
        excel.setSex(sex);
        return excel;
    }

    @Override
    public void checkData(List<SysUserExcel> dataList) {
        log.info("校验表格");
    }

    @Override
    public JSONObject dataProcess(List<SysUserExcel> dataList) {
        log.info(dataList.toString());
        log.info("处理数据");
        return null;
    }
}
