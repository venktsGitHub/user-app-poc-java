package com.example.main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.main.model.Student;

@Service
public interface StudentService {
	
	public List<Student> getAllStudents();
	public Student postStudent(Student student);
	public Student getStudent(int id) ;
}
