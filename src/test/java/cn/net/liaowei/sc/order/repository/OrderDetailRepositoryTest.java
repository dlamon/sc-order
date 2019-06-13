package cn.net.liaowei.sc.order.repository;

import cn.net.liaowei.sc.order.domain.dos.OrderDetailDO;
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
        OrderDetailDO orderDetailDO = new OrderDetailDO();
        orderDetailDO.setOrderDetailId(123456);
        orderDetailDO.setOrderMasterId(1234567890);
        orderDetailDO.setOrderDetailAmount(new BigDecimal("50.02"));
        orderDetailDO.setProductId(987654);
        orderDetailDO.setProductName("定期001型");
        orderDetailDO.setBuyAmount(new BigDecimal("25.01"));
        OrderDetailDO result = orderDetailRepository.save(orderDetailDO);
        Assert.assertNotNull(result);
    }
}