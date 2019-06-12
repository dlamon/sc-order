package cn.net.liaowei.sc.order.repository;

import cn.net.liaowei.sc.order.domain.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderDetailRepositoryTest {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(123456);
        orderDetail.setOrderMasterId(1234567890);
        orderDetail.setOrderDetailAmount(new BigDecimal("50.02"));
        orderDetail.setProductId(987654);
        orderDetail.setProductName("定期001型");
        orderDetail.setProductAmount(new BigDecimal("25.01"));
        orderDetail.setProductQuantity(2);
        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }
}