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
import com.lolmains.domains.Champion;
import com.lolmains.domains.ChampionSpells;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.ChampionSpellDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.MainsDao;



@Service
public class ChampionSpellsServiceImpl implements ChampionSpellService {
	

	@Autowired
	ChampionSpellDao championspelldao;

	@Override
	public List<ChampionSpells> getAll() {
		// TODO Auto-generated method stub
		return championspelldao.findAll();
	}

	@Override
	public ChampionSpells addChampionSpells(ChampionSpells ChampionSpells) {
		// TODO Auto-generated method stub
		return championspelldao.save(ChampionSpells);
	}

	@Override
	public ChampionSpells findChampionSpells(int id) {
		// TODO Auto-generated method stub
		return championspelldao.findOne(id);
	}

	@Override
	public List<ChampionSpells> findByNameIgnoreCaseContaining(String name) {
		// TODO Auto-generated method stub
		return championspelldao.findByNameIgnoreCaseContaining(name);
	}
	
}
