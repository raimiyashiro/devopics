package com.rgmiyashiro.devopics.dto;

import com.rgmiyashiro.devopics.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDTO {

    private UUID id;

    public Tag buildEntity() {
        return new Tag(this.getId());
    }
}
