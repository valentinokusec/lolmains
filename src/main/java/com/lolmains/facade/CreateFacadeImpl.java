package com.lolmains.facade;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Build;
import com.lolmains.domains.Champion;
import com.lolmains.domains.ChampionSpells;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Item;
import com.lolmains.domains.Knowledge;
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.LinkGroup;
import com.lolmains.domains.Mains;
import com.lolmains.domains.MainsProperties;
import com.lolmains.domains.Masteries;
import com.lolmains.domains.Runes;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.Summoners;
import com.lolmains.domains.User;
import com.lolmains.domains.UserRole;
import com.lolmains.forms.CreateGuide;
import com.lolmains.forms.CreateKnowledge;
import com.lolmains.forms.CreateMember;
import com.lolmains.forms.CreateTopic;
import com.lolmains.forms.CreateUser;
import com.lolmains.services.BestOfService;
import com.lolmains.services.BuildService;
import com.lolmains.services.ChampionService;
import com.lolmains.services.ChampionSpellService;
import com.lolmains.services.DiscussionService;
import com.lolmains.services.GuideService;
import com.lolmains.services.ItemService;
import com.lolmains.services.KnowledgeService;
import com.lolmains.services.LeagueChampionService;
import com.lolmains.services.LeagueRunesService;
import com.lolmains.services.LeagueSummonersService;
import com.lolmains.services.LinkGroupService;
import com.lolmains.services.MainPropertiesService;
import com.lolmains.services.MainsService;
import com.lolmains.services.MasteriesService;
import com.lolmains.services.RunesService;
import com.lolmains.services.SummonerService;
import com.lolmains.services.SummonersService;
import com.lolmains.services.UserService;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;



@Service
public class CreateFacadeImpl implements CreateFacade {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MainPropertiesService mainpropertyservice;
	
	
	
	@Autowired
	ChampionService championservice;
	
	@Autowired
	ChampionSpellService championspell;
	
	@Autowired
	DiscussionService discussionservice;
	
	
	@Autowired
	private KnowledgeService knowledgeservice;
	
	
	@Autowired
	private MainsService mainsservice;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private LeagueChampionService leaguechampionservice;
	
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
	ItemService itemservice;
	
	@Autowired
	BuildService buildservice;
	
	@Autowired
	MasteriesService masteriesservice;
	
	@Autowired
	RunesService runesservice;
	
	@Autowired
	GuideService guideservice;
	
	@Autowired
	LinkGroupService linkgroupservice;
	
	
	@Override
	public Mains createMain(com.lolmains.forms.CreateMain CreateMain) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user=userservice.findByUserName(name);
		Mains main=new Mains();
		Summoner summ=user.getSummoner();
	
		main.setBanner(CreateMain.getBanner());
		main.setName(CreateMain.getName());
		main.setChampion(leaguechampionservice.findByChampionid(CreateMain.getChampion()));
		ArrayList<User> userList=new ArrayList<User>();
		ArrayList<com.lolmains.domains.Summoner> memberList=new ArrayList<com.lolmains.domains.Summoner>();
		userList.add(user);
//		MainsProperties prop=new MainsProperties();
//		prop.setBodycolor("#f1f1f1");
//		prop.setCardcolor("#ffffff");
//		mainpropertyservice.addMainsProperties(prop);
//		main.setMainsproperties(prop);
		
		
		memberList.add(user.getSummoner());
		main.setAdmins(userList);
		main.setSummoner(memberList);
		
