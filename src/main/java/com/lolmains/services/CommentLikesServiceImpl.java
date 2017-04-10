package com.lolmains.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.exception.ConstraintViolationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Build;
import com.lolmains.domains.Comment;
import com.lolmains.domains.CommentLikes;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.repository.BestOfDao;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.CommentLikesDao;
import com.lolmains.repository.DiscussionLikesDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.MainsDao;



@Service
public class CommentLikesServiceImpl implements CommentLikesService {
	

	@Autowired
	CommentLikesDao commentlikesdao;

	@Override
	public List<CommentLikes> getAll() {
		// TODO Auto-generated method stub
		return commentlikesdao.findAll();
	}

	@Override
	public CommentLikes addCommentLikes(CommentLikes CommentLikes) {
		// TODO Auto-generated method stub
		return commentlikesdao.save(CommentLikes);
	}

	@Override
	public CommentLikes findCommentLikes(int id) {
		// TODO Auto-generated method stub
		return commentlikesdao.findOne(id);
	}

	@Override
	public CommentLikes findByUserAndComment(User user, Comment comment) {
		// TODO Auto-generated method stub
		return commentlikesdao.findByUserAndComment(user, comment);
	}

	


	


	


	
}
