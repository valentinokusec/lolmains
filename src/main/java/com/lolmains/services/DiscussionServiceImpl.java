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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.domains.Discussion;
import com.lolmains.repository.DiscussionDao;



@Service
public class DiscussionServiceImpl implements DiscussionService {
	

	@Autowired
	DiscussionDao topicdao;

	@Override
	public List<Discussion> getAllTopics() {
		// TODO Auto-generated method stub
		return topicdao.findAll();
	}

	@Override
	public Discussion addTopic(Discussion topic) {
		// TODO Auto-generated method stub
		return topicdao.save(topic);
	}

	@Override
	public Discussion findTopic(int id) {
		// TODO Auto-generated method stub
		return topicdao.findOne(id);
	}

	@Override
	public Page<Discussion> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return topicdao.findAll(pageable);
	}

	@Override
	public Page<Discussion> findAllByMain(Pageable pageable, Mains main) {
		// TODO Auto-generated method stub
		return topicdao.findAllByMain(pageable, main);
	}

	@Override
	public Page<Discussion> findAllByMainAndType(Pageable pageable, Mains main, int type) {
		// TODO Auto-generated method stub
		return topicdao.findAllByMainAndType(pageable, main, type);
	}

	@Override
	public void removeTopic(Discussion topic) {
		// TODO Auto-generated method stub
		topicdao.delete(topic);
	}
	


	
}
