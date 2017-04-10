package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.lolmains.domains.Mains;
import com.lolmains.domains.MainsProperties;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.User;
import com.lolmains.facade.CreateFacade;
import com.lolmains.forms.CreateUser;

@Component
public class FillData {

	
	@Autowired
	private MainPropertiesService mainpropertyservice;
	
	
	@Autowired
	MainsService mainsservice;

	@Autowired
	UserService userservice;

	@Autowired
	CreateFacade createfacade;

	@Autowired
	ItemService itemservice;

	@Autowired
	LeagueChampionService leaguechampionservice;

	@Autowired
	LeagueSummonersService leaguesummonersservice;

	@Autowired
	LeagueRunesService leaguerunesservice;

	public void fillWithTestdata() {
	

		
		
		
		

	
		
		if (userservice.findByUserName("tino") == null) {

			itemservice.addAll();
			leaguechampionservice.addAll();
			leaguesummonersservice.addAll();
			leaguerunesservice.addAll();

			CreateUser createUser = new CreateUser();
			createUser.setServer("EUW");
			createUser.setSummoner("toysoldier1");
			createUser.setUsername("tino");
			createUser.setPassword("tino");
			createUser.setConfirmpassword("tino");

			User user=createfacade.createUser(createUser);

			List<User> admins = new ArrayList<User>();
			admins.add(user);
			
			List<Summoner> members = new ArrayList<Summoner>();
			members.add(user.getSummoner());
			
			Mains top = new Mains();
			top.setAdmins(admins);
			top.setSummoner(members);
			top.setName("Top");
			top.setBanner("http://orig02.deviantart.net/501e/f/2012/166/8/6/wallpaper_for_toplaners_league_of_legends_by_dziufa-d53klv3.jpg");
			MainsProperties property= new MainsProperties();
			
			property.setBodycolor("#f1f1f1");
			property.setCardcolor("#ffffff");
			
			mainpropertyservice.addMainsProperties(property);
			top.setMainsproperties(property);
			
			mainsservice.addMain(top);
			User userm=userservice.findByUserName("tino");
			List<User> adminsm = new ArrayList<User>();
			adminsm.add(userm);
			
			List<Summoner> membersm = new ArrayList<Summoner>();
			membersm.add(userm.getSummoner());
			
			Mains mid= new Mains();
			mid.setAdmins(adminsm);
			mid.setSummoner(membersm);
			mid.setName("Mid");
			mid.setBanner("http://lolwp.com/wp-content/uploads/2013/10/Mid-Ahri.jpg");
			MainsProperties propertyMid= new MainsProperties();
			
			propertyMid.setBodycolor("#f1f1f1");
			propertyMid.setCardcolor("#ffffff");
			
			mainpropertyservice.addMainsProperties(propertyMid);
			mid.setMainsproperties(propertyMid);
			
			mainsservice.addMain(mid);
			
			User usera=userservice.findByUserName("tino");
			
			List<User> adminsa = new ArrayList<User>();
			adminsa.add(usera);
			
			List<Summoner> membersa = new ArrayList<Summoner>();
			membersa.add(usera.getSummoner());
			
			Mains adc = new Mains();
			adc.setAdmins(adminsa);
			adc.setSummoner(membersa);
			adc.setName("Adc");
			adc.setBanner("https://i.ytimg.com/vi/tsuOoodaMIg/maxresdefault.jpg");
			MainsProperties propertyAdc= new MainsProperties();
			
			propertyAdc.setBodycolor("#f1f1f1");
			propertyAdc.setCardcolor("#ffffff");
			
			mainpropertyservice.addMainsProperties(propertyAdc);
			adc.setMainsproperties(propertyAdc);
			
			mainsservice.addMain(adc);
		
			User users=userservice.findByUserName("tino");
			
			List<User> adminss = new ArrayList<User>();
			adminss.add(users);
			
			List<Summoner> memberss = new ArrayList<Summoner>();
			memberss.add(users.getSummoner());
			
			Mains support = new Mains();
			support.setAdmins(adminss);
			support.setSummoner(members);
			support.setName("Support");
			support.setBanner("http://cdn.wallpapersafari.com/10/40/I1HLFE.jpg");
			MainsProperties propertySupport= new MainsProperties();
			
			propertySupport.setBodycolor("#f1f1f1");
			propertySupport.setCardcolor("#ffffff");
			
			mainpropertyservice.addMainsProperties(propertySupport);
			support.setMainsproperties(propertySupport);
			
			mainsservice.addMain(support);
		
			User userj=userservice.findByUserName("tino");
			
			List<User> adminsj = new ArrayList<User>();
			adminsj.add(userj);
			
			List<Summoner> membersj = new ArrayList<Summoner>();
			membersj.add(userj.getSummoner());
			
			Mains jungle = new Mains();
			jungle.setAdmins(adminsj);
			jungle.setSummoner(membersj);
			jungle.setName("Jungle");
			jungle.setBanner("https://pre14.deviantart.net/326d/th/pre/f/2013/095/6/9/league_of_legends_jungle_by_conorsta-d60jkpb.png");
			MainsProperties propertyJungle= new MainsProperties();	
			
			propertyJungle.setBodycolor("#f1f1f1");
			propertyJungle.setCardcolor("#ffffff");
			
			mainpropertyservice.addMainsProperties(propertyJungle);
			jungle.setMainsproperties(propertyJungle);
			
			mainsservice.addMain(jungle);
		
			

		}

	}

}
