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
import com.lolmains.domains.Knowledge;
import com.lolmains.repository.DiscussionDao;
import com.lolmains.repository.KnowledgeDao;



@Service
public class KnowledgeServiceImpl implements KnowledgeService {
	

	@Autowired
	KnowledgeDao knowledgedao;



	@Override
	public List<Knowledge> getAllKnowledge() {
		// TODO Auto-generated method stub
		return knowledgedao.findAll();
	}

	@Override
	public Knowledge addTopic(Knowledge Knowledge) {
		// TODO Auto-generated method stub
		return knowledgedao.save(Knowledge);
	}

	@Override
	public Knowledge findTopic(int id) {
		// TODO Auto-generated method stub
		return knowledgedao.findOne(id);
	}

	@Override
	public Page<Knowledge> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return knowledgedao.findAll(pageable);
	}

	@Override
	public Page<Knowledge> findAllByMain(Pageable pageable, Mains main) {
		// TODO Auto-generated method stub
		return knowledgedao.findAllByMain(pageable, main);
	}

	@Override
	public Page<Knowledge> findAllByMainAndType(Pageable pageable, Mains main, int type) {
		// TODO Auto-generated method stub
		return knowledgedao.findAllByMainAndType(pageable, main, type);
	}

	@Override
	public Knowledge findAllByMainAndTypeAndHeader(Mains main, int i, String header) {
		// TODO Auto-generated method stub
		return knowledgedao.findAllByMainAndTypeAndHeader(main, i, header);
	}

	@Override
	public List<Knowledge> findAllTop1ByMainAndTypeAndHeader(Mains main, int i) {
		// TODO Auto-generated method stub
		return knowledgedao.findAllByMainAndType(main, i);
	}

	@Override
	public int coundByMainAndType(Mains main, int i) {
		// TODO Auto-generated method stub
		return knowledgedao.countByMainAndType(main, i);
	}

	@Override
	public void deleteKnowledge(Knowledge Knowledge) {
		// TODO Auto-generated method stub
		knowledgedao.delete(Knowledge);
	}
	
	

	
	


	
}
