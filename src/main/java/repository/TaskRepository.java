package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(String status);
}
