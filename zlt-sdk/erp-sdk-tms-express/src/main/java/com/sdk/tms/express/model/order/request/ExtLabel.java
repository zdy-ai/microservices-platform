package com.sdk.tms.express.model.order.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName ExtLabel
 * @description: TODO
 * @date 2023年11月10日
 * @version: 1.0
 */
@Data
public class ExtLabel implements Serializable {
    /**
     * 订单所属渠道
     * eg: “medicine” 代表医药渠道运单，cx：代表是CX预约单
     */
    private String channel;
    /**
     * 自定义脱敏标识，4位0和1组成的字符串，0表示不脱敏，1表示需要脱敏；顺序：第1位：收件人姓名，第2位：寄件人姓名，第3位：收件人地址，第4位：寄件人地址
     * eg: “1010” 表示收件人姓名和收件人地址脱敏，寄件人姓名和寄件人地址不脱敏,
     * 地址脱敏规则：后10位，如果有阿拉伯数字、中文数字、字母就用*替换
     * 姓名脱敏规则：1个字的 不隐藏，2个字的 隐藏末位，3个字的 隐藏中间，超过三个字，超过部分不打印，隐藏第三位，如欧阳娜娜-欧阳*
     * 手机号脱敏规则：保留前1位和后4位 eg: 1*2345
     */
    private String encryptFlag;
    /**
     * 生成面单文件格式 pdf格式
     * true:批量打印时，多页合并为一个pdf文件返回，
     * false：一页一个pdf文件，默认false
     */
    private boolean mergePdf;
    /**
     * 合并文件方式
     * 	all:将所有document合并为一个pdf文件返回,
     * single:一个document的多页合并一个pdf文件，默认all
     */
    private String mergeType = "all";
}
