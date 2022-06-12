package com.example.SimpleRestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping(value="hello")
public class SimpleRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestServiceApplication.class, args);
	}

	@GetMapping("/{firstName}")
	public String helloGet(@PathVariable("firstName") String firstName,@RequestParam("lastName") String lastName){
		return String.format(
				"{\"message\":\"Hello %s %s\"}",
				firstName, lastName);
	}

	@PostMapping
	public String helloPost(@RequestBody HelloRequest hi){
		return String.format(
				"{\"message\":\"Hello %s %s\"}",
				hi.getFirstName(), hi.getLastName());
	}
	}

class HelloRequest{
	String firstName;
	String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
