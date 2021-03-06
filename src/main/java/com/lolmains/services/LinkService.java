package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.CreateMessage;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Link;




@Service
public interface LinkService {
	public List<Link> getAll();
	public Link addLink(Link Link);
} 
