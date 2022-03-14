package com.rgmiyashiro.devopics.rest;

import java.util.ArrayList;
import java.util.List;

import com.rgmiyashiro.devopics.model.Tag;
import com.rgmiyashiro.devopics.service.TagService;

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
class TagResourceTest {

    @InjectMocks
    TagResource classUnderTests;
    @Mock
    TagService tagService;

    @BeforeEach
    void setup() {
        classUnderTests = new TagResource();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void list() {
        List<Tag> expectedTags = new ArrayList<>();
        Mockito.when(this.tagService.findAll()).thenReturn(expectedTags);
        Assertions.assertEquals(expectedTags, this.classUnderTests.list(false));
    }

    @Test
    void list_havingTopics() {
        List<Tag> expectedTags = new ArrayList<>();
        Mockito.when(this.tagService.findWithTopics()).thenReturn(expectedTags);
        Assertions.assertEquals(expectedTags, this.classUnderTests.list(true));
    }
}