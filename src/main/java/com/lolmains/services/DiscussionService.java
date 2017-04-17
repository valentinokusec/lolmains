package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;



@Service
public interface DiscussionService {
	public List<Discussion> getAllTopics();
	public Discussion addTopic(Discussion topic);
	public void removeTopic(Discussion topic);
	public Discussion findTopic(int id);
	public Page<Discussion> findAll(Pageable pageable);
	Page<Discussion> findAllByMain(Pageable pageable,Mains main);
	Page<Discussion> findAllByMainAndType(Pageable pageable,Mains main, int type);
	Page<Discussion> findAllByMainAndSticky(Pageable pageable,Mains main, boolean sticky);
	Page<Discussion> findAllByMainAndTypeAndSticky(Pageable pageable,Mains main, int type, boolean sticky);
		
} 
