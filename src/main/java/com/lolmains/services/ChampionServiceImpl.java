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

import com.lolmains.domains.Champion;
import com.lolmains.domains.Mains;
import com.lolmains.repository.ChampionDao;
import com.lolmains.repository.LeagueChampionDao;
import com.lolmains.repository.MainsDao;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.championmastery.ChampionMastery;
import com.robrua.orianna.type.core.common.Season;
import com.robrua.orianna.type.core.stats.ChampionStats;
import com.robrua.orianna.type.core.stats.PlayerStatsSummary;
import com.robrua.orianna.type.core.stats.PlayerStatsSummaryType;
import com.robrua.orianna.type.core.summoner.Summoner;



@Service
public class ChampionServiceImpl implements ChampionService {
	

	@Autowired
	ChampionDao championdao;
	@Autowired
	LeagueChampionDao Leaguechampiondao;
	
	@Override
	public List<Champion> addChampion(String server,String summonerName) {
		// TODO Auto-generated method stub
		
		Summoner summoner = RiotAPI.getSummonerByName(summonerName);
	
		List<Champion> chList=new ArrayList<Champion>();
		JSONArray details=getChampionList(summoner);
		for(int i=0;i<details.length();i++)
		{
			JSONObject champion=details.getJSONObject(i);
		Champion ch= new Champion();
		for(ChampionMastery cm:summoner.getChampionMastery())
		{
			if(cm.getChampion().getName().contains("Kindred"))
			{
				ch.setChampionPoints(cm.getChampionPoints());
			}
		}
		ch.setLeaguechampion(Leaguechampiondao.findByName(champion.getString("name")));
		ch.setName(champion.getString("name"));
		ch.setSummoner(summoner.getName());
		ch.setKills(champion.getDouble("kills_per_game"));
		ch.setDeaths(champion.getDouble("deaths_per_game"));
		ch.setAssists(champion.getDouble("assists_per_game"));
		ch.setGames(champion.getInt("games_played"));
		ch.setWinrate(champion.getDouble("winrate"));
		String tier;
		try {
			tier = RiotAPI.getLeagueEntriesBySummonerName(summonerName).get(0).getTier() + " "
					+ RiotAPI.getLeagueEntriesBySummonerName(summonerName).get(0).getEntries().iterator().next()
							.getDivision();
		} catch (Exception e) {
			tier = "Unranked";
		}
		ch.setTier(tier);
		championdao.save(ch);
		chList.add(ch);
		}
		return chList;
	}

	@Override
	public Champion findChampion(int id) {
		// TODO Auto-generated method stub
		return championdao.findOne(id);
	}
	
	private JSONArray getChampionList(Summoner summoner) {
		// TODO Auto-generated method stub
		Map<com.robrua.orianna.type.core.staticdata.Champion, ChampionStats> champions;
		Map<PlayerStatsSummaryType, PlayerStatsSummary> que;
		JSONArray championList = new JSONArray();
		JSONArray allChampionList = new JSONArray();
		try {
			boolean first_time = true;
			champions = summoner.getRankedStats(Season.SEASON2016);
			for (Entry<com.robrua.orianna.type.core.staticdata.Champion, ChampionStats> entry : champions.entrySet()) {
				JSONObject allChampion = new JSONObject();
				JSONObject champion = new JSONObject();
				if (entry.getValue().getChampion() == null) {
					champion = getStatsObject(entry, "all");
					allChampion = getStatsObject(entry, "all");
					championList.put(champion);
				} else  {
					first_time = false;
					champion = getStatsObject(entry, entry.getValue().getChampion().getName());
					allChampion = getStatsObject(entry, entry.getValue().getChampion().getName());
					championList.put(champion);
				} 

				allChampionList.put(allChampion);

			}
		


			//championList.put(getSortedList(allChampionList));
		} catch (Exception e) {
			JSONObject champion1 = new JSONObject();
			que = summoner.getStats(Season.SEASON2016);
			
			
				JSONObject champion = new JSONObject();
				
					champion.put("name", "unranked");
					champion.put("games_played", 0);
					champion.put("kills", round(0, 1));
					champion.put("assists", round(0, 1));
					champion.put("deaths", round(0, 1));
					champion.put("loses", 0);
					champion.put("wins", 0);

					NumberFormat formatter = new DecimalFormat("#0.0");
					NumberFormat formatter_winrate = new DecimalFormat("#0.00");
					Double killsPerGame;
					Double deathsPerGame;
					Double assistsPerGame;
				

				
						killsPerGame = 0d;
						deathsPerGame = 0d;
						assistsPerGame = 0d;
					

					Double winrate = 0d;
				
						champion.put("kda", 0);
					
					champion.put("kills_per_game", formatter.format(killsPerGame));
					champion.put("deaths_per_game", formatter.format(deathsPerGame));
					champion.put("assists_per_game", formatter.format(assistsPerGame));

					champion.put("winrate", round(winrate, 2));
					Double loserate = 1 - winrate;
					champion.put("loserate", round(loserate, 2));
					championList.put(champion);
				

			
			champion1.put("name", "First time");
			champion1.put("games_played", 0);
			champion1.put("kills", 0);
			champion1.put("assists", 0);
			champion1.put("deaths", 0);
			champion1.put("loses", 0);
			champion1.put("wins", 0);
			champion1.put("kda", 0);

			champion1.put("kills_per_game", Integer.toString(0));
			champion1.put("deaths_per_game", Integer.toString(0));
			champion1.put("assists_per_game", Integer.toString(0));

			champion1.put("winrate", Integer.toString(0));

			champion1.put("loserate", Integer.toString(0));

			championList.put(champion1);
			championList.put("noPrefferedChamps");
		}
		//championList.put(new JSONObject().put("history", "none"));
		return championList;
	}

