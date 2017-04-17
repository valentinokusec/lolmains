package com.lolmains.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.domains.Discussion;



public interface DiscussionDao extends  JpaRepository< Discussion ,Integer>{
	Page<Discussion> findAllByMainAndSticky(Pageable pageable,Mains main, boolean sticky);
	Page<Discussion> findAllByMain(Pageable pageable,Mains main);
	Page<Discussion> findAllByMainAndType(Pageable pageable,Mains main, int type);
	Page<Discussion> findAllByMainAndTypeAndSticky(Pageable pageable,Mains main, int type, boolean sticky);
}
