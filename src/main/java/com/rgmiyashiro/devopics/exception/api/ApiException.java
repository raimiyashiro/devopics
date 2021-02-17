package com.rgmiyashiro.devopics.exception.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ApiException {

    private String message;
    private String code;
    private ZonedDateTime timestamp;
}
