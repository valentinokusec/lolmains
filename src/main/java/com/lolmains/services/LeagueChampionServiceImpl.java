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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.exception.ConstraintViolationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.domains.ChampionSpells;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Item;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.repository.DiscussionDao;
import com.lolmains.repository.ItemDao;
import com.lolmains.repository.LeagueChampionDao;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.staticdata.ChampionSpell;





@Service
public class LeagueChampionServiceImpl implements LeagueChampionService {
	
	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	@Autowired
	private LeagueChampionDao leaguechampiondao;
	@Autowired
	private ChampionSpellService championservicedao;

	@Override
	public List<LeagueChampion> getAllLeagueChampion() {
		// TODO Auto-generated method stub
		return leaguechampiondao.findAll();
	}

	@Override
	public LeagueChampion addLeagueChampion(Item LeagueChampion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeagueChampion addAll() {
		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey(API_KEY);
		List<com.robrua.orianna.type.core.staticdata.Champion> itemList=RiotAPI.getChampions();
		for (com.robrua.orianna.type.core.staticdata.Champion item:itemList) {
			try {
			
				LeagueChampion ch=new LeagueChampion();
				
				List<ChampionSpells> csList=new ArrayList<ChampionSpells>();
				
				for (ChampionSpell spell:item.getSpells()) {
					ChampionSpells cs = new ChampionSpells(spell.getKey(),spell.getImage().getFull(),spell.getCooldownBurn(),spell.getCostBurn(),spell.getDescription(),5);
					championservicedao.addChampionSpells(cs);
					csList.add(cs);
				}
				ch.setSpells(csList);
			
				ch.setChampion_detail_id(item.getID());
				
				ch.setName(item.getName());
				ch.setType(1);
				ch.setImage(item.getImage().getFull());
				leaguechampiondao.save(ch);
			} catch (Exception e) {
				System.out.println(item.getID());
			}
		}
		return null;
	}

	@Override
	public LeagueChampion findLeagueChampion(int id) {
		// TODO Auto-generated method stub
		return leaguechampiondao.findOne(id);
	}

	@Override
	public List<LeagueChampion> findByNameIgnoreCaseContaining(String string) {
		// TODO Auto-generated method stub
		return leaguechampiondao.findByNameIgnoreCaseContaining(string);
	}



	@Override
	public LeagueChampion findByChampionid(Long id) {
		// TODO Auto-generated method stub
		return leaguechampiondao.findByChampionid(id);
	}



	

	


	
}
