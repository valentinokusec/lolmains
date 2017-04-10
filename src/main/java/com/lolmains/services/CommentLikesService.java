package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Build;
import com.lolmains.domains.Comment;
import com.lolmains.domains.CommentLikes;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Guide;
import com.lolmains.domains.User;




@Service
public interface  CommentLikesService {
	public  List< CommentLikes> getAll();
	public  CommentLikes addCommentLikes( CommentLikes  CommentLikes);
	public  CommentLikes findCommentLikes(int id);
	public  CommentLikes findByUserAndComment(User user, Comment comment);
	
} 
