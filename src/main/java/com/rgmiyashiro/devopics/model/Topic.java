package com.rgmiyashiro.devopics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    private UUID id;

    @Column(precision = 50, nullable = false)
    private String title;

    @Column(precision = 255, nullable = false)
    private String url;

    @JsonIgnoreProperties("topics")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(
            name = "topic_by_tag",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tag = new HashSet<>();

    @Column(nullable = false)
    private int year;

}