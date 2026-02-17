package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Task;
import exception.ResourceNotFoundException;
import repository.TaskRepository;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repo;

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task getTaskById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

    public Task updateTask(Long id, Task task) {
        Task existing = getTaskById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setStatus(task.getStatus());
        return repo.save(existing);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }

    public List<Task> getTasksByStatus(String status) {
        return repo.findByStatus(status);
    }
}