	private JSONArray getSortedList(JSONArray allChampionList) {
		JSONArray sortedJsonArray = new JSONArray();
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		for (int i = 0; i < allChampionList.length(); i++) {
			jsonList.add(allChampionList.getJSONObject(i));
		}
		Collections.sort(jsonList, new Comparator<JSONObject>() {

			public int compare(JSONObject a, JSONObject b) {
				Integer valA = 0;
				Integer valB = 0;

				try {
					valA = (Integer) a.get("games_played");
					valB = (Integer) b.get("games_played");
				} catch (JSONException e) {
					// do something
				}

				return valA.compareTo(valB);
			}
		});
		for (int i = 0; i < allChampionList.length(); i++) {
			sortedJsonArray.put(jsonList.get(i));
		}
		JSONArray champion_sorted = new JSONArray();
		for (int i = sortedJsonArray.length() - 1; i > sortedJsonArray.length() - 5; i--) {
			champion_sorted.put(sortedJsonArray.get(i));
			if (i == 0) {
				i = sortedJsonArray.length() - 5;
			}
		}
		champion_sorted.remove(0);
		return champion_sorted;
	}

	private JSONObject getStatsObject(Entry<com.robrua.orianna.type.core.staticdata.Champion, ChampionStats> entry, String string) {
		JSONObject champion = new JSONObject();
		champion.put("name", string);
		if (string.equals("all")) {
			champion.put("champion_key", "all");
		} else {
			com.robrua.orianna.type.core.staticdata.Champion ch = RiotAPI.getChampionByName(string);
			champion.put("champion_key", ch.getKey());
		}
	
		champion.put("games_played", entry.getValue().getStats().getTotalGamesPlayed());
		champion.put("kills", round(entry.getValue().getStats().getTotalKills(), 1));
		champion.put("assists", round(entry.getValue().getStats().getTotalAssists(), 1));
		champion.put("deaths", round(entry.getValue().getStats().getTotalDeaths(), 1));
		champion.put("loses", entry.getValue().getStats().getTotalLosses());
		champion.put("wins", entry.getValue().getStats().getTotalWins());
		NumberFormat formatter = new DecimalFormat("#0.0");
		NumberFormat formatter_winrate = new DecimalFormat("#0.00");

		Double killsPerGame = (double) (entry.getValue().getStats().getTotalKills())
				/ (double) (entry.getValue().getStats().getTotalGamesPlayed());
		Double deathsPerGame = (double) (entry.getValue().getStats().getTotalDeaths())
				/ (double) (entry.getValue().getStats().getTotalGamesPlayed());
		Double assistsPerGame = (double) (entry.getValue().getStats().getTotalAssists())
				/ (double) (entry.getValue().getStats().getTotalGamesPlayed());
		Double winrate = (double) (entry.getValue().getStats().getTotalWins())
				/ (double) (entry.getValue().getStats().getTotalGamesPlayed()) * 100;
		if (deathsPerGame == 0) {
			champion.put("kda", round((killsPerGame + assistsPerGame), 2));
		} else {
			champion.put("kda", round((killsPerGame + assistsPerGame) / deathsPerGame, 2));
		}
		
		champion.put("kills_per_game",  round(killsPerGame,2));
		champion.put("deaths_per_game", round(deathsPerGame,2));
		champion.put("assists_per_game", round(assistsPerGame,2));

		champion.put("winrate", round(winrate, 2));
		Double loserate = 1 - winrate;
		champion.put("loserate", round(loserate, 2));
		return champion;
	}
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
}
