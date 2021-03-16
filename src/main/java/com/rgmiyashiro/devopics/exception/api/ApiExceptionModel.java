package com.rgmiyashiro.devopics.exception.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ApiExceptionModel {

    private String code;
    private String message;
    private ZonedDateTime timestamp;
}
