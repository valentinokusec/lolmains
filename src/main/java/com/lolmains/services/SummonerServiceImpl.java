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

import com.lolmains.domains.Build;
import com.lolmains.domains.Champion;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoners;
import com.lolmains.forms.CreateUser;
import com.lolmains.repository.BuildDao;
import com.lolmains.repository.GuideDao;
import com.lolmains.repository.MainsDao;
import com.lolmains.repository.SummonerDao;
import com.lolmains.repository.SummonersDao;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.common.Season;
import com.robrua.orianna.type.core.staticdata.Rune;
import com.robrua.orianna.type.core.stats.ChampionStats;
import com.robrua.orianna.type.core.stats.PlayerStatsSummary;
import com.robrua.orianna.type.core.stats.PlayerStatsSummaryType;
import com.robrua.orianna.type.core.summoner.RunePage;
import com.robrua.orianna.type.core.summoner.Summoner;



@Service
public class SummonerServiceImpl implements SummonerService {
	

	@Autowired
	SummonerDao summonersdao;



	@Override
	public com.lolmains.domains.Summoner addSummoners(CreateUser CreateUser, List<Champion> cha) {
		
		Summoner summoner = RiotAPI.getSummonerByName(CreateUser.getSummoner());
		JSONArray details=getChampionList(summoner,"");
		JSONObject champion=details.getJSONObject(0);
		com.lolmains.domains.Summoner ch= new com.lolmains.domains.Summoner();
		ch.setRegion(CreateUser.getServer());
		ch.setSummonerid(summoner.getID());
		ch.setKills(champion.getDouble("kills_per_game"));
		ch.setDeaths(champion.getDouble("deaths_per_game"));
		ch.setAssists(champion.getDouble("assists_per_game"));
		ch.setGames(champion.getInt("games_played"));
		ch.setWinrate(champion.getDouble("winrate"));
		ch.setName(summoner.getName());
		List<Champion> chList=cha;
		
		ch.setChampion(chList);
		int tiernumber=0;
		String tier;
		try {
			tier = RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getTier() + " "
					+ RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getEntries().iterator().next()
							.getDivision();
			if(RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getTier().equals("Bronze")){
				tiernumber+=6*0;
			}
			else if(RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getTier().equals("Silver")){
				tiernumber+=6*1;
			}
			else if(RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getTier().equals("Gold")){
				tiernumber+=6*2;
			}
			else if(RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getTier().equals("Platinum")){
				tiernumber+=6*3;
			}
			else if(RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getTier().equals("Diamond")){
				tiernumber+=6*4;
			}
			else if(RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getTier().equals("Master")){
				tiernumber+=6*5;
			}
			else if(RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getTier().equals("Challenger")){
				tiernumber+=6*6;
			}
			if (RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getEntries().iterator().next()
							.getDivision().equals("V")) {
				tiernumber+=1;
				
			}
			else if (RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getEntries().iterator().next()
					.getDivision().equals("IV")) {
		tiernumber+=2;
		
	}
			else if (RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getEntries().iterator().next()
					.getDivision().equals("III")) {
		tiernumber+=3;
		
	}
			else if (RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getEntries().iterator().next()
					.getDivision().equals("II")) {
		tiernumber+=4;
		
	}
			else if (RiotAPI.getLeagueEntriesBySummonerName(CreateUser.getSummoner()).get(0).getEntries().iterator().next()
					.getDivision().equals("I")) {
		tiernumber+=5;
		
	}
		} catch (Exception e) {
			tier = "Unranked";
		}
		ch.setTier(tier);
		ch.setNotificationcount(0);
		ch.setTierNumber(tiernumber);
		ch.setImage(summoner.getProfileIconID());
		
		// TODO Auto-generated method stub
		return summonersdao.save(ch);
	}


	private JSONArray getChampionList(Summoner summoner, String name) {
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
				} else if (entry.getValue().getChampion().toString().contains(name)) {
					first_time = false;
					champion = getStatsObject(entry, entry.getValue().getChampion().getName());
					allChampion = getStatsObject(entry, entry.getValue().getChampion().getName());
					championList.put(champion);
				} else {
					allChampion = getStatsObject(entry, entry.getValue().getChampion().getName());
				}

				allChampionList.put(allChampion);

			}
			JSONObject champion = new JSONObject();
			if (first_time) {
				champion.put("name", "First time");
				champion.put("games_played", 0);
				champion.put("kills", 0);
				champion.put("assists", 0);
				champion.put("deaths", 0);
				champion.put("loses", 0);
				champion.put("wins", 0);
				champion.put("kda", 0);
				NumberFormat formatter = new DecimalFormat("#0.0");
				NumberFormat formatter_winrate = new DecimalFormat("#0.00");

				champion.put("kills_per_game", Integer.toString(0));
				champion.put("deaths_per_game", Integer.toString(0));
				champion.put("assists_per_game", Integer.toString(0));

				champion.put("winrate", Integer.toString(0));

				champion.put("loserate", Integer.toString(0));
				championList.put(champion);
			}

			championList.put(getSortedList(allChampionList));
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
		championList.put(new JSONObject().put("history", "none"));
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


	@Override
	public List<com.lolmains.domains.Summoner> getAll() {
		// TODO Auto-generated method stub
		return summonersdao.findAll();
	}


	@Override
	public com.lolmains.domains.Summoner findSummoners(int id) {
		// TODO Auto-generated method stub
		return summonersdao.findOne(id);
	}


	@Override
	public com.lolmains.domains.Summoner findByName(String name) {
		// TODO Auto-generated method stub
		return summonersdao.findByName(name);
	}


	@Override
	public com.lolmains.domains.Summoner findByMain(Mains main) {
		// TODO Auto-generated method stub
		return summonersdao.findByMain(main);
	}


	@Override
	public boolean checkcode(com.lolmains.domains.Summoner ssummoner, String code) {
		// TODO Auto-generated method stub
		Summoner summoner = RiotAPI.getSummonerByName(ssummoner.getName());
		for(RunePage runes:summoner.getRunePages())
		{
			if (code.equals(runes.getName())) {
				return true;
			}		
		}
		return false;
	}


	@Override
	public com.lolmains.domains.Summoner addSummoners(com.lolmains.domains.Summoner summoner) {
		// TODO Auto-generated method stub
		return summonersdao.save(summoner);
	}


	@Override
	public Page<com.lolmains.domains.Summoner> findByMain(Pageable page, Mains main) {
		// TODO Auto-generated method stub
		return summonersdao.findByMain(page, main);
	}


	@Override
	public int countByMain(Mains main) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Page<com.lolmains.domains.Summoner> findByMainOrderByTierNumberDesc(Pageable page, Mains main) {
		// TODO Auto-generated method stub
		return summonersdao.findByMainOrderByTierNumberDesc(page, main);
	}


	@Override
	public Page<com.lolmains.domains.Summoner> findByMainOrderByTierNumberAsc(Pageable page, Mains main) {
		// TODO Auto-generated method stub
		return summonersdao.findByMainOrderByTierNumberAsc(page, main);
	}


	@Override
	public Page<com.lolmains.domains.Summoner> findByMainOrderByGamesDesc(Pageable page, Mains main) {
		// TODO Auto-generated method stub
		return summonersdao.findByMainOrderByGamesDesc(page, main);
	}


	@Override
	public Page<com.lolmains.domains.Summoner> findByMainOrderByGamesAsc(Pageable page, Mains main) {
		// TODO Auto-generated method stub
		return summonersdao.findByMainOrderByGamesAsc(page, main);
	}

	
}
