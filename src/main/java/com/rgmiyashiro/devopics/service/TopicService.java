package com.rgmiyashiro.devopics.service;

import com.rgmiyashiro.devopics.exception.TopicCreationException;
import com.rgmiyashiro.devopics.exception.enums.TopicError;
import com.rgmiyashiro.devopics.model.Topic;
import com.rgmiyashiro.devopics.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    public Topic insert(Topic topic) {
        topic.setId(UUID.randomUUID());
        topic.setYear(LocalDate.now().getYear());


        Topic save = null;
        try {
            save = this.repository.save(topic);
        } catch (DataAccessException e) {
            throw new TopicCreationException(TopicError.TAG_NOT_FOUND);
        }

        return save;
    }

    public List<Topic> findAll() {
        return this.repository.findAll();
    }

    public List<Topic> findByTag(String tag) {
        return this.repository.findByTags_NameEqualsIgnoreCase(tag);
    }
}
