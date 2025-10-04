package com.example.helloDeveloperMani;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.helloDeveloperMani.models.Todo;

@Component
public interface TodoRepository extends JpaRepository<Todo, Long> {
	
}
