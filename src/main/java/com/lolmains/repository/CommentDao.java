package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Comment;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;



public interface CommentDao extends  JpaRepository< Comment ,Integer>{

	public List<Comment> findByDiscussionId(int id);
	public int countIdfindByDiscussionId(int id);
}
