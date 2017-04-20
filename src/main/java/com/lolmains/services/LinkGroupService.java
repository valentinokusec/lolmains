package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.CreateMessage;
import com.lolmains.domains.Guide;
import com.lolmains.domains.LinkGroup;
import com.lolmains.domains.Mains;




@Service
public interface LinkGroupService {
	public List<LinkGroup> getAll();
	public LinkGroup addLinkGroup(LinkGroup LinkGroup);
	public List<LinkGroup> findByMain(Mains main);
	public LinkGroup findAll(int id);

	
} 
