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

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Masteries;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.MainsDao;
import com.lolmains.repository.MasteriesDao;



@Service
public class MasteriesServiceImpl implements MasteriesService {
	

	@Autowired
	MasteriesDao masteriesdao;

	@Override
	public List<Masteries> getAll() {
		// TODO Auto-generated method stub
		return masteriesdao.findAll();
	}

	@Override
	public Masteries addMasteries(Masteries Masteries) {
		// TODO Auto-generated method stub
		return masteriesdao.save(Masteries);
	}

	@Override
	public Masteries findMasteries(int id) {
		// TODO Auto-generated method stub
		return masteriesdao.findOne(id);
	}




	
}
