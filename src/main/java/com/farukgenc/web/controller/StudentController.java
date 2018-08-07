package com.farukgenc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farukgenc.exception.StudentNotFoundException;
import com.farukgenc.service.StudentService;
import com.farukgenc.web.resources.StudentResource;
import com.farukgenc.web.resources.StudentResourceAssembler;
import com.farukgenc.web.resources.SuccessResource;

@RestController
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	private StudentResourceAssembler studentResourceAssembler;

	@Autowired
	public StudentController(StudentService studentService, StudentResourceAssembler studentResourceAssembler) {
		this.studentService = studentService;
		this.studentResourceAssembler = studentResourceAssembler;
	}

	@GetMapping
	public ResponseEntity<List<StudentResource>> getAllStudent() throws StudentNotFoundException {
		return ResponseEntity.ok().body(studentResourceAssembler.toResources(studentService.getAllStudent()));
	}

	@PostMapping
	public ResponseEntity<StudentResource> create(@RequestBody StudentResource studentResource) {
		return ResponseEntity.ok().body(studentResourceAssembler.toResource(studentService.create(studentResource)));
	}

	@GetMapping("/{number}")
	public ResponseEntity<StudentResource> getStudent(@PathVariable Integer number) throws StudentNotFoundException {
		return ResponseEntity.ok().body(studentResourceAssembler.toResource(studentService.getStudent(number)));
	}
	
	@PutMapping
	public ResponseEntity<StudentResource> updateStudent(@RequestBody StudentResource studentResource){
		return ResponseEntity.ok().body(studentResourceAssembler.toResource(studentService.update(studentResource)));
	}
	
	@DeleteMapping("/{number}")
	public ResponseEntity<SuccessResource> delete(@PathVariable Integer number) throws StudentNotFoundException{
		return ResponseEntity.ok().body(studentService.delete(number));
	}


}
