package cn.net.liaowei.sc.order.service;

import cn.net.liaowei.sc.order.domain.dto.OrderDTO;
import cn.net.liaowei.sc.order.domain.dto.OrderDetailDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerIdNo("500235198808881988");
        orderDTO.setCustomerIdType(Short.valueOf("0"));
        orderDTO.setCustomerName("高莉莉");
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO(1, new BigDecimal("20000"));
        orderDetailDTOList.add(orderDetailDTO);
        orderDetailDTO = new OrderDetailDTO(2, new BigDecimal("30000"));
        orderDetailDTOList.add(orderDetailDTO);
        orderDetailDTO = new OrderDetailDTO(6, new BigDecimal("60000"));
        orderDetailDTOList.add(orderDetailDTO);
        orderDTO.setOrderDetailDTOList(orderDetailDTOList);
        String orderId = orderService.create(orderDTO);
        Assert.assertNotNull(orderId);
    }

    @Test
    public void delete() {
        List<String> orderMasterIdList = Arrays.asList("20190618", "20190619");
        List<String> resultList = orderService.delete(orderMasterIdList);
        Assert.assertEquals(2, resultList.size());
    }

    @Test
    public void finish() {
        List<String> orderMasterIdList = Arrays.asList("20190619");
        List<String> resultList = orderService.finish(orderMasterIdList);
        Assert.assertEquals(1, resultList.size());
    }
}