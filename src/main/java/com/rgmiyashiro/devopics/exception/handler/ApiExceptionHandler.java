package com.rgmiyashiro.devopics.exception.handler;

import com.rgmiyashiro.devopics.exception.TopicCreationException;
import com.rgmiyashiro.devopics.exception.api.ApiException;
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
    public ResponseEntity<Map<String, ApiException>> handleTopicCreationException(TopicCreationException e) {

        ApiException apiException = new ApiException(
                e.getMessage(),
                e.getErrorCode(),
                ZonedDateTime.now()
        );

        Map<String, ApiException> json = new HashMap<>();
        json.put("error", apiException);

        return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
    }
}
