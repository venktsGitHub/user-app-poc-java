package com.example.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.main.model.Student;
import com.example.main.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	public List<Student> getAllStudents(){
		
	
		return studentRepository.findAll();
	}
	
	
	public Student postStudent(@RequestBody Student student) {
		
		return studentRepository.save(student);
	}
	
	
	public Student getStudent(@PathVariable int id) {
	//	System.out.println("RGSH");
		return studentRepository.findById(id);
	}
}
