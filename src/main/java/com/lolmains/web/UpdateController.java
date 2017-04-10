package com.lolmains.web;

import org.springframework.web.bind.annotation.RestController;

import com.lolmains.domains.Champion;
import com.lolmains.domains.Comment;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.User;
import com.lolmains.domains.UserRole;
import com.lolmains.domains.Video;
import com.lolmains.forms.CreateMain;
import com.lolmains.forms.CreateTopic;
import com.lolmains.forms.CreateUser;
import com.lolmains.forms.CreateVideo;
import com.lolmains.forms.Greeting;
import com.lolmains.forms.HelloMessage;
import com.lolmains.services.ChampionService;
import com.lolmains.services.CommentService;
import com.lolmains.services.MainsService;
import com.lolmains.services.DiscussionService;
import com.lolmains.services.ItemService;
import com.lolmains.services.LeagueChampionService;
import com.lolmains.services.LeagueRunesService;
import com.lolmains.services.LeagueSummonersService;
import com.lolmains.services.UserService;
import com.lolmains.services.VideoService;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
