package com.devesh.todobackend.TodoRepository;

import com.devesh.todobackend.Todo_DTO.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
