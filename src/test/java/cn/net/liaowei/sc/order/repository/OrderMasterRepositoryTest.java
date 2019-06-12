package cn.net.liaowei.sc.order.repository;

import cn.net.liaowei.sc.order.domain.OrderMaster;
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
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderMasterId(1234567890);
        orderMaster.setCustomerName("西丽丽");
        orderMaster.setCustomerIdType(Short.valueOf("0"));
        orderMaster.setCustomerIdNo("500235199901112345");
        orderMaster.setOrderAmount(new BigDecimal("100.01"));
        orderMaster.setOrderStatus(Short.valueOf("0"));
        orderMaster.setPaymentAccount("6222711182827660");
        orderMaster.setPaymentStatus(Short.valueOf("0"));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}