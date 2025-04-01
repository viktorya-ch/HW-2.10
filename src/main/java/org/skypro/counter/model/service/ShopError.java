package org.skypro.counter.model.service;

public final class ShopError {
    private final String code;
    private final String message;


    public ShopError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
