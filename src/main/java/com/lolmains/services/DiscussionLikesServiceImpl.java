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
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.repository.BestOfDao;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.DiscussionLikesDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.MainsDao;



@Service
public class DiscussionLikesServiceImpl implements DiscussionLikesService {
	

	@Autowired
	DiscussionLikesDao discussionlikesdao;

	@Override
	public List<DiscussionLikes> getAll() {
		// TODO Auto-generated method stub
		return discussionlikesdao.findAll();
	}

	@Override
	public DiscussionLikes addDiscussionLikes(DiscussionLikes iscussionLikes) {
		// TODO Auto-generated method stub
		return discussionlikesdao.save(iscussionLikes);
	}

	@Override
	public DiscussionLikes findDiscussionLikesf(int id) {
		// TODO Auto-generated method stub
		return discussionlikesdao.findOne(id);
	}

	@Override
	public DiscussionLikes findByUserAndDiscussion(User user, Discussion discussion) {
		// TODO Auto-generated method stub
		return discussionlikesdao.findByUserAndDiscussion(user, discussion);
	}

	@Override
	public List<DiscussionLikes> findByDiscussion( Discussion discussion) {
		// TODO Auto-generated method stub
		return discussionlikesdao.findByDiscussion( discussion);
	}

	@Override
	public void deleteDiscussion(DiscussionLikes  iscussionLikes) {
		// TODO Auto-generated method stub
		discussionlikesdao.delete(iscussionLikes);
	}



	


	


	
}
