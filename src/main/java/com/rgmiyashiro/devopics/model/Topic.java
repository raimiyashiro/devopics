package com.rgmiyashiro.devopics.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(unique = true, precision = 50, nullable = false)
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
    private Set<Tag> tags = new HashSet<>();

    @Column(nullable = false)
    private short year = (short) LocalDate.now().getYear();

    @Column(nullable = false)
    private boolean accepted = false;


    public Topic(String title, String url, Set<Tag> tags) {
        this.title = title;
        this.url = url;
        this.tags = tags;
    }
}