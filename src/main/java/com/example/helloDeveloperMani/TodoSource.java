package com.example.helloDeveloperMani;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloDeveloperMani.models.Todo;

@Service
public class TodoSource {
	@Autowired
	private TodoRepository todoRepositary;
	
	public Todo createTodo(Todo todo) {
		 return todoRepositary.save(todo);
	}

	
	
}
