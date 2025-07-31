package dev.raniery.shop.entity.request;

import dev.raniery.shop.entity.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    @NotBlank
    private PaymentMethod paymentMethod;
}
