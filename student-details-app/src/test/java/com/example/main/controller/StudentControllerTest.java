package com.example.main.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.main.model.Student;
import com.example.main.service.StudentService;


@WebMvcTest(StudentController.class)
class StudentControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private StudentService studentService;
	
	Student student;
	
	@BeforeEach
	void setUp() throws Exception {
		student = Student.builder().name("Anusha").id(23).build();
	}

	@Test
	void SaveData() throws Exception {
		
		Student input = Student.builder().name("Anusha").build();
		
		Mockito.when(studentService.postStudent(input)).thenReturn(student);
		
		mvc.perform(MockMvcRequestBuilders.post("/students")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{"+
						
							"\"name\":\"Anusha\""
							+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
		
		
		
	}

}
