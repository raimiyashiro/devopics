package com.rgmiyashiro.devopics.service;

import com.rgmiyashiro.devopics.exception.TopicCreationException;
import com.rgmiyashiro.devopics.exception.enums.TopicError;
import com.rgmiyashiro.devopics.model.Topic;
import com.rgmiyashiro.devopics.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    public Topic insert(Topic topic) {
        Optional<Topic> query = this.repository.findByTitle(topic.getTitle());

        if (query.isPresent()) {
            throw new TopicCreationException(TopicError.TOPIC_ALREADY_EXISTS);
        }

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

    public List<Topic> findAccepted() {
        return this.repository.findByAccepted(true);
    }


    public List<Topic> findByTag(List<String> tags) {
        return this.repository.findByAcceptedAndTags_NameIn(
                true,
                tags.stream().map(String::toLowerCase).collect(Collectors.toList())
        );
    }
}
