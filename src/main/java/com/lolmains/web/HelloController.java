package com.lolmains.web;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lolmains.domains.BestOf;
import com.lolmains.domains.Build;
import com.lolmains.domains.Champion;
import com.lolmains.domains.Comment;
import com.lolmains.domains.CommentLikes;
import com.lolmains.domains.CreateMessage;
import com.lolmains.domains.Mains;
import com.lolmains.domains.MainsProperties;
import com.lolmains.domains.Masteries;
import com.lolmains.domains.Runes;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.Summoners;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Item;
import com.lolmains.domains.Knowledge;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.User;
import com.lolmains.domains.UserRole;
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;
import com.lolmains.facade.CreateFacade;
import com.lolmains.facade.EditFacade;
import com.lolmains.forms.CreateGuide;
import com.lolmains.forms.CreateKnowledge;
import com.lolmains.forms.CreateMain;
import com.lolmains.forms.CreateMember;
import com.lolmains.forms.CreateTopic;
import com.lolmains.forms.CreateUser;
import com.lolmains.forms.CreateVideo;
import com.lolmains.forms.DeleteTopic;
import com.lolmains.forms.EditTemplate;
import com.lolmains.forms.GetContent;
import com.lolmains.forms.GetCount;
import com.lolmains.forms.Greeting;
import com.lolmains.forms.HelloMessage;
import com.lolmains.forms.SearchData;
import com.lolmains.forms.SidebarData;
import com.lolmains.forms.VerifyUser;
import com.lolmains.services.BestOfService;
import com.lolmains.services.BuildService;
import com.lolmains.services.ChampionService;
import com.lolmains.services.CommentLikesService;
import com.lolmains.services.CommentService;
import com.lolmains.services.DiscussionLikesService;
import com.lolmains.services.MainsService;
import com.lolmains.services.MasteriesService;
import com.lolmains.services.NotificationService;
import com.lolmains.services.RunesService;
import com.lolmains.services.SummonerService;
import com.lolmains.services.SummonersService;
import com.lolmains.services.DiscussionService;
import com.lolmains.services.GuideService;
import com.lolmains.services.ItemService;
import com.lolmains.services.KnowledgeService;
import com.lolmains.services.LeagueChampionService;
import com.lolmains.services.LeagueRunesService;
import com.lolmains.services.LeagueSummonersService;
import com.lolmains.services.MailService;
import com.lolmains.services.MainPropertiesService;
import com.lolmains.services.UserService;
import com.lolmains.util.Util;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";
	
	@Autowired
	DiscussionLikesService discussionlikesservice;

	
	@Autowired
	KnowledgeService knowledgeservice;
	
	
	@Autowired
	MailService mailservice;
	
	@Autowired
	MainsService mainsservice;
	
	@Autowired
	MainPropertiesService mainpropertyservice;

	@Autowired
	DiscussionService discussionservice;

	@Autowired
	NotificationService notificationservice;
	
	@Autowired
	UserService userservice;

	@Autowired
	CommentService commentservice;

	@Autowired
	MasteriesService masteriesservice;

      
	@Autowired
	ChampionService championservice;

	@Autowired
	CommentLikesService commentlikesserivce;

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
	private ResourceLoader resourceLoader;

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

	@Autowired
	private CreateFacade createfacade;

	@Autowired
	private EditFacade editfacade;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		if (name.contains("anonymousUser")) {
			return "login";
		} else {
			return "redirect:/loginSuccess";
		}

	}

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("mains", mainsservice.getAllMains());
		model.addAttribute("message", "");
		return "index";
	}
	@RequestMapping("//riot.txt")
	public String riot(Model model) {

		
		return "riot";
	}
	@RequestMapping("/browse")
	public String browse(Model model) {

		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("mains", mainsservice.getAllMains());
		model.addAttribute("message", "");
		return "browse";
	}
	@RequestMapping("/contact")
	public String contact(Model model) {

		
		model.addAttribute("CreateMessage", new CreateMessage());
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("mains", mainsservice.getAllMains());
		
		return "contact";
	}
	@PostMapping("/contact")
	public String contact(@ModelAttribute CreateMessage CreateMessage, Model model) {

		
		mailservice.sendMail(CreateMessage);
		return "redirect:/";

	}

	@RequestMapping("/{message}")
	public String index(Model model, @PathVariable(value = "message") String message) {

		model.addAttribute("mains", mainsservice.getAllMains());
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("message", message);

		return "index";
	}
	@RequestMapping("/newmain")
	public String getNewMain(Model model) {

		model.addAttribute("CreateMain", new CreateMain());
		return "new_main";
	}

	@RequestMapping("/edittemplate/{id}")
	public String edittemplate(Model model, @PathVariable(value = "id") int id) {

		int authCount = 0;
		Mains main = mainsservice.findMain(id);
		int members = main.getSummoner().size();
		double kills = 0;
		double assists = 0;
		double deaths = 0;
		int tier = 0;
		double winrate = 0;
		int games = 0;

		for (com.lolmains.domains.Summoner summoner : main.getSummoner()) {
			kills += summoner.getChampion().get(0).getKills();
			deaths += summoner.getChampion().get(0).getDeaths();
			assists += summoner.getChampion().get(0).getAssists();
			tier += summoner.getTierNumber();
			games += summoner.getChampion().get(0).getGames();
			winrate += summoner.getChampion().get(0).getWinrate();
		}

		kills /= members;
		assists /= members;
		deaths /= members;
		tier /= members;
		winrate /= members;
		games /= members;

		User user = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!auth.getName().contentEquals("anonymousUser")) {
			user = userservice.findByUserName(auth.getName());
			authCount = 1;
			if (summonerservice.findByMain(main) != null) {
				authCount = 2;
				if (main.getAdmins().contains(user)) {
					authCount = 3;
				}
			}
		}
		JSONArray extraData = new JSONArray();

		Page<Discussion> list = discussionservice.findAllByMain(new PageRequest(0, 10), main);
		ArrayList<Discussion> sortedList = Util.sortDiscussions(list);
		ObjectMapper mapper = new ObjectMapper();
		List<Item> itemList = itemservice.getAllItems();
		String jsonInString = "";
		String items = "";
		try {
			jsonInString = mapper.writeValueAsString(list);
			items = mapper.writeValueAsString(itemList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Discussion dis : list) {
			JSONObject data = new JSONObject();
			DiscussionLikes dl = discussionlikesservice.findByUserAndDiscussion(user, dis);
			if (dl == null) {
				data.put("state", "none");
			} else {
				data.put("id", dl.isState());
			}
			String time = "";

			int count = commentservice.countIdfindByDiscussionId(dis.getId());
			Timestamp date = dis.getDate();
			int day = date.getDate();
			int hour = date.getHours();
			int minute = date.getMinutes();
			Timestamp cData = new Timestamp(System.currentTimeMillis());
			if (day - cData.getDate() == 1) {
				time = "1 day ago";
			} else if (day - cData.getDate() == 0) {
				if (hour - cData.getHours() == 0) {

					time = cData.getMinutes() - minute + " minutes ago";

				} else if (hour - cData.getHours() == 1) {
					if (cData.getMinutes() < minute) {
						time = minute + cData.getMinutes() + 60 + " minutes ago";
					} else {
						time = minute + cData.getMinutes() + " minutes ago";
					}
				}
			} else {
				time = cData.getDate() - day + " days ago";
			}
			data.put("id", dis.getId());
			data.put("time", time);
			data.put("count", count);
			extraData.put(data);
		}
		if (sortedList.size() == 10) {
			model.addAttribute("more", true);
		} else {
			model.addAttribute("more", false);
		}

		model.addAttribute("CreateTopic", new CreateTopic());
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("CreateVideo", new CreateVideo());
		model.addAttribute("main", main);
		model.addAttribute("extraData", extraData);
		model.addAttribute("members", members);
		model.addAttribute("kills", kills);
		model.addAttribute("deaths", deaths);
		model.addAttribute("assists", assists);

		model.addAttribute("winrate", winrate);
		model.addAttribute("tier", tier);
		model.addAttribute("games", games);
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		model.addAttribute("users", main.getSummoner());
		model.addAttribute("guides", main.getGuide());
		EditTemplate edit= new EditTemplate();
		edit.setMainname(main.getName());
		model.addAttribute("EditTemplate", edit);

		return "edittemplate";
	}

	@RequestMapping("/login")
	public String login(Model model) {

		model.addAttribute("CreateMain", new CreateMain());
		return "login";
	}

	@RequestMapping("/newdiscussion/{id}")
	public String newdiscussion(Model model, @PathVariable(value = "id") int id) {

		Mains main = mainsservice.findMain(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userservice.findByUserName(name);
		model.addAttribute("user", user);
		model.addAttribute("main", main);
		if (main.getName().contains("Top") || main.getName().contains("Jungle") || main.getName().contains("Support") || main.getName().contains("Mid") || main.getName().contains("Adc")) {
			model.addAttribute("champion", "All");
			model.addAttribute("championid","All");
		}
		else
		{
		model.addAttribute("champion", main.getChampion().getName());
		model.addAttribute("championid", main.getChampion().getId());
	}
	
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("CreateTopic", new CreateTopic());
		return "new_discussion";
	}
	@RequestMapping("/newknowledge/{id}")
	public String newknowledge(Model model, @PathVariable(value = "id") int id) {

		Mains main = mainsservice.findMain(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userservice.findByUserName(name);
		model.addAttribute("user", user);
		model.addAttribute("main", main);
		model.addAttribute("CreateUser", new CreateUser());
		if (main.getChampion()==null) {
			model.addAttribute("spell", null);
			model.addAttribute("championid", null);
			model.addAttribute("champion", null);
		}
		else
		{
			model.addAttribute("spell", main.getChampion().getSpells().iterator().next());
			model.addAttribute("championid", main.getChampion().getId());
			model.addAttribute("champion", main.getChampion().getName());
		}
		
		model.addAttribute("CreateKnowledge", new CreateKnowledge());
		return "new_knowledge";
	}
	@RequestMapping("/register")
	public String register(Model model) {

		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("userexist", false);
		return "register";
	}

	@RequestMapping("/verify/{id}")
	public String verify(Model model, @PathVariable(value = "id") int id) {

		VerifyUser vu = new VerifyUser();
		vu.setUserid(id);
		vu.setCode("11111111");
		model.addAttribute("wrong", false);
		model.addAttribute("VerifyUser", vu);
		return "verify";
	}

	@PostMapping("/verify")
	public String verify(@ModelAttribute VerifyUser VerifyUser, Model model) {

		User user = userservice.findById(VerifyUser.getUserid());
		if (user.getSummoner().getRegion().contains("EUW")) {
			RiotAPI.setRegion(Region.EUW);
		}
		RiotAPI.setAPIKey(API_KEY);
		boolean verify = summonerservice.checkcode(user.getSummoner(), VerifyUser.getCode());
		if (verify) {
			Summoner summoner = user.getSummoner();
			summoner.setVerified(true);
			summonerservice.addSummoners(summoner);
			return "redirect:/verified";
		}
		model.addAttribute("VerifyUser", VerifyUser);
		model.addAttribute("wrong", true);
		return "verify";

	}

	@PostMapping("/edittemplate")
	public String edittemplate(@ModelAttribute EditTemplate EditTemplate, Model model) {

		Mains main=mainsservice.findByName(EditTemplate.getMainname());
		MainsProperties property=main.getMainsproperties();
		
		property.setBodycolor("#"+EditTemplate.getColor());
		property.setCardcolor("#"+EditTemplate.getColorcard());
		
		mainpropertyservice.addMainsProperties(property);
		main.setMainsproperties(property);
		mainsservice.addMain(main);
		
		

		return "redirect:main/" + EditTemplate.getMainname();

	}

	@PostMapping("/addmain")
	public String addMain(@ModelAttribute CreateMain CreateMain, Model model) {

		Mains main = createfacade.createMain(CreateMain);

		return "redirect:main/" + main.getName();

	}

	@PostMapping("/editguide")
	public String editguide(@ModelAttribute CreateGuide CreateGuide, Model model) {

		Guide guide = editfacade.editGuide(CreateGuide);

		return "redirect:main/" + guide.getMain().getName();

	}

	@PostMapping("/newguide")
	public String newGuide(@ModelAttribute CreateGuide CreateGuide, Model model) {

		Guide guide = createfacade.createPlaystyle(CreateGuide);

		return "redirect:main/" + guide.getMain().getName();

	}

	@PostMapping("/newbestof")
	public String newbestof(@ModelAttribute CreateGuide CreateGuide, Model model) {

		BestOf bestof = createfacade.createBestOf(CreateGuide);

		return "redirect:main/" + bestof.getMain().getName();

	}

	@RequestMapping("/newguide/{id}")
	public String newGuide(@PathVariable(value = "id") int id, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userservice.findByUserName(name);
		CreateGuide cg = new CreateGuide();
		cg.setMain(id);
		model.addAttribute("user", user);
		model.addAttribute("mains", mainsservice.findMain(id));
		model.addAttribute("CreateGuide", new CreateGuide());
		return "new_guide";
	}

	@RequestMapping("/bestof/{id}")
	public String bestof(@PathVariable(value = "id") int id, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userservice.findByUserName(name);
		CreateGuide cg = new CreateGuide();
		cg.setMain(id);
		model.addAttribute("user", user);
		model.addAttribute("mains", mainsservice.findMain(id));
		model.addAttribute("CreateGuide", cg);
		return "bestof";
	}

	@RequestMapping("/editguide/{id}")
	public String editguide(@PathVariable(value = "id") int id, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		Guide guide = guideservice.findMain(id);

		CreateGuide cg = new CreateGuide();
		cg.setName(guide.getName());
		cg.setGeneralDescription(guide.getContent());

		cg.setParam1(guide.getBuild().getItem1id().getItemId());
		cg.setParam2(guide.getBuild().getItem2id().getItemId());
		cg.setParam3(guide.getBuild().getItem3id().getItemId());
		cg.setParam4(guide.getBuild().getItem4id().getItemId());
		cg.setParam5(guide.getBuild().getItem5id().getItemId());
		cg.setParam6(guide.getBuild().getItem6id().getItemId());
		cg.setBuildDescription(guide.getBuild().getDescription());

		cg.setParam7(guide.getSummoners().getSummoner1().getSummonersid());
		cg.setParam8(guide.getSummoners().getSummoner2().getSummonersid());
		cg.setSummonersDescription(guide.getSummoners().getDescription());

		cg.setParam9(guide.getRunes().getTree_1_1().getRuneid());
		cg.setParam10(guide.getRunes().getTree_1_2().getRuneid());
		cg.setParam11(guide.getRunes().getTree_1_3().getRuneid());
		cg.setParam12(guide.getRunes().getTree_1_4().getRuneid());
		cg.setParam13(guide.getRunes().getTree_1_5().getRuneid());
		cg.setParam14(guide.getRunes().getTree_1_6().getRuneid());
		cg.setParam15(guide.getRunes().getTree_1_7().getRuneid());
		cg.setParam16(guide.getRunes().getTree_1_8().getRuneid());
		cg.setParam17(guide.getRunes().getTree_1_9().getRuneid());

		cg.setParam18(guide.getRunes().getTree_2_1().getRuneid());
		cg.setParam19(guide.getRunes().getTree_2_2().getRuneid());
		cg.setParam20(guide.getRunes().getTree_2_3().getRuneid());
		cg.setParam21(guide.getRunes().getTree_2_4().getRuneid());
		cg.setParam22(guide.getRunes().getTree_2_5().getRuneid());
		cg.setParam23(guide.getRunes().getTree_2_6().getRuneid());
		cg.setParam24(guide.getRunes().getTree_2_7().getRuneid());
		cg.setParam25(guide.getRunes().getTree_2_8().getRuneid());
		cg.setParam26(guide.getRunes().getTree_2_9().getRuneid());

		cg.setParam27(guide.getRunes().getTree_3_1().getRuneid());
		cg.setParam28(guide.getRunes().getTree_3_2().getRuneid());
		cg.setParam29(guide.getRunes().getTree_3_3().getRuneid());
		cg.setParam30(guide.getRunes().getTree_3_4().getRuneid());
		cg.setParam31(guide.getRunes().getTree_3_5().getRuneid());
		cg.setParam32(guide.getRunes().getTree_3_6().getRuneid());
		cg.setParam33(guide.getRunes().getTree_3_7().getRuneid());
		cg.setParam34(guide.getRunes().getTree_3_8().getRuneid());
		cg.setParam35(guide.getRunes().getTree_3_9().getRuneid());

		cg.setParam35(guide.getRunes().getTree_4_1().getRuneid());
		cg.setParam37(guide.getRunes().getTree_4_2().getRuneid());
		cg.setParam38(guide.getRunes().getTree_4_3().getRuneid());
		cg.setSummonersDescription(guide.getRunes().getDescription());

		cg.setParam39(guide.getMasteriesid().getTree_1_1());
		cg.setParam40(guide.getMasteriesid().getTree_1_2());
		cg.setParam41(guide.getMasteriesid().getTree_1_3());
		cg.setParam42(guide.getMasteriesid().getTree_1_4());
		cg.setParam43(guide.getMasteriesid().getTree_1_5());
		cg.setParam44(guide.getMasteriesid().getTree_1_6());
		cg.setParam45(guide.getMasteriesid().getTree_1_7());
		cg.setParam46(guide.getMasteriesid().getTree_1_8());
		cg.setParam47(guide.getMasteriesid().getTree_1_9());
		cg.setParam48(guide.getMasteriesid().getTree_1_10());
		cg.setParam49(guide.getMasteriesid().getTree_1_11());
		cg.setParam50(guide.getMasteriesid().getTree_1_12());
		cg.setParam51(guide.getMasteriesid().getTree_1_13());
		cg.setParam52(guide.getMasteriesid().getTree_1_14());
		cg.setParam53(guide.getMasteriesid().getTree_1_15());

		cg.setParam54(guide.getMasteriesid().getTree_2_1());
		cg.setParam55(guide.getMasteriesid().getTree_2_2());
		cg.setParam56(guide.getMasteriesid().getTree_2_3());
		cg.setParam57(guide.getMasteriesid().getTree_2_4());
		cg.setParam58(guide.getMasteriesid().getTree_2_5());
		cg.setParam59(guide.getMasteriesid().getTree_2_6());
		cg.setParam60(guide.getMasteriesid().getTree_2_7());
		cg.setParam61(guide.getMasteriesid().getTree_2_8());
		cg.setParam62(guide.getMasteriesid().getTree_2_9());
		cg.setParam63(guide.getMasteriesid().getTree_2_10());
		cg.setParam64(guide.getMasteriesid().getTree_2_11());
		cg.setParam65(guide.getMasteriesid().getTree_2_12());
		cg.setParam66(guide.getMasteriesid().getTree_2_13());
		cg.setParam67(guide.getMasteriesid().getTree_2_14());
		cg.setParam68(guide.getMasteriesid().getTree_2_15());

		cg.setParam69(guide.getMasteriesid().getTree_3_1());
		cg.setParam80(guide.getMasteriesid().getTree_3_2());
		cg.setParam71(guide.getMasteriesid().getTree_3_3());
		cg.setParam72(guide.getMasteriesid().getTree_3_4());
		cg.setParam73(guide.getMasteriesid().getTree_3_5());
		cg.setParam74(guide.getMasteriesid().getTree_3_6());
		cg.setParam75(guide.getMasteriesid().getTree_3_7());
		cg.setParam76(guide.getMasteriesid().getTree_3_8());
		cg.setParam77(guide.getMasteriesid().getTree_3_9());
		cg.setParam78(guide.getMasteriesid().getTree_3_10());
		cg.setParam79(guide.getMasteriesid().getTree_3_11());
		cg.setParam80(guide.getMasteriesid().getTree_3_12());
		cg.setParam81(guide.getMasteriesid().getTree_3_13());
		cg.setParam82(guide.getMasteriesid().getTree_3_14());
		cg.setParam83(guide.getMasteriesid().getTree_1_15());
		cg.setParam84(guide.getMasteriesid().getKeystone());
		cg.setMasteriesDescription(guide.getMasteriesid().getDescription());
		cg.setGuide(id);
		cg.setMain(guide.getMain().getId());
		User user = userservice.findByUserName(name);
		model.addAttribute("user", user);
		model.addAttribute("mains", guide.getMain().getId());
		model.addAttribute("guide", guide.getId());
		model.addAttribute("CreateGuide", cg);
		return "new_guide";
	}

	@PostMapping("/newdiscussion")
	public String addTopic(@ModelAttribute CreateTopic CreateTopic, Model model) {

		Discussion topic = createfacade.createDiscussion(CreateTopic);
		return "redirect:main/" + topic.getMain().getName();

	}
	@PostMapping("/newknowledge")
	public String newknowledge(@ModelAttribute CreateKnowledge CreateKnowledge, Model model) {

		Knowledge knowledge= createfacade.createKnowledge(CreateKnowledge);
		return "redirect:main/" + knowledge.getMain().getName();

	}
	@PostMapping("/newuser")
	public String addUser(@ModelAttribute CreateUser CreateUser, Model model) {

		if (userservice.findByUserName(CreateUser.getUsername()) != null) {
			model.addAttribute("userexist", true);
			model.addAttribute("CreateUser", CreateUser);
			return "register";
		}

		User user = createfacade.createUser(CreateUser);
		if (CreateUser.getMain() == null) {
			return "redirect:/registerSuccess";
		}
		return "redirect:main/" + CreateUser.getMain();

	}

	@PostMapping("/newmember")
	public String newmember(@ModelAttribute CreateMember CreateMember, Model model) {

		Mains main = createfacade.createMember(CreateMember);

		return "redirect:main/" + main.getName();

	}

	@RequestMapping("/main/{id}")
	public String main(@PathVariable(value = "id") String id, Model model, HttpServletRequest ServletRequest) {

		String sessionId = ServletRequest.getSession().getId();
		int authCount = 0;
		Mains main = mainsservice.findByName(id);
		main.getSummoner();
		int members = main.getSummoner().size();
		double kills = 0;
		double assists = 0;
		double deaths = 0;
		int tier = 0;
		double winrate = 0;
		int games = 0;

		for (com.lolmains.domains.Summoner summoner : main.getSummoner()) {
			kills += summoner.getChampion().get(0).getKills();
			deaths += summoner.getChampion().get(0).getDeaths();
			assists += summoner.getChampion().get(0).getAssists();
			tier += summoner.getTierNumber();
			games += summoner.getChampion().get(0).getGames();
			winrate += summoner.getChampion().get(0).getWinrate();
		}

		kills /= members;
		assists /= members;
		deaths /= members;
		tier /= members;
		winrate /= members;
		games /= members;
		kills=Util.round(kills, 1);
		assists=Util.round(assists, 1);
		deaths=Util.round(deaths, 1);
		winrate=Util.round(winrate, 2);
		User user = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!auth.getName().contentEquals("anonymousUser")) {
			user = userservice.findByUserName(auth.getName());
			authCount = 1;
			if (main.getSummoner().contains(user.getSummoner())) {
				authCount = 2;
				if (main.getAdmins().contains(user)) {
					authCount = 3;
				}
			}
		}
		JSONArray extraData = new JSONArray();

		Page<Discussion> list = discussionservice.findAllByMain(new PageRequest(0, 10), main);
		ArrayList<Discussion> sortedList = Util.sortDiscussions(list);
		ObjectMapper mapper = new ObjectMapper();
		List<Item> itemList = itemservice.getAllItems();
		String jsonInString = "";
		String properties = "";
		String items = "";
		try {
			properties = mapper.writeValueAsString(main.getMainsproperties());
			jsonInString = mapper.writeValueAsString(list);
			items = mapper.writeValueAsString(itemList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Discussion dis : list) {
			JSONObject data = new JSONObject();
			DiscussionLikes dl = discussionlikesservice.findByUserAndDiscussion(user, dis);
			if (dl == null) {
				data.put("state", "none");
			} else {
				data.put("id", dl.isState());
			}
			String time = "";

			int count = commentservice.countIdfindByDiscussionId(dis.getId());
			Timestamp date = dis.getDate();
			int day = date.getDate();
			int hour = date.getHours();
			int minute = date.getMinutes();
			Timestamp cData = new Timestamp(System.currentTimeMillis());
			if (day - cData.getDate() == 1) {
				time = "1 day ago";
			} else if (day - cData.getDate() == 0) {
				if (hour - cData.getHours() == 0) {

					time = cData.getMinutes() - minute + " minutes ago";

				} else if (hour - cData.getHours() == 1) {
					if (cData.getMinutes() < minute) {
						time = minute + cData.getMinutes() + 60 + " minutes ago";
					} else {
						time = minute + cData.getMinutes() + " minutes ago";
					}
				}
			} else {
				time = cData.getDate() - day + " days ago";
			}
			data.put("id", dis.getId());
			data.put("time", time);
			data.put("count", count);
			extraData.put(data);
		}
		if (sortedList.size() == 10) {
			model.addAttribute("more", true);
		} else {
			model.addAttribute("more", false);
		}
		
		model.addAttribute("CreateTopic", new CreateTopic());
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("CreateVideo", new CreateVideo());
		model.addAttribute("main", main);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
	
		model.addAttribute("extraData", extraData);
		model.addAttribute("members", members);
		model.addAttribute("kills", kills);
		model.addAttribute("deaths", deaths);
		model.addAttribute("assists", assists);
		if (main.getChampion()!=null) {
			model.addAttribute("champion", main.getChampion().getName());
		}
		model.addAttribute("notifications", notificationservice.findAll(new PageRequest(0, 5)));
		model.addAttribute("winrate", winrate);
		model.addAttribute("tier", tier);
		model.addAttribute("games", games);
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		model.addAttribute("users", main.getSummoner());
		model.addAttribute("guides", main.getGuide());

		model.addAttribute("sessionid", sessionId);
		model.addAttribute("mainsid", id);
		model.addAttribute("topics", sortedList);
		model.addAttribute("topics_data", jsonInString);
		model.addAttribute("properties", properties);
		model.addAttribute("items", itemservice.getAllItems());
		model.addAttribute("champions", leaguechampionservice.getAllLeagueChampion());

		return "horizontal_main";
	}

	
	

	@RequestMapping("/summoner/{id}")
	public String getSummoner(@PathVariable(value = "id") String id, Model model) {

		com.lolmains.domains.Summoner summoner = summonerservice.findByName(id);
		model.addAttribute("summoner", summoner);

		return "summoner";
	}

	@RequestMapping("/playstyle/{name}")
	public String getPlaystyle(@PathVariable(value = "name") String id, Model model) {

		// HttpSession session =
		// request.getSession(true);session.getAttribute("SPRING_SECURITY_CONTEXT");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userservice.findByUserName(name);
		Guide playstyle = guideservice.findByName(id);
		boolean aut = false;
		if (playstyle.getUser().equals(user.getSummoner())) {
			aut = true;
		}
		playstyle.getUser().getChampion().get(0).getLeaguechampion();
		model.addAttribute("playstyle", playstyle);
		model.addAttribute("auth", aut);
		return "playstyle";
	}

	@RequestMapping("/topic/{id}")
	public String getTopic(@PathVariable(value = "id") int id, Model model, HttpServletRequest ServletRequest) {

		String sessionId = ServletRequest.getSession().getId();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userservice.findByUserName(name);
		Discussion discussion = discussionservice.findTopic(id);
		List<Comment> comList = commentservice.findByDiscussionId(id);
		JSONArray comArray = new JSONArray();
		JSONArray rcomArray = new JSONArray();
		for (int i = 0; i < comList.size(); i++) {
			comArray.put(comList.get(i));
		}

		List<Comment> sortedList = Util.sortComments(comList);
		JSONArray sortedJsonArray = new JSONArray();
		JSONArray ja = getExtraDataComment(comList, user, sortedJsonArray);
		Mains main = discussion.getMain();
		model.addAttribute("main", main);
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("user", name);
		model.addAttribute("champion", "Kindred");
		model.addAttribute("mainid", main.getId());
		model.addAttribute("topicid", id);

		if (user != null) {
			model.addAttribute("userid", userservice.findByUserName(name).getId());
		}
		String data = comList.toString();
		DiscussionLikes dl = discussionlikesservice.findByUserAndDiscussion(user, discussion);
		if (dl == null) {
			model.addAttribute("state", "none");
		} else {
			model.addAttribute("state", dl.isState());
		}
		model.addAttribute("owner", false);
		int authCount = 0;
		if (!auth.getName().contentEquals("anonymousUser")) {
			user = userservice.findByUserName(auth.getName());
			authCount = 1;
			if (summonerservice.findByMain(main) != null) {
				authCount = 2;
				
				if (main.getAdmins().contains(user)) {
					authCount = 3;
				}
				else if(discussion.getUser().getUserName().contentEquals(user.getUserName()))
				{
					model.addAttribute("owner", true);
				}
			}
		}
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		model.addAttribute("authCount", authCount);
		model.addAttribute("extradata", ja);
		model.addAttribute("user", user);
		model.addAttribute("topiccontent", discussion.getContent());
		model.addAttribute("comments1", data);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("DeleteTopic", new DeleteTopic());
		model.addAttribute("discussion", discussion);
		model.addAttribute("comments", data);
		model.addAttribute("mainsid", id);
		return "topic";
	}
	@PostMapping("/deletetopic")
	public String deleteTopic(Model model, DeleteTopic DeleteTopic)
	{
		for(DiscussionLikes dl:discussionlikesservice.findByDiscussion(discussionservice.findTopic(DeleteTopic.getTopicid())))
				{
			discussionlikesservice.deleteDiscussion(dl);
				}
		discussionservice.removeTopic(discussionservice.findTopic(DeleteTopic.getTopicid()));
		return "redirect:main/" + mainsservice.findMain(DeleteTopic.getMainid()).getName();
		
	}
	public JSONArray getExtraDataComment(List<Comment> comList, User user, JSONArray sortedJsonArray) {
		// TODO Auto-generated method stub

		
		for (Comment comment : comList) {
			if (comment.getComment().size() != 0) {
				getExtraDataComment(comment.getComment(), user,sortedJsonArray);
			}
			CommentLikes cl = commentlikesserivce.findByUserAndComment(user, comment);

			JSONObject jo = new JSONObject();
			if (cl == null) {
				jo.put("id", comment.getId());
				jo.put("state", "none");
			} else {
				jo.put("id", comment.getId());
				jo.put("state", cl.isState());
			}

			sortedJsonArray.put(jo);
		}

		return sortedJsonArray;
	}

}
