package com.lolmains.web;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lolmains.domains.Build;
import com.lolmains.domains.Champion;
import com.lolmains.domains.Comment;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Masteries;
import com.lolmains.domains.Runes;
import com.lolmains.domains.Summoners;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Item;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.User;
import com.lolmains.domains.UserRole;
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;
import com.lolmains.forms.CreateGuide;
import com.lolmains.forms.CreateMain;
import com.lolmains.forms.CreateTopic;
import com.lolmains.forms.CreateUser;
import com.lolmains.forms.CreateVideo;
import com.lolmains.forms.GetCount;
import com.lolmains.forms.Greeting;
import com.lolmains.forms.HelloMessage;
import com.lolmains.forms.SearchData;
import com.lolmains.forms.SidebarData;
import com.lolmains.services.BuildService;
import com.lolmains.services.ChampionService;
import com.lolmains.services.CommentService;
import com.lolmains.services.MainsService;
import com.lolmains.services.MasteriesService;
import com.lolmains.services.RunesService;
import com.lolmains.services.SummonerService;
import com.lolmains.services.SummonersService;
import com.lolmains.services.DiscussionService;
import com.lolmains.services.GuideService;
import com.lolmains.services.ItemService;
import com.lolmains.services.LeagueChampionService;
import com.lolmains.services.LeagueRunesService;
import com.lolmains.services.LeagueSummonersService;
import com.lolmains.services.UserService;
import com.lolmains.services.VideoLikesService;
import com.lolmains.services.VideoService;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.summoner.Summoner;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainCotroller {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	MainsService mainsservice;

	@Autowired
	VideoService videoservice;

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
	LeagueSummonersService leaguesummonersservice;

	@Autowired
	SummonersService summonersservice;
	
	@Autowired
	SummonerService summonerservice;

	@Autowired
	LeagueChampionService leaguechampionservice;

	@Autowired
	VideoLikesService videolikesservice;

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("mains", mainsservice.getAllMains());

		return "index";
	}

	@RequestMapping("/newmain")
	public String getNewMain(Model model) {

		model.addAttribute("CreateMain", new CreateMain());
		return "new_main";
	}
	@RequestMapping("/login")
	public String login(Model model) {

		model.addAttribute("CreateMain", new CreateMain());
		return "login";
	}
	@PostMapping("/addmain")
	public String addMain(@ModelAttribute CreateMain CreateMain, Model model) {

		model.addAttribute("CreateUser", new CreateUser());

		return "index";

	}

	



	@PostMapping("/newdiscussion")
	public String addTopic(@ModelAttribute CreateTopic CreateTopic, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		Discussion topic = new Discussion();
		// topic.setUser(name);
	//	topic.setMainsid(CreateTopic.getMainsid());
		topic.setType(CreateTopic.getType());
		topic.setHeader(CreateTopic.getHeader());
		topic.setContent(CreateTopic.getContent());
		topic.setItem1id(itemservice.findByItemId(CreateTopic.getParam1()));
		topic.setItem2id(itemservice.findByItemId(CreateTopic.getParam2()));
		topic.setItem3id(itemservice.findByItemId(CreateTopic.getParam3()));
		topic.setItem4id(itemservice.findByItemId(CreateTopic.getParam4()));
		topic.setItem5id(itemservice.findByItemId(CreateTopic.getParam5()));
		topic.setItem6id(itemservice.findByItemId(CreateTopic.getParam6()));
		topic.setDate(new Timestamp(System.currentTimeMillis()));
		User user=userservice.findByUserName(name);
		
		topic.setUser(user);

//		String url = CreateTopic.getVideo();
//		
//		url = url.substring(32);
//		String url_list[] = url.split("&");
//		url = url_list[0];
//		topic.setVideo(url);
//		topic.setUrl(CreateTopic.getUrl());
		// Champion ch=championservice.findChampion(1);

		discussionservice.addTopic(topic);
		List<Discussion> chList=new ArrayList<Discussion>();
		chList.add(topic);
		user.setDiscussion(chList);
		return "redirect:main/1";

	}



	@PostMapping("/newuser")
	public String addUser(@ModelAttribute CreateUser CreateUser, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		RiotAPI.setRegion(Region.EUW);
		RiotAPI.setAPIKey(API_KEY);
		
List<Champion> ch=championservice.addChampion(CreateUser.getServer(), CreateUser.getUsername());
		
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
		userservice.create(user);

		return "main";

	}

	@RequestMapping("/discussions/{id}/{page}")
	public String main(@PathVariable(value = "id") String id,@PathVariable(value = "page") String page, Model model) {

		User user = userservice.findById(6);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		List<Video> video = videoservice.findTop1ByOrderByLikesDesc();

		// if (videolikesservice.findTop1ByUserNameAndVideoId(name,
		// video.get(0).getId()).isEmpty()) {
		// boolean likes=true;
		// }
		Page<Discussion> list=discussionservice.findAll(new PageRequest(0, 5));
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString="";
		try {
			 jsonInString = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mains main = mainsservice.findByName(id);
		model.addAttribute("CreateTopic", new CreateTopic());
		model.addAttribute("CreateUser", new CreateUser());

		model.addAttribute("main", main);


		model.addAttribute("mainsid", id);
		model.addAttribute("topics", list);
		model.addAttribute("topics_data", jsonInString);
		model.addAttribute("items", itemservice.getAllItems());
		model.addAttribute("champions", leaguechampionservice.getAllLeagueChampion());

	

		return "main_discussion";
	}

	@RequestMapping("/videos/{id}/{page}")
	public String video(@PathVariable(value = "id") String id,@PathVariable(value = "page") String page, Model model) {

		User user = userservice.findById(6);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		List<Video> video = videoservice.findTop1ByOrderByLikesDesc();

		// if (videolikesservice.findTop1ByUserNameAndVideoId(name,
		// video.get(0).getId()).isEmpty()) {
		// boolean likes=true;
		// }
	
	
		Mains main = mainsservice.findByName(id);
		
		model.addAttribute("CreateUser", new CreateUser());

		model.addAttribute("main", main);


		model.addAttribute("mainsid", id);
		model.addAttribute("CreateVideo", new CreateVideo());
		
		model.addAttribute("videos", videoservice.findAll(new PageRequest(0, 5)));
		model.addAttribute("top_videos", videoservice.findTop1ByOrderByLikesDesc());



	

		return "main_videos";
	}
	@RequestMapping("/bestof/{id}/{page}")
	public String bestof(@PathVariable(value = "id") String id,@PathVariable(value = "page") String page, Model model) {

		User user = userservice.findById(6);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
	
		Mains main = mainsservice.findByName(id);

		model.addAttribute("CreateUser", new CreateUser());

		model.addAttribute("main", main);


	

		return "main_bestof";
	}
	@RequestMapping("/members/{id}/{page}")
	public String members(@PathVariable(value = "id") String id,@PathVariable(value = "page") String page, Model model) {

		User user = userservice.findById(6);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		List<Video> video = videoservice.findTop1ByOrderByLikesDesc();

		// if (videolikesservice.findTop1ByUserNameAndVideoId(name,
		// video.get(0).getId()).isEmpty()) {
		// boolean likes=true;
		// }
		
		Mains main = mainsservice.findByName(id);
		model.addAttribute("CreateTopic", new CreateTopic());
		model.addAttribute("CreateUser", new CreateUser());

		model.addAttribute("main", main);
		model.addAttribute("users", userservice.findAll(new PageRequest(0, 5)));

		model.addAttribute("mainsid", id);


	


	

		return "main_members";
	}
	@RequestMapping("/playstyles/{id}/{page}")
	public String playstyles(@PathVariable(value = "id") String id,@PathVariable(value = "page") String page, Model model) {

		User user = userservice.findById(6);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		

		// if (videolikesservice.findTop1ByUserNameAndVideoId(name,
		// video.get(0).getId()).isEmpty()) {
		// boolean likes=true;
		// }
	
		Mains main = mainsservice.findByName(id);
	
		model.addAttribute("CreateUser", new CreateUser());

		model.addAttribute("main", main);

		model.addAttribute("guides", guideservice.getAllGuide());
		model.addAttribute("mainsid", id);
		

	

		return "main_playstyles";
	}
	@RequestMapping("/settings/{id}")
	public String settings(@PathVariable(value = "id") String id,@PathVariable(value = "page") String page, Model model) {

		User user = userservice.findById(6);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		List<Video> video = videoservice.findTop1ByOrderByLikesDesc();

		// if (videolikesservice.findTop1ByUserNameAndVideoId(name,
		// video.get(0).getId()).isEmpty()) {
		// boolean likes=true;
		// }
		Page<Discussion> list=discussionservice.findAll(new PageRequest(0, 5));
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString="";
		try {
			 jsonInString = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mains main = mainsservice.findByName(id);
		model.addAttribute("CreateTopic", new CreateTopic());
		model.addAttribute("CreateUser", new CreateUser());

		model.addAttribute("main", main);


		model.addAttribute("mainsid", id);
		model.addAttribute("topics", list);
		model.addAttribute("topics_data", jsonInString);
		model.addAttribute("items", itemservice.getAllItems());
		model.addAttribute("champions", leaguechampionservice.getAllLeagueChampion());

	

		return "main_settings";
	}
}
