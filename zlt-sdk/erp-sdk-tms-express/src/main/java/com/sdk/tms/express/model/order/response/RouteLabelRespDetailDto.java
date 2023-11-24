package com.sdk.tms.express.model.order.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdy
 * @ClassName RouteLabelRespDetailDto
 * @description: TODO
 * @date 2023年10月31日
 * @version: 1.0
 */
@Data
public class RouteLabelRespDetailDto implements Serializable {
    /**
     * 返回调用结果，ERR：调用失败；OK 调用成功
     */
    private String waybillNo;
    /**
     * 原寄地中转场
     */
    private String sourceTransferCode;
    /**
     * 原寄地城市代码
     */
    private String sourceCityCode;
    /**
     * 原寄地网点代码
     */
    private String sourceDeptCode;
    /**
     * 原寄地单元区域
     */
    private String sourceTeamCode;
    /**
     * 目的地城市代码,eg:755
     */
    private String destCityCode;
    /**
     * 目的地网点代码,eg:755AQ
     */
    private String destDeptCode;
    /**
     * 目的地网点代码映射码
     */
    private String destDeptCodeMapping;
    /**
     * 目的地单元区域,eg:001
     */
    private String destTeamCode;
    /**
     * 目的地单元区域映射码
     */
    private String destTeamCodeMapping;
    /**
     * 目的地中转场
     */
    private String destTransferCode;
    /**
     * 打单时的路由标签信息如果是大网的路由标签，这里的值是目的地网点代码，如果是同城配的路由标签，这里的值是根据同城配的设置映射出来的值，
     * 不同的配置结果会不一样，不能根据-符号切分（如：上海同城配，可能是：集散点-目的地网点-接驳点，也有可能是目的地网点代码-集散点-接驳点）
     */
    private String destRouteLabel;
    /**
     * 产品名称
     * 对应RLS:pro_name
     */
    private String proName;
    /**
     * 快件内容：如：C816、SP601
     */
    private String cargoTypeCode;
    /**
     * 时效代码, 如：T4
     */
    private String limitTypeCode;
    /**
     * 产品类型,如：B1
     */
    private String expressTypeCode;
    /**
     * 入港映射码eg:S10
     */
    private String codingMapping;
    /**
     * XB 标志0:不需要打印XB1:需要打印XB
     */
    private String xbFlag;
    /**
     * 打印标志返回值总共有9 位，每一位只有0 和1 两种，0 表示按丰密运单默认的规则，1表示显示，顺序如下，
     * 如111110000表示打印寄方姓名、寄方电话、寄方公司名、寄方地址和重量，收方姓名、收方电话、收方公司名和收方地址按丰密运单
     * 默认规则1：寄方姓名2：寄方电话3：寄方公司名4：寄方地址5：重量6：收方姓名7：收方电话8：收方公司名9：收方地址
     */
    private String printFlag;
    /**
     * 二维码根据规则生成字符串信息,格式为MMM={'k1':'（目的地中转场代码）','k2':'（目的地原始网点代码）','k3':'（目的地单元区
     * 域）','k4':'（附件通过三维码（express_type_code、limit_type_code、cargo_type_code）映射时效类型）','k5':'（运单号）'，'k6':'（AB 标识）'}
     */
    private String twoDimensionCode;
    /**
     * 时效类型:值为二维码中的K4
     */
    private String proCode;
    /**
     * 打印图标根据托寄物判断需要打印的图标(重货,蟹类,生鲜,易碎，Z标)返回值有8 位，每一位只有0和1 两种，0 表示按运单默认的规则，1 表示显示。
     * 后面两位默认0 备用。顺序如下：重货,蟹类,生鲜,易碎,医药类,Z 标,0,0如：00000000 表示不需要打印重货，蟹类，生鲜，易碎,医药,Z 标,备用,备用
     */
    private String printIcon;
    /**
     * AB 标
     */
    private String abFlag;
    /**
     * 查询出现异常时返回信息。返回代码：0 系统异常1 未找到运单
     */
    private String errMsg;
    /**
     * 目的地口岸代码
     */
    private String destPortCode;
    /**
     * 目的国别(国别代码如：JP)
     */
    private String destCountry;
    /**
     * 目的地邮编
     */
    private String destPostCode;
    /**
     * 总价值(保留两位小数，数字类型，可补位)
     */
    private String goodsValueTotal;
    /**
     * 币种
     */
    private String currencySymbol;
    /**
     * 件数
     */
    private String goodsNumber;
}
