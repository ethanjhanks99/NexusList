package com.nexuslist.backend.nexuslist.TaskList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexuslist.backend.nexuslist.Folder.Folder;
import com.nexuslist.backend.nexuslist.User.User;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {

    List<TaskList> getByUser(User user);

    List<TaskList> getByFolder(Folder folder);

}
