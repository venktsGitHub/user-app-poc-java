package com.example.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.main.model.Student;
import com.example.main.repository.StudentRepository;


@SpringBootTest
class StudentServiceTest {
	
	@Autowired
	private StudentService service;
	
	@MockBean
	private StudentRepository sRepo;
	

	@BeforeEach
	void setUp() throws Exception {
		
		Student stud  = Student.builder().name("Venkatesh").id(2).build();
		
		Mockito.when(sRepo.findById(2)).thenReturn(stud);
		
		
	}

	@Test
	void whenValidStudentId_thenStudentShouldFound() {
		
		int studentId=2;
		
		Student student = service.getStudent(studentId);
		
		assertEquals(student.getId(), studentId);
		
	}

}
