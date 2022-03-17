package com.rgmiyashiro.devopics.rest;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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

    @Test
    void list() {
        Mockito.when(this.service.findAccepted()).thenReturn(new ArrayList<>());
        List<Topic> expected = new ArrayList<>();
        List<Topic> actual =this.classUnderTests.list(null);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void list_withTags() {
        Mockito.when(this.service.findByTag(
            Mockito.anyList()
        )).thenReturn(new ArrayList<>());

        List<Topic> expected = new ArrayList<>();
        List<Topic> actual =this.classUnderTests.list(
            new ArrayList<>(
                Arrays.asList("Java")
            )
        );
        
        Assertions.assertEquals(expected, actual);
    }
}
