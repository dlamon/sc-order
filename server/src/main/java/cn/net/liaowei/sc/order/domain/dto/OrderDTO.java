package cn.net.liaowei.sc.order.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author LiaoWei
 */
@Data
@ApiModel("订单数据转换对象")
public class OrderDTO {
    @ApiModelProperty("客户姓名")
    private String customerName;

    @ApiModelProperty("客户证件类型 0身份证 1其他")
    @NotNull(message = "客户证件类型不能为空")
    private Short customerIdType;

    @ApiModelProperty("客户证件号码")
    @NotBlank(message = "客户证件号码不能为空")
    @Size(max = 18, min = 18, message = "客户证件号码必须为18位")
    private String customerIdNo;

    @Valid
    @ApiModelProperty("子订单列表")
    @NotEmpty(message = "子订单不能为空")
    List<OrderDetailDTO> orderDetailDTOList;
}
