package com.lolmains.facade;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Item;
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Masteries;
import com.lolmains.domains.Runes;
import com.lolmains.domains.Summoners;
import com.lolmains.domains.User;
import com.lolmains.forms.CreateGuide;
import com.lolmains.services.BestOfService;
import com.lolmains.services.BuildService;
import com.lolmains.services.ChampionService;
import com.lolmains.services.CommentService;
import com.lolmains.services.DiscussionService;
import com.lolmains.services.GuideService;
import com.lolmains.services.ItemService;
import com.lolmains.services.LeagueChampionService;
import com.lolmains.services.LeagueRunesService;
import com.lolmains.services.LeagueSummonersService;
import com.lolmains.services.MainsService;
import com.lolmains.services.MasteriesService;
import com.lolmains.services.RunesService;
import com.lolmains.services.SummonerService;
import com.lolmains.services.SummonersService;
import com.lolmains.services.UserService;

@Service
public class EditFacadeImpl implements EditFacade{

	
	@Autowired
	MainsService mainsservice;


	@Autowired
	DiscussionService discussionservice;

	@Autowired
	UserService userservice;

	@Autowired
	CommentService commentservice;
	
	@Autowired
	MasteriesService masteriesservice;

	@Autowired
	ChampionService championservice;

	@Autowired
	ItemService itemservice;

	@Autowired
	BuildService buildservice;

	@Autowired
	GuideService guideservice;

	@Autowired
	RunesService runesservice;

	@Autowired
	LeagueRunesService leaguerunesservice;
	
	@Autowired
	BestOfService bestofservice;

	@Autowired
	LeagueSummonersService leaguesummonersservice;

	@Autowired
	SummonersService summonersservice;
	
	@Autowired
	SummonerService summonerservice;

	@Autowired
	LeagueChampionService leaguechampionservice;
	