		ClassLoader classLoader = getClass().getClassLoader();
		Path newFilePath = Paths.get("src/main/resources/static/css/"+main.getName()+".css");
	    try {
			Files.createFile(newFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mainsservice.addMain(main);
		List<Mains> mainList=summ.getMain();
		mainList.add(main);
		
		summ.setMain(mainList);
		summonerservice.addSummoners(summ);
		return main;
	}


	@Override
	public Guide createPlaystyle(CreateGuide CreateGuide) {
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

		
		
		Guide guide = new Guide(CreateGuide.getName(), CreateGuide.getGeneralDescription(), user.getSummoner(),
				new Timestamp(System.currentTimeMillis()));
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
	public BestOf createBestOf(CreateGuide CreateGuide) {
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

		
		
		BestOf guide = new BestOf(CreateGuide.getName(), CreateGuide.getGeneralDescription(), user.getSummoner(),
				new Timestamp(System.currentTimeMillis()));
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
		
		bestofservice.addBestOf(guide);
		
		mains.setBestof(guide);
		mainsservice.addMain(mains);
		return guide;
	}


	@Override
	public Discussion createDiscussion(CreateTopic CreateTopic) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Mains main=mainsservice.findMain(CreateTopic.getMainsid());
		Discussion topic = new Discussion();
		// topic.setUser(name);
		topic.setMain(main);
		topic.setType(CreateTopic.getType());
		topic.setHeader(CreateTopic.getHeader());
		topic.setContent(CreateTopic.getContent());
		CreateTopic.getBuildlist().remove(CreateTopic.getBuildlist().size()-1);
		List<Item> blist= new ArrayList<Item>();
		for(Integer item:CreateTopic.getBuildlist())
		{
			
			blist.add(itemservice.findByItemId(item));
		
		}
		topic.setSticky(false);
		topic.setBuild(blist);
		topic.setDate(new Timestamp(System.currentTimeMillis()));
		topic.setMathup(leaguechampionservice.findByChampionid(CreateTopic.getParam10()));
		topic.setItemvs0(itemservice.findByItemId(CreateTopic.getParam7()));
		topic.setItemvs1(itemservice.findByItemId(CreateTopic.getParam8()));
		topic.setItem(itemservice.findByItemId(CreateTopic.getParam9()));
		User user=userservice.findByUserName(name);
		
		topic.setUser(user);
		if(CreateTopic.getType()==6)
		{
			String url = CreateTopic.getVideo();
			
			url = url.substring(32);
			String url_list[] = url.split("&");
			url = url_list[0];
			topic.setVideo(url);
		}
		if(CreateTopic.getType()==7)
		{
			String url = CreateTopic.getUrl();
			
			url = url.substring(32);
			String url_list[] = url.split("&");
			url = url_list[0];
			topic.setUrl(url);
		}

	

		discussionservice.addTopic(topic);
		List<Discussion> chList=user.getDiscussion();
		chList.add(topic);
		user.setDiscussion(chList);
		return topic;
	}


	@Override
	public User createUser(CreateUser CreateUser) {
		if (CreateUser.getServer().contentEquals("EUW")) {
			RiotAPI.setRegion(Region.EUW);
		}
		
		RiotAPI.setAPIKey(API_KEY);
		
		List<Champion> ch=championservice.addChampion(CreateUser.getServer(), CreateUser.getSummoner());
		
		com.lolmains.domains.Summoner summs=summonerservice.addSummoners(CreateUser,ch);
		
		String hashedPassword = passwordEncoder.encode(CreateUser.getPassword());

		User user = new User();
		user.setUserName(CreateUser.getUsername());
		user.setPassword(hashedPassword);
		//user.setSummoner(CreateUser.getSummoner());
		UserRole role = new UserRole();
		role.setRole("ADMIN");
		Set<UserRole> userRole = new HashSet<UserRole>();
		userRole.add(role);
		user.setUserRole(userRole);
		user.setSummoner(summs);
		user.setVerified(false);
		
		userservice.create(user);
		return user;
	}


	@Override
	public Mains createMember(CreateMember CreateMember) {
		
		Mains main=mainsservice.findMain(CreateMember.getMainid());
		
		User user= userservice.findByUserName(CreateMember.getUsername());
		
		List<com.lolmains.domains.Summoner> summ=main.getSummoner();
		summ.add(user.getSummoner());
		
		main.setSummoner(summ);

		List<Mains> mainList=user.getSummoner().getMain();
		mainList.add(main);
		user.getSummoner().setMain(mainList);
		userservice.create(user);
		mainsservice.addMain(main);
		return main;
	}


	@Override
	public Knowledge createKnowledge(CreateKnowledge CreateKnowledge) {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Mains main=mainsservice.findMain(CreateKnowledge.getMainsid());
		Knowledge knowledge = new Knowledge();
		// topic.setUser(name);
		knowledge.setMain(main);
		knowledge.setType(CreateKnowledge.getType());
		knowledge.setHeader(CreateKnowledge.getHeader());
		knowledge.setContent(CreateKnowledge.getContent());
		if (CreateKnowledge.getType()==10) {
			LinkGroup lg= linkgroupservice.addLinkGroup(new LinkGroup(CreateKnowledge.getLinkGroup(),main));
			knowledge.setLinkGroup(lg);	
		}
		if (CreateKnowledge.getType()==11) {
			Summoners summ= new Summoners();
			summ.setSummoner1(leaguesummonersservice.findBySummonersid(CreateKnowledge.getParam85()));
			summ.setSummoner2(leaguesummonersservice.findBySummonersid(CreateKnowledge.getParam86()));
			summonersservice.addSummoners(summ);
			knowledge.setSummoners(summ);	
		}
		knowledge.setDate(new Timestamp(System.currentTimeMillis()));
		knowledge.setMathup(leaguechampionservice.findByChampionid(CreateKnowledge.getParam6()));
		
		if(CreateKnowledge.getType()==1)
		{
		for(Integer item:CreateKnowledge.getBuildlist())
		{
			CreateKnowledge.getBuildlist().remove(CreateKnowledge.getBuildlist().size()-1);
			List<Item> blist= new ArrayList<Item>();
			blist.add(itemservice.findByItemId(item));
			knowledge.setBuild(blist);
		
		}
		}
		if(CreateKnowledge.getType()==6)
		{
			Masteries masteries=new Masteries("", CreateKnowledge.getParam39(), CreateKnowledge.getParam40(), CreateKnowledge.getParam41(), CreateKnowledge.getParam42(), CreateKnowledge.getParam43(), CreateKnowledge.getParam44(), CreateKnowledge.getParam45(), CreateKnowledge.getParam46(), CreateKnowledge.getParam47(), CreateKnowledge.getParam48(), CreateKnowledge.getParam49(), CreateKnowledge.getParam50(), CreateKnowledge.getParam51(), CreateKnowledge.getParam52(), CreateKnowledge.getParam53(), CreateKnowledge.getParam54(), CreateKnowledge.getParam55(), CreateKnowledge.getParam56(), CreateKnowledge.getParam57(), CreateKnowledge.getParam58(), CreateKnowledge.getParam59(), CreateKnowledge.getParam60(), CreateKnowledge.getParam61(), CreateKnowledge.getParam62(), CreateKnowledge.getParam63(), CreateKnowledge.getParam64(), CreateKnowledge.getParam65(), CreateKnowledge.getParam66(), CreateKnowledge.getParam67(), CreateKnowledge.getParam68(), CreateKnowledge.getParam69(), CreateKnowledge.getParam70(), CreateKnowledge.getParam71(), CreateKnowledge.getParam72(), CreateKnowledge.getParam73(), CreateKnowledge.getParam74(), CreateKnowledge.getParam75(), CreateKnowledge.getParam76(), CreateKnowledge.getParam77(), CreateKnowledge.getParam78(), CreateKnowledge.getParam79(), CreateKnowledge.getParam80(), CreateKnowledge.getParam81(), CreateKnowledge.getParam82(), CreateKnowledge.getParam83());
			masteries.setKeystone(CreateKnowledge.getParam84());
			
			masteriesservice.addMasteries(masteries);
			knowledge.setMasteriesid(masteries);
		}
		if(CreateKnowledge.getType()==7)
		{
		LeagueRunes lr1 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam9());
		LeagueRunes lr2 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam10());
		LeagueRunes lr3 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam11());
		LeagueRunes lr4 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam12());
		LeagueRunes lr5 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam13());
		LeagueRunes lr6 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam14());
		LeagueRunes lr7 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam15());
		LeagueRunes lr8 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam16());
		LeagueRunes lr9 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam17());
		
		LeagueRunes lr10 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam18());
		LeagueRunes lr11 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam19());
		LeagueRunes lr12 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam20());
		LeagueRunes lr13 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam21());
		LeagueRunes lr14 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam22());
		LeagueRunes lr15 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam23());
		LeagueRunes lr16 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam24());
		LeagueRunes lr17 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam25());
		LeagueRunes lr18 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam26());

		LeagueRunes lr19 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam27());
		LeagueRunes lr20 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam28());
		LeagueRunes lr21 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam29());
		LeagueRunes lr22 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam30());
		LeagueRunes lr23 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam31());
		LeagueRunes lr24 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam32());
		LeagueRunes lr25 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam33());
		LeagueRunes lr26 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam34());
		LeagueRunes lr27 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam35());
		
		LeagueRunes lr28 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam36());
		LeagueRunes lr29 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam37());
		LeagueRunes lr30 = leaguerunesservice.findByRuneid(CreateKnowledge.getParam38());
		
		Runes rune = new Runes("", lr1, lr2, lr3, lr4, lr5, lr6, lr7, lr8, lr9, lr10, lr11, lr12, lr13,
				lr14, lr15, lr16, lr17, lr18, lr19, lr20, lr21, lr22, lr23, lr24, lr25, lr26, lr27, lr28, lr29, lr30);
		
		runesservice.addRunes(rune);
		
		knowledge.setRunes(rune);
	}
	
		knowledge.setItem(itemservice.findByItemId(CreateKnowledge.getParam8()));
		User user=userservice.findByUserName(name);
		List<ChampionSpells> spells=new ArrayList<ChampionSpells>();
		for (int i = 0; i < CreateKnowledge.getCombolist().size()-1; i++) {
			
			
			spells.add(championspell.findChampionSpells(CreateKnowledge.getCombolist().get(i)));
			System.out.println(CreateKnowledge.getCombolist());
		}
		knowledge.setUser(user);
		knowledge.setSpells(spells);
		if(CreateKnowledge.getType()==4 || CreateKnowledge.getType()==8 || CreateKnowledge.getType()==9)
		{
			if (!CreateKnowledge.getVideo().contentEquals(",,,")) {
				String url = CreateKnowledge.getVideo();
				
				url = url.substring(32);
				String url_list[] = url.split("&");
				url = url_list[0];
				knowledge.setVideo(url);
			}
			
		}

	

		knowledgeservice.addTopic(knowledge);
		List<Knowledge> chList=main.getKnowledge();
		chList.add(knowledge);
		main.setKnowledge(chList);
		return knowledge;
	}

}
