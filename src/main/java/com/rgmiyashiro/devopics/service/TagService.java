package com.rgmiyashiro.devopics.service;

import com.rgmiyashiro.devopics.model.Tag;
import com.rgmiyashiro.devopics.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;

    public List<Tag> findAll() {
        return this.repository.findAll();
    }
}
