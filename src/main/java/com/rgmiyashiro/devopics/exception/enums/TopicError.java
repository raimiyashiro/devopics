package com.rgmiyashiro.devopics.exception.enums;

import lombok.Getter;

public enum TopicError {
    TAG_NOT_FOUND("T0001", "One of the given tags does not exist.");

    @Getter
    private String message;

    @Getter
    private String errorCode;

    TopicError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
