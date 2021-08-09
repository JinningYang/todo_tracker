package com.JennieYang.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//have a static list of todos-->create a service to retrieve all the todos
@Service
public class TodoHardcodedService {
    private static List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "JennieYang", "Clean the room", new Date(), false));
        todos.add(new Todo(++idCounter, "JennieYang", "Water the plants", new Date(), false));
        todos.add(new Todo(++idCounter, "JennieYang", "Shop for food", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }
    //for updates and inserts
    public Todo save(Todo todo) {
        if(todo.getId()==-1 || todo.getId()==0) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);

        if (todo == null)
            return null;

        if (todos.remove(todo)) {
            return todo;
        }

        return null;
    }

    public Todo findById(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }

        return null;
    }

}
