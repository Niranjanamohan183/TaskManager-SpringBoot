package com.taskmanager.task_manager.service;


import java.util.List;

import com.taskmanager.task_manager.entity.Task;


public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

    List<Task> getTasksByStatus(String status);
}
