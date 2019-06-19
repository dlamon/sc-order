package cn.net.liaowei.sc.order.service;

import cn.net.liaowei.sc.order.domain.dto.OrderDTO;

import java.util.List;

/**
 * @author LiaoWei
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO 订单信息
     * @return 创建的订单编号
     */
    String create(OrderDTO orderDTO);

    /**
     * 删除订单
     * @param orderMasterIdList 订单编号列表
     * @return 删除的订单编号列表
     */
    List<String> delete(List<String> orderMasterIdList);

    /**
     * 完结订单
     * @param orderMasterIdList 订单编号列表
     * @return 完结的订单编号
     */
    List<String> finish(List<String> orderMasterIdList);
}
