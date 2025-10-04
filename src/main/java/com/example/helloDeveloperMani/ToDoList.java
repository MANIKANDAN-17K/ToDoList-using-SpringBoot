package com.example.helloDeveloperMani;

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
		String saySomething(@PathVariable int id) {
			return "the ToDo list id is "+ id;
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
			
			return new ResponseEntity<>(todoService.createTodo(todo),HttpStatus.CREATED);
		} 
		@DeleteMapping("/deleteUser")
		String deleteUser(@RequestParam int id) {
			return "the deleted id is "+id;
		}
		
}
