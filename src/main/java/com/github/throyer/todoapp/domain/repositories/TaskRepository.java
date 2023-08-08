package com.github.throyer.todoapp.domain.repositories;

import com.github.throyer.todoapp.domain.entities.Task;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser_Id(Long id);
}
