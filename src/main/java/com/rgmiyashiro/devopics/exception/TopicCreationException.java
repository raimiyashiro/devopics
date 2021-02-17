package com.rgmiyashiro.devopics.exception;


import com.rgmiyashiro.devopics.exception.enums.TopicError;
import lombok.Getter;

public class TopicCreationException extends RuntimeException {


    @Getter
    private String errorCode;


    public TopicCreationException(TopicError e) {
        super(e.getMessage());
        this.errorCode = e.getErrorCode();
    }
}
