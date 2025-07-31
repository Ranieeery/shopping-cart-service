package dev.raniery.shop.entity.request;

import dev.raniery.shop.entity.PaymentMethod;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    @NotBlank(message = "Payment method cannot be blank")
    @Schema(
        description = "Payment method for the order",
        example = "CREDIT_CARD",
        requiredMode = Schema.RequiredMode.REQUIRED)
    private PaymentMethod paymentMethod;
}
