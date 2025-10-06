package com.example.helloDeveloperMani;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloDeveloperMani.models.Todo;
@RestController
@RequestMapping("/api")
public class ToDoList {
		@Autowired
		private TodoSource todoService;
		
		@GetMapping("/{id}")
		ResponseEntity<Todo> getToDoById(@PathVariable long id) {
			try{
			Todo createToDo = todoService.getTodoById(id);
			return new ResponseEntity<>(createToDo,HttpStatus.OK);
			}catch(RuntimeException e) {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			}
		}
		@GetMapping("/create")
		String sayHai(@RequestParam String name,
					  @RequestParam int id) {
			return "the username is "+name+"and teh user id"+id;
		}
		@GetMapping("")
		String sayHlo(@RequestParam("todoId") int id) {
			return "Say  hello the id number "+id;
		}
		@GetMapping("/hru")
		String sayHru() {
			//todoService.printToDo();
			return "how are you ?";
		}
		
		@PostMapping("/input")
		String postMethod(@RequestBody String body) {
			return "valid"+body;
		}
		@PutMapping("/updatename")
		String updateUserID(@RequestParam int id) {
			return "update id is "+id ;
			
		}
		@PutMapping("/updatename/{id}")
		String updateID(@PathVariable int id) {
			return "update id is "+id ;
			
		}
		@PostMapping("/createUser")
		ResponseEntity<Todo> CreateUser(@RequestBody Todo todo) {
			
				Todo createTodo = todoService.createTodo(todo);
				return new ResponseEntity<>(createTodo,HttpStatus.CREATED);
			
		} 
		@DeleteMapping("/{id}")
		void deleteUser(@PathVariable long id) {
			todoService.deleteTodo(id);
		}
		@GetMapping("/todolist")
		ResponseEntity<List<Todo>> getTodos(){
			return new ResponseEntity<List<Todo>>(todoService.getToDos(),HttpStatus.OK);
		}
		@PutMapping("/update")
		ResponseEntity<Todo> updateTodoById(@PathVariable int id, @RequestBody Todo todo){
			return new ResponseEntity<>(todoService.updateTodo(todo),HttpStatus.OK);
		}
		
		
		
		
}
