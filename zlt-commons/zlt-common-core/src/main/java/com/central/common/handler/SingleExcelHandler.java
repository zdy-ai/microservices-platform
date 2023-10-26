package com.central.common.handler;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * @author zdy
 * @ClassName SingleExcelHandler
 * @description: excel处理handler
 * @date 2023年10月26日
 * @version: 1.0
 */
public abstract class SingleExcelHandler<T> {
    /**
     * 获取所有行数据
     *
     * @param rows
     * @return
     */
    public abstract List<T> getRowsDate(List<Row> rows);

    /**
     * 处理单行数据为实体类
     *
     * @param row
     * @return
     */
    public abstract T dealCell(Row row);

    /**
     * 数据校验
     *
     * @param dataList
     */
    public abstract void checkData(List<T> dataList);

    /**
     * 数据处理
     *
     * @param dataList
     * @return
     */
    public abstract JSONObject dataProcess(List<T> dataList);

    /**
     * 单个数据的数据转换
     *
     * @param cell
     * @return
     */
    protected String readCellToStringValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
            // 数字
            case NUMERIC:
                double doubleValue = cell.getNumericCellValue();
                returnValue = String.valueOf(doubleValue);
                break;
            // 字符串
            case STRING:
                returnValue = cell.getStringCellValue();
                break;
            // 布尔
            case BOOLEAN:
                boolean booleanValue = cell.getBooleanCellValue();
                returnValue = String.valueOf(booleanValue);
                break;
            // 空值
            case BLANK:
                break;
            // 公式
            case FORMULA:
                returnValue = cell.getCellFormula();
                break;
            // 故障
            case ERROR:
                break;
            default:
                break;
        }
        return returnValue;
    }

    /**
     * 单个数据的数据转换
     *
     * @param cell
     * @return
     */
    protected Integer readCellToIntegerValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        Integer returnValue = null;
        switch (cell.getCellType()) {
            // 数字
            case NUMERIC:
                double doubleValue = cell.getNumericCellValue();
                returnValue = (int) doubleValue;
                break;
            // 字符串
            case STRING:
                returnValue = Integer.valueOf(cell.getStringCellValue());
                break;
            // 布尔
            case BOOLEAN:
                boolean booleanValue = cell.getBooleanCellValue();
                //0 false 1 true
                returnValue = booleanValue ? 1 : 0;
                break;
            // 空值
            case BLANK:
                break;
            // 公式
            case FORMULA:
                break;
            // 故障
            case ERROR:
                break;
            default:
                break;
        }
        return returnValue;
    }
}
