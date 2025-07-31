package dev.raniery.shop.entity.request;

import dev.raniery.shop.entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private PaymentMethod paymentMethod;
}
