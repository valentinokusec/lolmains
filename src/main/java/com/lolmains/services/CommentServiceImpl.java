package com.lolmains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Comment;
import com.lolmains.repository.CommentDao;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentdao;
	
	@Override
	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return commentdao.findAll();
	}

	@Override
	public Comment addComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentdao.save(comment);
	}

	@Override
	public Comment findComment(int id) {
		// TODO Auto-generated method stub
		return commentdao.findOne(id);
	}

	@Override
	public List<Comment> findByDiscussionId(int id) {
		// TODO Auto-generated method stub
		return commentdao.findByDiscussionId(id);
	}

	@Override
	public int countIdfindByDiscussionId(int id) {
		// TODO Auto-generated method stub
		return commentdao.countIdfindByDiscussionId(id);
	}

}
