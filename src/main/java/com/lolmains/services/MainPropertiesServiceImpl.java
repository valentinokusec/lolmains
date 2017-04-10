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

import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.domains.MainsProperties;
import com.lolmains.domains.Summoner;
import com.lolmains.repository.MainsDao;
import com.lolmains.repository.MainsPropertyDao;



@Service
public class MainPropertiesServiceImpl implements MainPropertiesService {
	

	@Autowired
	MainsPropertyDao mainpropertydao;

	@Override
	public List<MainsProperties> getAllMains() {
		// TODO Auto-generated method stub
		return mainpropertydao.findAll();
	}

	@Override
	public MainsProperties addMainsProperties(MainsProperties main) {
		// TODO Auto-generated method stub
		return mainpropertydao.save(main);
	}

	@Override
	public MainsProperties findMainsProperties(int id) {
		// TODO Auto-generated method stub
		return mainpropertydao.findOne(id);
	}
	

}
