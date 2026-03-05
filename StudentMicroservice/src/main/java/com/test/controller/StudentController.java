package com.test.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.service.StudentService;

@RestController
public class StudentController {

	protected Logger logger = Logger.getLogger(StudentController.class.getName());
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@PutMapping("/update/{id}")
	public Student updatestudent(@PathVariable int id, @RequestBody Student std) {
		std.setId(id);
		
		return service.updateStudent(std);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Student> deleteStudentById(@PathVariable int id){
		return service.deleteStudentById(id);
	}
	
	@GetMapping("/list")
	public List<Student> getAllStudent(){
		return service.listAllStudent();
	}
}
