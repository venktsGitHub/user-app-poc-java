package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.main.model.Student;
import com.example.main.service.StudentService;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	
	@GetMapping
	public List<Student> getAllStudents(){
		
//		Student stu = new Student();
//		stu.builder().id(0).name(null).build();
		
		return sService.getAllStudents();
	}
	
	@PostMapping
	public Student postStudent(@RequestBody Student student) {
		
		return sService.postStudent(student);
	}
	
	@GetMapping("{id}")
	public Student getStudent(@PathVariable int id) {
	//	System.out.println("RGSH");
		return sService.getStudent(id);
	} 
	

}
