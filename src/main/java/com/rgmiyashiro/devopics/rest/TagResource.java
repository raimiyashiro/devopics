package com.rgmiyashiro.devopics.rest;

import com.rgmiyashiro.devopics.model.Tag;
import com.rgmiyashiro.devopics.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://devopics.herokuapp.com/")
public class TagResource {

    @Autowired
    private TagService service;

    @GetMapping("/tags")
    public List<Tag> list() {
        return this.service.findAll();
    }
}
