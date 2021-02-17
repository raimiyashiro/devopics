package com.rgmiyashiro.devopics.dto;

import com.rgmiyashiro.devopics.model.Tag;
import com.rgmiyashiro.devopics.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class TopicDTO {

    private String title;
    private String url;
    private Set<TagDTO> tags;

    public Topic buildEntity() {

        Set<Tag> tagEntities = this.collectTags(tags);

        return new Topic(title, url, tagEntities);
    }

    public Set<Tag> collectTags(Set<TagDTO> tags) {
        return tags.stream().map(TagDTO::buildEntity).collect(Collectors.toSet());
    }
}
