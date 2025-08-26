package com.mindconnect.socialmedia.PostService.exception;

public class ConflictOccuredException extends RuntimeException {
    public ConflictOccuredException(String message) {
        super(message);
    }

    public ConflictOccuredException(String message, Throwable cause) {
        super(message, cause);
    }
}
