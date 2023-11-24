package com.erp.tms.aliexpress.model.order.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zdy
 * @ClassName AddressDTO
 * @description: TODO
 * @date 2023年11月17日
 * @version: 1.0
 */
@Data
public class AddressDTO implements Serializable {
    private Address refund;
    private Address sender;
    private Address pickup;
    @NotNull(message = "收货人不能为空")
    private Address receiver;
}
