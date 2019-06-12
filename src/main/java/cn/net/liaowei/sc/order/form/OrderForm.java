package cn.net.liaowei.sc.order.form;

import cn.net.liaowei.sc.order.domain.OrderDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author LiaoWei
 */
@Data
@ApiModel("订单表单对象")
public class OrderForm {
    @ApiModelProperty("订单编号")
    private Integer orderMasterId;

    @ApiModelProperty("客户姓名")
    private String customerName;

    @ApiModelProperty("客户证件类型 0身份证 1其他")
    private Short customerIdType;

    @ApiModelProperty("客户证件号码")
    private String customerIdNo;

    @ApiModelProperty("子订单列表")
    List<OrderDetail> orderDetailList;
}
