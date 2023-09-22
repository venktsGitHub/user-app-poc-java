package com.example.main.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.main.model.Student;




@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

	@Autowired
	private StudentRepository sRepository;
	
	@Autowired
	private TestEntityManager tManager;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Hello----------------");
		Student stud = Student.builder().name("Kamlesh").id(2).build();
		System.out.println(stud);
		System.out.println(tManager.merge(stud));
		
	}

	@Test
	void whenValidId_thenStudent() {
		System.out.println("Hello----------------12");
		Student student = sRepository.findById(2);
		System.out.println("Hello---------------1212-");
		System.out.println(student);
		
		assertEquals(student.getName(), "Kamlesh");
		
	}

}
