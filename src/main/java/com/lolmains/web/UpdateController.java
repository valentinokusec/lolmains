package com.lolmains.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lolmains.services.ItemService;
import com.lolmains.services.LeagueChampionService;
import com.lolmains.services.LeagueMasteriesService;
import com.lolmains.services.LeagueRunesService;
import com.lolmains.services.LeagueSummonersService;

@Controller
@RequestMapping("/updateservice")
public class UpdateController {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	
	
	@Autowired
	ItemService itemservice;
	
	@Autowired
	LeagueChampionService leaguechampionservice;
	
	@Autowired
	LeagueSummonersService leaguesummonersservice;
	
	@Autowired
	LeagueRunesService leaguerunesservice;
	
	@Autowired
	LeagueMasteriesService leaguemasteriesservice;


	 @RequestMapping("/addallitems")
		public String addAllItems( ) {

		itemservice.addAll();
		leaguechampionservice.addAll();
		leaguesummonersservice.addAll();
		leaguerunesservice.addAll();
			return "index";
		}
	 @RequestMapping("/addallchamps")
		public String addallchamps( ) {

		 leaguechampionservice.addAll();

			return "index";
		}
	 @RequestMapping("/addallsummoners")
		public String addallSummoners( ) {

		 leaguesummonersservice.addAll();

			return "index";
		}
	 @RequestMapping("/addallrunes")
		public String addAllRunes( ) {

		 leaguerunesservice.addAll();

			return "index";
		}
	 @RequestMapping("/addallmasteries")
		public String addAllMasteries( ) {

		 leaguemasteriesservice.addAll();

			return "index";
		}
}
