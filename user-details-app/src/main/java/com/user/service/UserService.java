package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.User;
import com.user.model.Department;
import com.user.model.ResponseObj;
import com.user.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo repo;
	
	@Autowired
	RestTemplate rTemplate;

	public List<User> getAllUsersData() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	public ResponseObj getUserWithDept(int id) {
		
		ResponseObj rs = new ResponseObj();
		User user = repo.findByUserId(id);
		rs.setUser(user);
		
		Department dept = rTemplate.
				getForObject("http://Department-Service/depts/"+user.getDepartmentId(),
						 Department.class);
		
		rs.setDept(dept);
		return rs;
	}
	
	
	
}
