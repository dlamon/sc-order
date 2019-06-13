package cn.net.liaowei.sc.order.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author LiaoWei
 */
@Data
@ApiModel("订单详情数据转换对象")
public class OrderDetailDTO {
    @ApiModelProperty("产品编号")
    @NotNull(message = "产品编号不能为空")
    private Integer productId;

    @ApiModelProperty("购买金额")
    @NotNull(message = "购买金额不能为空")
    private BigDecimal buyAmount;
}
