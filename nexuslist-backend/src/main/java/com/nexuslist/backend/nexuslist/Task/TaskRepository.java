package com.nexuslist.backend.nexuslist.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexuslist.backend.nexuslist.TaskList.TaskList;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> getByTaskList(TaskList list);

}
