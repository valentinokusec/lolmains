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
import org.springframework.stereotype.Service;

import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.MainsDao;



@Service
public class GuideServiceImpl implements GuideService {
	

	@Autowired
	GuideDao guidedao;

	@Override
	public List<Guide> getAllGuide() {
		// TODO Auto-generated method stub
		return guidedao.findAll();
	}

	@Override
	public Guide addMain(Guide guide) {
		// TODO Auto-generated method stub
		return guidedao.save(guide);
	}

	@Override
	public Guide findMain(int id) {
		// TODO Auto-generated method stub
		return guidedao.findOne(id);
	}

	@Override
	public Guide findByName(String name) {
		// TODO Auto-generated method stub
		return guidedao.findByName(name);
	}
	


	
}
