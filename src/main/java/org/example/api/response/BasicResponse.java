package org.example.api.response;

import lombok.Data;

@Data
public class BasicResponse {

    private final int code;

    private final String message;

    protected BasicResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
