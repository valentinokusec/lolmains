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
import com.lolmains.domains.Notification;
import com.lolmains.domains.Notification;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;



@Service
public interface NotificationService {
	public void deleteNotification(Notification Notification);
	public Notification addNotification(Notification Notification);
	public Notification findNotification(int id);
	public Page<Notification> findAll(Pageable pageable);

	
} 
