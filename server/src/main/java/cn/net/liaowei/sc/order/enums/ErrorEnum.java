package cn.net.liaowei.sc.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {
    /**
     * 公共错误码枚举
     */
    SYSTEM_INTERNAL_ERROR("E000009", "系统内部错误"),
    PARAM_CHECK_ERROR("PRM0001", "参数检查错误"),
    /**
     * 服务错误码枚举
     */
    SAVE_DETAIL_ORDER_ERROR("ORD0001", "保存子订单信息失败");

    private String code;
    private String message;
}