package com.rgmiyashiro.devopics.repository;

import com.rgmiyashiro.devopics.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {

    List<Topic> findByTags_NameEqualsIgnoreCase(String tag);
}
