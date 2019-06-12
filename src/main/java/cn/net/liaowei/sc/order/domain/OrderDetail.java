package cn.net.liaowei.sc.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author LiaoWei
 */
@Data
@Entity
@ApiModel("订单详细信息")
public class OrderDetail {
    @Id
    @ApiModelProperty("子订单编号")
    private Integer orderDetailId;

    @ApiModelProperty("主订单编号")
    private Integer orderMasterId;

    @ApiModelProperty("子订单总金额")
    private BigDecimal orderDetailAmount;

    @ApiModelProperty("产品编号")
    private Integer productId;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("单个产品金额")
    private BigDecimal productAmount;

    @ApiModelProperty("产品数量")
    private Integer productQuantity;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;
}
