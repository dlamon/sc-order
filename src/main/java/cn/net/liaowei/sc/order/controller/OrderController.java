package cn.net.liaowei.sc.order.controller;

import cn.net.liaowei.sc.order.form.OrderForm;
import cn.net.liaowei.sc.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiaoWei
 */
@RestController
@Slf4j
@Api(tags = "/order", description = "订单服务")
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    @ApiOperation("创建订单")
    public String create(@RequestBody @ApiParam("添加表单") OrderForm orderForm) {
        log.debug("{}", orderForm);
        return "123456";
    }
}

//{
//        "orderMasterId": 12345,
//        "customerName": "廖伟",
//        "customerIdType": 0,
//        "customerIdNo": "500233199908111988",
//        "orderDetailList": [
//        {
//        "productId": "222222",
//        "productQuantity": 2
//        },
//        {
//        "productId": "333333",
//        "productQuantity": 3
//        }
//        ]
//        }
