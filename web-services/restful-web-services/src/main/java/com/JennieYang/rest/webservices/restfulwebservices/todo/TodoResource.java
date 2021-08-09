package com.JennieYang.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
//what we are doing here is to follow the HTTP standards
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        // Thread.sleep(3000);
        return todoService.findAll();
    }

    // DELETE /users/{username}/todos/{id}
    @DeleteMapping("/users/{username}/todos/{id}")
    //ResponseEntity--help return a specific type
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {

        Todo todo = todoService.deleteById(id);

        if (todo != null) {
            //if you delete it successfully. return no content
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    //Get
    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        // Thread.sleep(3000);
        return todoService.findById(id);
    }

    //Edit/Update a todo
    //PUT /users/{user_name}/todos/{todo_id}
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable String username,
            @PathVariable long id, @RequestBody Todo todo){

        Todo todoUpdated = todoService.save(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    //Post--Create a new todo
    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(
            @PathVariable String username, @RequestBody Todo todo){

        Todo createdTodo = todoService.save(todo);

        //Location
        //Get current resource url
        ///{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        //return the status created, and return the url
        return ResponseEntity.created(uri).build();
    }
}
