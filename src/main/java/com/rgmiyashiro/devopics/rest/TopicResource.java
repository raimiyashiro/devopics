package com.rgmiyashiro.devopics.rest;

import com.rgmiyashiro.devopics.model.Topic;
import com.rgmiyashiro.devopics.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicResource {

    @Autowired
    private TopicService service;

    @PostMapping("/topics")
    public Topic post(@RequestBody Topic topic) {
        return this.service.insert(topic);
    }

    @GetMapping("/topics")
    public List<Topic> list(@RequestParam(required = false) String tag) {
        if (tag == null) {
            return this.service.findAll();
        }
        return this.service.findByTag(tag);
    }

}