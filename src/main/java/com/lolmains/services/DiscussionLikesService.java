package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Build;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Guide;
import com.lolmains.domains.User;




@Service
public interface  DiscussionLikesService {
	public  List< DiscussionLikes> getAll();
	public  DiscussionLikes addDiscussionLikes( DiscussionLikes  iscussionLikes);
	public  DiscussionLikes findDiscussionLikesf(int id);
	public DiscussionLikes findByUserAndDiscussion(User user, Discussion discussion);
	List<DiscussionLikes> findByDiscussion( Discussion discussion);
	public void deleteDiscussion(DiscussionLikes  iscussionLikes);
	
} 
