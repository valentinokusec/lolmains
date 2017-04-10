package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Knowledge;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;



@Service
public interface KnowledgeService {
	public List<Knowledge> getAllKnowledge();
	public Knowledge addTopic(Knowledge Knowledge);
	public void deleteKnowledge(Knowledge Knowledge);
	public Knowledge findTopic(int id);
	public Page<Knowledge> findAll(Pageable pageable);
	Page<Knowledge> findAllByMain(Pageable pageable,Mains main);
	Page<Knowledge> findAllByMainAndType(Pageable pageable,Mains main, int type);
	public Knowledge findAllByMainAndTypeAndHeader(Mains main, int i , String header);
	public List<Knowledge> findAllTop1ByMainAndTypeAndHeader(Mains main, int i );
	public int coundByMainAndType(Mains main, int i );
	
} 
