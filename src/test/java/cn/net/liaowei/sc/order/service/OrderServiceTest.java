package cn.net.liaowei.sc.order.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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