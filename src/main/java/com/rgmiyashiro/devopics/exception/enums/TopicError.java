package com.rgmiyashiro.devopics.exception.enums;

import lombok.Getter;

public enum TopicError {
    TOPIC_ALREADY_EXISTS("T0000", "Title must be unique. Choose another one."),
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
