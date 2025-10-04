package com.example.helloDeveloperMani;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDevelopermaniController {
	@GetMapping("/hlo")
	String helloMani() {
		return "Hello, DeveloperMani";
	}
}
