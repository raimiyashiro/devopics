package com.rgmiyashiro.devopics.rest;

import java.util.HashSet;
import com.rgmiyashiro.devopics.dto.TopicDTO;
import com.rgmiyashiro.devopics.model.Topic;
import com.rgmiyashiro.devopics.service.TopicService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TopicResourceTest {

    @Mock
    private TopicService service;

    @InjectMocks
    private TopicResource classUnderTests;

    @BeforeEach
    void setup() {
        this.classUnderTests = new TopicResource();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void post() {
        Mockito.when(this.service.insert(
                Mockito.any())).thenReturn(new Topic());

        Assertions.assertDoesNotThrow(() -> this.classUnderTests.post(new TopicDTO("title", "url", new HashSet<>())));
    }
}
