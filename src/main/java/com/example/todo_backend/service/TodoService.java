package com.example.todo_backend.service;

import com.example.todo_backend.model.Todo;
import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> getAllTodos();
    Todo createTodo(Todo todo);
    Optional<Todo> getTodoById(Long id);
    Todo updateTodo(Long id, Todo todoDetails);
    void deleteTodo(Long id);
    List<Todo> findByCompleted(boolean completed);
    List<Todo> findByTitleContaining(String title);
}