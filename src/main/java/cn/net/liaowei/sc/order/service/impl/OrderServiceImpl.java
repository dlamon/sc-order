package cn.net.liaowei.sc.order.service.impl;

import cn.net.liaowei.sc.order.domain.dto.OrderDTO;
import cn.net.liaowei.sc.order.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author LiaoWei
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    @Transactional
    public String create(OrderDTO orderDTO) {
        // 通过订单中产品编号获取产品信息

        // 扣减产品可用额度

        // 写子订单详情

        // 写主订单详情

        // 返回主订单号

        return null;
    }

    @Override
    public String delete(String orderMasterId) {
        return null;
    }

    @Override
    public String finish(String orderMasterId) {
        return null;
    }
}
