package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.exception;

import java.time.Instant;

public record ApiError(
        String message,
        String path,
        Integer statusCode,
        Instant timestamp
) {
}
