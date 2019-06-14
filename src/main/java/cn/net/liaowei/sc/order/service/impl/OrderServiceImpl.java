package cn.net.liaowei.sc.order.service.impl;

import cn.net.liaowei.sc.order.domain.dos.OrderDetailDO;
import cn.net.liaowei.sc.order.domain.dos.OrderMasterDO;
import cn.net.liaowei.sc.order.domain.dto.DecreaseQuotaDTO;
import cn.net.liaowei.sc.order.domain.dto.OrderDTO;
import cn.net.liaowei.sc.order.domain.dto.OrderDetailDTO;
import cn.net.liaowei.sc.order.domain.dto.ProductInfoDTO;
import cn.net.liaowei.sc.order.repository.OrderDetailRepository;
import cn.net.liaowei.sc.order.repository.OrderMasterRepository;
import cn.net.liaowei.sc.order.service.OrderService;
import cn.net.liaowei.sc.order.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LiaoWei
 */
@Service
public class OrderServiceImpl implements OrderService {
    private OrderMasterRepository orderMasterRepository;
    private OrderDetailRepository orderDetailRepository;

    public OrderServiceImpl(OrderMasterRepository orderMasterRepository, OrderDetailRepository orderDetailRepository) {
        this.orderMasterRepository = orderMasterRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    @Transactional
    public String create(OrderDTO orderDTO) {
        // 产生主订单编号
        String orderMasterId = KeyUtil.genUniqueKey();

        // 通过订单中产品编号获取产品信息
        List<Integer> productIdList = orderDTO.getOrderDetailDTOList().stream()
                .map(OrderDetailDTO::getProductId).collect(Collectors.toList());
        // TODO: 调用FeignClient获取产品信息
        List<ProductInfoDTO> productInfoDTOList = new ArrayList<>();

        // 扣减产品可用额度
        List<DecreaseQuotaDTO> decreaseQuotaDTOList = orderDTO.getOrderDetailDTOList().stream()
                .map(e -> new DecreaseQuotaDTO(e.getProductId(), e.getBuyAmount()))
                .collect(Collectors.toList());
        // TODO: 调用FeignClient扣减可用额度

        // 写主订单详情
        BigDecimal orderAmount = orderDTO.getOrderDetailDTOList().stream()
                .map(OrderDetailDTO::getBuyAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        OrderMasterDO orderMasterDO = new OrderMasterDO();
        BeanUtils.copyProperties(orderDTO, orderMasterDO);
        orderMasterDO.setOrderAmount(orderAmount);
        orderMasterDO.setOrderStatus(Short.valueOf("0"));
        orderMasterDO.setPaymentStatus(Short.valueOf("0"));
        orderMasterRepository.save(orderMasterDO);

        // 写子订单详情
        for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetailDTOList()) {
            OrderDetailDO orderDetailDO = new OrderDetailDO();
            // 产生子订单编号
            String orderDetailId = KeyUtil.genUniqueKey();
            BeanUtils.copyProperties(orderDetailDTO, orderDetailDO);
            orderDetailDO.setOrderMasterId(orderMasterId);
            orderDetailDO.setOrderDetailId(orderDetailId);
            orderDetailRepository.save(orderDetailDO);
        }

        // 返回主订单号
        return orderMasterId;
    }

    @Override
    @Transactional
    public List<String> delete(List<String> orderMasterIdList) {
        List<OrderMasterDO> orderMasterDOList = orderMasterRepository.findByOrderMasterIdIn(orderMasterIdList);
        for (OrderMasterDO orderMasterDO : orderMasterDOList) {
            orderMasterDO.setOrderStatus(Short.valueOf("1"));
            orderMasterRepository.save(orderMasterDO);
        }
        return orderMasterIdList;
    }

    @Override
    @Transactional
    public List<String> finish(List<String> orderMasterIdList) {
        List<OrderMasterDO> orderMasterDOList = orderMasterRepository.findByOrderMasterIdIn(orderMasterIdList);
        for (OrderMasterDO orderMasterDO : orderMasterDOList) {
            orderMasterDO.setOrderStatus(Short.valueOf("2"));
            orderMasterRepository.save(orderMasterDO);
        }
        return orderMasterIdList;
    }
}
