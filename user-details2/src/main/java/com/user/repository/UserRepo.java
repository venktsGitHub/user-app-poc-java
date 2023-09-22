package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{



	User findByUserId(int id);


	

}
