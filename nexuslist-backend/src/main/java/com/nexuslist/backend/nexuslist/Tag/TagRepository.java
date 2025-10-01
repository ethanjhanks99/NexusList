package com.nexuslist.backend.nexuslist.Tag;

import java.util.Set;

public interface TagRepository {
    
    Set<Tag> findAllById(Set<Long> tagIds);

    Tag findByName(String name);

}
