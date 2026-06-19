package dev.raniery.shop.infra.exceptions;

public class RegisterException extends RuntimeException {

    public RegisterException(String message) {
        super(message);
    }
}
