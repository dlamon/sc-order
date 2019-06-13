package cn.net.liaowei.sc.order.repository;

import cn.net.liaowei.sc.order.domain.dos.OrderMasterDO;
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
        OrderMasterDO orderMasterDO = new OrderMasterDO();
        orderMasterDO.setOrderMasterId(1234567890);
        orderMasterDO.setCustomerName("西丽丽");
        orderMasterDO.setCustomerIdType(Short.valueOf("0"));
        orderMasterDO.setCustomerIdNo("500235199901112345");
        orderMasterDO.setOrderAmount(new BigDecimal("100.01"));
        orderMasterDO.setOrderStatus(Short.valueOf("0"));
        orderMasterDO.setPaymentAccount("6222711182827660");
        orderMasterDO.setPaymentStatus(Short.valueOf("0"));
        OrderMasterDO result = orderMasterRepository.save(orderMasterDO);
        Assert.assertNotNull(result);
    }
}