package com.devesh.todobackend.TodoController;

import com.devesh.todobackend.TodoRepository.TodoJpaRepository;
import com.devesh.todobackend.TodoService.TodoHardCodedService;
import com.devesh.todobackend.Todo_DTO.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin
public class TodoJpaController {

    @Autowired
    private TodoHardCodedService todoHardCodedService;

    @Autowired
    private TodoJpaRepository todoJpaRepo;

    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        var todoList =  todoJpaRepo.findByUsername(username);
        return todoList;
    }

    @GetMapping("/jpa/users/{username}/todos/{todoId}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable long todoId){
        return todoJpaRepo.findById(todoId).get();
    }


    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username,
                                           @RequestBody Todo todo){
        todo.setUsername(username);
        Todo createdTodo = todoJpaRepo.save(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);

    }

    @PutMapping("/jpa/users/{username}/todos/{todoId}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long todoId,
                                           @RequestBody Todo todo){
        todo.setUsername(username);
        Todo updatedTodo = todoJpaRepo.save(todo);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @DeleteMapping("/jpa/users/{username}/todos/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long todoId){
        todoJpaRepo.deleteById(todoId);
        return ResponseEntity.notFound().build();
    }
}
