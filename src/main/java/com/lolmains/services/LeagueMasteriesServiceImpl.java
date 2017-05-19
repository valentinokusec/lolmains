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
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueMasteries;
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoners;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.LeagueMasteriesDao;
import com.lolmains.repository.LeagueRunesDao;
import com.lolmains.repository.LeagueSummonersDao;
import com.lolmains.repository.MainsDao;
import com.lolmains.repository.SummonersDao;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;



@Service
public class LeagueMasteriesServiceImpl implements LeagueMasteriesService {
	

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";
	
	
	@Autowired
	 LeagueMasteriesDao  leaguemasteriesdao;


	@Override
	public List<LeagueMasteries> getAll() {
		// TODO Auto-generated method stub
		return leaguemasteriesdao.findAll();
	}


	@Override
	public LeagueMasteries addAll() {
		// TODO Auto-generated method stub
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey(API_KEY);
		List<com.robrua.orianna.type.core.staticdata.Mastery> itemList=RiotAPI.getMasteries();
		for (com.robrua.orianna.type.core.staticdata.Mastery rune:itemList) {
			try {
				LeagueMasteries ls=new LeagueMasteries(4, rune.getID(), rune.getDescription().get(0), rune.getName(),rune.getImage().getFull());
				leaguemasteriesdao.save(ls);
			} catch (Exception e) {
				System.out.println(rune.getID());
			}
		}
		return null;
	}



	@Override
	public LeagueMasteries addLeagueMasteries(LeagueMasteries LeagueMasteries) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public LeagueMasteries findLeagueMasteries(int id) {
		// TODO Auto-generated method stub
		return leaguemasteriesdao.getOne(id);
	}





	@Override
	public List<LeagueMasteries> findByNameIgnoreCaseContaining(String data) {
		// TODO Auto-generated method stub
		return leaguemasteriesdao.findByNameIgnoreCaseContaining(data);
	}



	



	
}
