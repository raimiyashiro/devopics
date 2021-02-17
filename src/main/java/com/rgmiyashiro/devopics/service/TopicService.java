package com.rgmiyashiro.devopics.service;

import com.rgmiyashiro.devopics.model.Topic;
import com.rgmiyashiro.devopics.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    public Topic insert(Topic topic) {
        return this.repository.save(topic);
    }

    public List<Topic> findAll() {
        return this.repository.findAll();
    }

    public List<Topic> findByTag(String tag) {
        return this.repository.findByTags_NameEqualsIgnoreCase(tag);
    }
}
