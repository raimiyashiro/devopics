package com.rgmiyashiro.devopics.dto;

import com.rgmiyashiro.devopics.model.Tag;
import com.rgmiyashiro.devopics.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class TopicDTO {

    private String title;
    private String url;
    private Set<TagDTO> tags = new HashSet<>();

    public Topic buildEntity() {

        Set<Tag> tagEntities = this.collectTags(tags);

        return new Topic(this.title, this.url, tagEntities);
    }

    public Set<Tag> collectTags(Set<TagDTO> tags) {
        if(tags == null) {
            return new HashSet<>();
        }
        return tags.stream().map(TagDTO::buildEntity).collect(Collectors.toSet());
    }
}
