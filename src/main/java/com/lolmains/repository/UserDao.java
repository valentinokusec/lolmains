package com.lolmains.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


import com.lolmains.domains.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUserName(String user);

	Page<User> findAll(Pageable pageable);

}
