package cn.net.liaowei.sc.order.service;

import cn.net.liaowei.sc.order.dto.OrderDTO;

/**
 * @author LiaoWei
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO 订单信息
     * @return 创建的订单编号
     */
    public String create(OrderDTO orderDTO);

    /**
     * 删除订单
     * @param orderMasterId 订单编号
     * @return 删除的订单编号
     */
    public String delete(String orderMasterId);

    /**
     * 完结订单
     * @param orderMasterId 订单编号
     * @return 完结的订单编号
     */
    public String finish(String orderMasterId);
}
