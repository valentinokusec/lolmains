package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Comment;



@Service
public interface CommentService {
	public List<Comment> getAllComments();
	public Comment addComment(Comment comment);
	public Comment findComment(int id);
	public List<Comment> findByDiscussionId(int id);
	public int countIdfindByDiscussionId(int id);
	
} 
