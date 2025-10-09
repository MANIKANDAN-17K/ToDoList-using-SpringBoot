package com.example.helloDeveloperMani;

import java.util.List;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.helloDeveloperMani.models.Todo;

@Service
public class TodoSource {
	@Autowired
	private TodoRepository todoRepositary;
	
	public Todo createTodo(Todo todo) {
		 return todoRepositary.save(todo);
	}
	public Todo getTodoById(Long id) {
		return todoRepositary.findById(id).orElseThrow(() -> new RuntimeException("todo not found"));
	}
	
	public Page<Todo> getAllTodosPages(int page,int size){
		Pageable pageable = PageRequest.of(page, size);
		return todoRepositary.findAll(pageable);
	}
	
	public List<Todo> getToDos(){
		return todoRepositary.findAll();
	}
	public Todo updateTodo(Todo todo) {
		return todoRepositary.save(todo);
	}
	public void deleteTodo(long id) {
		
		 todoRepositary.delete(getTodoById(id));
	}
	
	
}
