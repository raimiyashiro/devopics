package com.rgmiyashiro.devopics.exception.handler;

import com.rgmiyashiro.devopics.exception.TopicCreationException;
import com.rgmiyashiro.devopics.exception.api.ApiExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(TopicCreationException.class)
    public ResponseEntity<Map<String, ApiExceptionModel>> handleTopicCreationException(TopicCreationException e) {

        ApiExceptionModel apiException = new ApiExceptionModel(
                e.getMessage(),
                e.getErrorCode(),
                ZonedDateTime.now()
        );

        Map<String, ApiExceptionModel> json = new HashMap<>();
        json.put("error", apiException);

        return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }
}
