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
import com.lolmains.domains.Runes;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.MainsDao;
import com.lolmains.repository.RunesDao;



@Service
public class RunesServiceImpl implements RunesService {
	

	@Autowired
	RunesDao runesdao;

	@Override
	public List<Runes> getAll() {
		// TODO Auto-generated method stub
		return runesdao.findAll();
	}

	@Override
	public Runes addRunes(Runes Runes) {
		// TODO Auto-generated method stub
		return runesdao.save(Runes);
	}

	@Override
	public Runes findRunes(int id) {
		// TODO Auto-generated method stub
		return runesdao.findOne(id);
	}

	


	


	
}
