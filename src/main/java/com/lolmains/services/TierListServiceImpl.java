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
import com.lolmains.domains.TierList;
import com.lolmains.domains.User;
import com.lolmains.domains.Discussion;
import com.lolmains.repository.DiscussionDao;
import com.lolmains.repository.TierListDao;



@Service
public class TierListServiceImpl implements TierListService {
	

	@Autowired
	TierListDao tierlistdao;

	@Override
	public List<TierList> getAllTopics() {
		// TODO Auto-generated method stub
		return tierlistdao.findAll();
	}

	@Override
	public TierList addTierList(TierList TierList) {
		// TODO Auto-generated method stub
		return tierlistdao.save(TierList);
	}

	@Override
	public TierList findTTierList(int id) {
		// TODO Auto-generated method stub
		return tierlistdao.findOne(id);
	}

	@Override
	public TierList findAllByMain(Mains main) {
		// TODO Auto-generated method stub
		return tierlistdao.findAllByMain(main);
	}

	

	
}
