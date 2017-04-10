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
import com.lolmains.domains.Notification;
import com.lolmains.domains.User;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Knowledge;
import com.lolmains.repository.DiscussionDao;
import com.lolmains.repository.KnowledgeDao;
import com.lolmains.repository.NotificationDao;



@Service
public class NotificationServiceImpl implements NotificationService {
	

	@Autowired
	NotificationDao notificationdao;

	@Override
	public void deleteNotification(Notification Notification) {
		// TODO Auto-generated method stub
		notificationdao.delete(Notification);
	}

	@Override
	public Notification addNotification(Notification Notification) {
		// TODO Auto-generated method stub
		return notificationdao.save(Notification);
	}

	@Override
	public Notification findNotification(int id) {
		// TODO Auto-generated method stub
		return notificationdao.findOne(id);
	}

	@Override
	public Page<Notification> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return notificationdao.findAll(pageable);
	}

	




	
	


	
}
