package com.rgmiyashiro.devopics.rest;

import com.rgmiyashiro.devopics.dto.TopicDTO;
import com.rgmiyashiro.devopics.model.Topic;
import com.rgmiyashiro.devopics.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TopicResource {

    @Autowired
    private TopicService service;

    @PostMapping("/topics")
    public Topic post(@RequestBody TopicDTO topic) {
        return this.service.insert(topic.buildEntity());
    }

    @GetMapping("/topics")
    public List<Topic> list(@RequestParam(required = false) List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            return this.service.findAccepted();
        }
        return this.service.findByTag(tags);
    }

}
