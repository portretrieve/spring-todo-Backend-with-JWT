package com.devesh.todobackend.TodoService;

import com.devesh.todobackend.Todo_DTO.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {
    private static List<Todo> todoList =  new ArrayList<>();
    private static int counter = 0;

    static {
        todoList.add(new Todo(counter++, "Devesh", "Learn Angular", new Date(), false));
        todoList.add(new Todo(counter++, "Devesh", "Learn React", new Date(), false));
        todoList.add(new Todo(counter++, "Devesh", "Learn Spring", new Date(), false));
    }

    public List<Todo> getAllTodos(){
        return todoList;
    }

    public Todo save(Todo todo){
        if (todo.getId() == -1){
            todo.setId(counter++);
            todoList.add(todo);
        }else {
            deleteById(todo.getId());
            todoList.add(todo);
        }
        return todo;
    }

    public Todo deleteById(long id){
        Todo todo1 = retrieveTodo(id);
        if (null != todo1){
            todoList.remove(todo1);
            return todo1;
        }else {
            return null;
        }
    }

    public static Todo retrieveTodo(long id) {
        Todo todo1 = todoList.stream().filter(todo -> todo.getId() == id)
                .toList().stream().findFirst().orElse(null);
        return todo1;
    }
}