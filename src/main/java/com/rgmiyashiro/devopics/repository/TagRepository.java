package com.rgmiyashiro.devopics.repository;

import com.rgmiyashiro.devopics.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
}