	@Override
	public Guide editGuide(CreateGuide CreateGuide) {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user= userservice.findByUserName(name);
		Mains mains=mainsservice.findMain(CreateGuide.getMain());
//		String url = CreateTopic.getVideo();
//		
//		url = url.substring(32);
//		String url_list[] = url.split("&");
//		url = url_list[0];
//		topic.setVideo(url);
//		topic.setUrl(CreateTopic.getUrl());
		// Champion ch=championservice.findChampion(1);

		
		Guide guide=guideservice.findMain(CreateGuide.getGuide());
		guide.setName(CreateGuide.getName());
		guide.setContent(CreateGuide.getGeneralDescription());
		guide.setUser( user.getSummoner());
		guide.setDate(new Timestamp(System.currentTimeMillis()));
		
		guide.setMain(mains);

		Item it1 = itemservice.findByItemId(CreateGuide.getParam1());
		Item it2 = itemservice.findByItemId(CreateGuide.getParam2());
		Item it3 = itemservice.findByItemId(CreateGuide.getParam3());
		Item it4 = itemservice.findByItemId(CreateGuide.getParam4());
		Item it5 = itemservice.findByItemId(CreateGuide.getParam5());
		Item it6 = itemservice.findByItemId(CreateGuide.getParam6());
		
		Build build = new Build(CreateGuide.getBuildDescription(), it1, it2, it3, it4, it5, it6);
		
		buildservice.addBuild(build);

		guide.setBuild(build);

		LeagueRunes lr1 = leaguerunesservice.findByRuneid(CreateGuide.getParam9());
		LeagueRunes lr2 = leaguerunesservice.findByRuneid(CreateGuide.getParam10());
		LeagueRunes lr3 = leaguerunesservice.findByRuneid(CreateGuide.getParam11());
		LeagueRunes lr4 = leaguerunesservice.findByRuneid(CreateGuide.getParam12());
		LeagueRunes lr5 = leaguerunesservice.findByRuneid(CreateGuide.getParam13());
		LeagueRunes lr6 = leaguerunesservice.findByRuneid(CreateGuide.getParam14());
		LeagueRunes lr7 = leaguerunesservice.findByRuneid(CreateGuide.getParam15());
		LeagueRunes lr8 = leaguerunesservice.findByRuneid(CreateGuide.getParam16());
		LeagueRunes lr9 = leaguerunesservice.findByRuneid(CreateGuide.getParam17());
		
		LeagueRunes lr10 = leaguerunesservice.findByRuneid(CreateGuide.getParam18());
		LeagueRunes lr11 = leaguerunesservice.findByRuneid(CreateGuide.getParam19());
		LeagueRunes lr12 = leaguerunesservice.findByRuneid(CreateGuide.getParam20());
		LeagueRunes lr13 = leaguerunesservice.findByRuneid(CreateGuide.getParam21());
		LeagueRunes lr14 = leaguerunesservice.findByRuneid(CreateGuide.getParam22());
		LeagueRunes lr15 = leaguerunesservice.findByRuneid(CreateGuide.getParam23());
		LeagueRunes lr16 = leaguerunesservice.findByRuneid(CreateGuide.getParam24());
		LeagueRunes lr17 = leaguerunesservice.findByRuneid(CreateGuide.getParam25());
		LeagueRunes lr18 = leaguerunesservice.findByRuneid(CreateGuide.getParam26());

		LeagueRunes lr19 = leaguerunesservice.findByRuneid(CreateGuide.getParam27());
		LeagueRunes lr20 = leaguerunesservice.findByRuneid(CreateGuide.getParam28());
		LeagueRunes lr21 = leaguerunesservice.findByRuneid(CreateGuide.getParam29());
		LeagueRunes lr22 = leaguerunesservice.findByRuneid(CreateGuide.getParam30());
		LeagueRunes lr23 = leaguerunesservice.findByRuneid(CreateGuide.getParam31());
		LeagueRunes lr24 = leaguerunesservice.findByRuneid(CreateGuide.getParam32());
		LeagueRunes lr25 = leaguerunesservice.findByRuneid(CreateGuide.getParam33());
		LeagueRunes lr26 = leaguerunesservice.findByRuneid(CreateGuide.getParam34());
		LeagueRunes lr27 = leaguerunesservice.findByRuneid(CreateGuide.getParam35());
		
		LeagueRunes lr28 = leaguerunesservice.findByRuneid(CreateGuide.getParam36());
		LeagueRunes lr29 = leaguerunesservice.findByRuneid(CreateGuide.getParam37());
		LeagueRunes lr30 = leaguerunesservice.findByRuneid(CreateGuide.getParam38());
		
		Runes rune = new Runes(CreateGuide.getRunesDescription(), lr1, lr2, lr3, lr4, lr5, lr6, lr7, lr8, lr9, lr10, lr11, lr12, lr13,
				lr14, lr15, lr16, lr17, lr18, lr19, lr20, lr21, lr22, lr23, lr24, lr25, lr26, lr27, lr28, lr29, lr30);
		
		runesservice.addRunes(rune);
		
		guide.setRunes(rune);

		LeagueSummoners sum1 = leaguesummonersservice.findBySummonersid(CreateGuide.getParam7());

		LeagueSummoners sum2 = leaguesummonersservice.findBySummonersid(CreateGuide.getParam8());

		

		Summoners summs = new Summoners(CreateGuide.getSummonersDescription(), sum1, sum2);

		summonersservice.addSummoners(summs);

		guide.setSummoners(summs);
		
		Masteries masteries=new Masteries(CreateGuide.getMasteriesDescription(), CreateGuide.getParam39(), CreateGuide.getParam40(), CreateGuide.getParam41(), CreateGuide.getParam42(), CreateGuide.getParam43(), CreateGuide.getParam44(), CreateGuide.getParam45(), CreateGuide.getParam46(), CreateGuide.getParam47(), CreateGuide.getParam48(), CreateGuide.getParam49(), CreateGuide.getParam50(), CreateGuide.getParam51(), CreateGuide.getParam52(), CreateGuide.getParam53(), CreateGuide.getParam54(), CreateGuide.getParam55(), CreateGuide.getParam56(), CreateGuide.getParam57(), CreateGuide.getParam58(), CreateGuide.getParam59(), CreateGuide.getParam60(), CreateGuide.getParam61(), CreateGuide.getParam62(), CreateGuide.getParam63(), CreateGuide.getParam64(), CreateGuide.getParam65(), CreateGuide.getParam66(), CreateGuide.getParam67(), CreateGuide.getParam68(), CreateGuide.getParam69(), CreateGuide.getParam70(), CreateGuide.getParam71(), CreateGuide.getParam72(), CreateGuide.getParam73(), CreateGuide.getParam74(), CreateGuide.getParam75(), CreateGuide.getParam76(), CreateGuide.getParam77(), CreateGuide.getParam78(), CreateGuide.getParam79(), CreateGuide.getParam80(), CreateGuide.getParam81(), CreateGuide.getParam82(), CreateGuide.getParam83());
		masteries.setKeystone(CreateGuide.getParam84());
		
		masteriesservice.addMasteries(masteries);
		
		guide.setMasteriesid(masteries);
		
		guideservice.addMain(guide);
		
		List<Guide> chList=mains.getGuide();
		chList.add(guide);
		mains.setGuide(chList);
		mainsservice.addMain(mains);
		return guide;
	}

	@Override
	public BestOf editBestof(CreateGuide CreateGuide) {
		// TODO Auto-generated method stub
		return null;
	}

}
