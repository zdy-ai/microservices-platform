package com.central.common.utils;

import com.central.common.exception.BusinessException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zdy
 * @ClassName ImpoerExcelUtil
 * @description: TODO
 * @date 2023年10月26日
 * @version: 1.0
 */
public class ImportExcelUtil {
    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";
    private static final String XLSM = "xlsm";

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     *
     * @param inputStream 读取文件的输入流
     * @param fileType    文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSM)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }




    /**
     * 根据workbook获取所有行数据
     * @param workbook
     * @return
     */
    public List<Row> getSheet(Workbook workbook) {
        // 1、解析sheet页
        Sheet sheet = workbook.getSheetAt(0);
        // 2、第一行数据校验
        int firstRowNum = sheet.getFirstRowNum();
        Row firstRow = sheet.getRow(firstRowNum);
        if (Objects.isNull(firstRow)) {
            throw new BusinessException("第一行数据为空");
        }
        // 3、解析Row
        List<Row> rows = new ArrayList<>();
        int rowBegin = firstRowNum + 1;
        int rowEnd = sheet.getPhysicalNumberOfRows();
        for (int rowNum = rowBegin; rowNum < rowEnd; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (Objects.isNull(row)) {
                continue;
            }
            rows.add(row);
        }
        return rows;
    }
}
