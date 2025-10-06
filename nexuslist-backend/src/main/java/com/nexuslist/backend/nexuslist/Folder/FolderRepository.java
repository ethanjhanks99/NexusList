package com.nexuslist.backend.nexuslist.Folder;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nexuslist.backend.nexuslist.User.User;

public interface FolderRepository extends JpaRepository<Folder, Long>, JpaSpecificationExecutor<Folder> {
    
    Optional<Folder> findByName(String name);

    List<Folder> findByUser(User user);
}
