package com.nexuslist.backend.nexuslist.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.nexuslist.backend.nexuslist.TaskList.TaskList;
import com.nexuslist.backend.nexuslist.User.User;

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    List<Task> findByTaskList(TaskList list);

    List<Task> findByUser(User user);

    List<Task> findByCompleted(boolean completed);

    List<Task> findByPriority(Priority priority);
}
