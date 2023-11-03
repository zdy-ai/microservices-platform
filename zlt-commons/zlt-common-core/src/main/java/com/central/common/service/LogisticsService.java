package com.central.common.service;

/**
 * @author zdy
 * @ClassName LogisticsService
 * @description: 物流查询接口
 * @date 2023年10月30日
 * @version: 1.0
 */
public interface LogisticsService {
    /**
     * 创建订单
     *
     * @param platformCode
     * @return
     */
    Object createOrder(String platformCode);

    /**
     * 确认订单
     *
     * @param platformCode
     * @return
     */
    Object confirmOrder(String platformCode);

    /**
     * 取消订单
     *
     * @param platformCode
     * @return
     */
    Object cancelOrder(String platformCode);

    /**
     * 拦截订单
     *
     * @param platformCode
     * @return
     */
    Object interceptOrder(String platformCode);

    /**
     * 更新订单
     *
     * @param platformCode
     * @return
     */
    Object updateOrder(String platformCode);

    /**
     * 查询订单
     *
     * @param platformCode
     * @return
     */
    Object queryOrder(String platformCode);

    /**
     * 获取标签
     *
     * @param platformCode
     * @return
     */
    Object getLabelUrl(String platformCode);

    /**
     * 轨迹查询
     *
     * @param platformCode
     * @return
     */
    Object getTrack(String platformCode);

    /**
     * 渠道查询
     *
     * @param platformCode
     * @return
     */
    Object getChannel(String platformCode);
}
