package com.weshare.weshare.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponse(LocalDateTime localDateTime,
                            int errorCode,
                            String error,
                            String methods,
                            String requestUri,
                            Map<String, String> map,
                            String message) {
}