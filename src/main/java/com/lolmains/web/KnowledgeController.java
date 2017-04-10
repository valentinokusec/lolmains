package com.lolmains.web;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lolmains.domains.Champion;
import com.lolmains.domains.Comment;
import com.lolmains.domains.Mains;
import com.lolmains.domains.TierList;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Knowledge;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.User;
import com.lolmains.domains.UserRole;
import com.lolmains.domains.Video;
import com.lolmains.forms.CreateKnowledge;
import com.lolmains.forms.CreateMain;
import com.lolmains.forms.CreateTierList;
import com.lolmains.forms.CreateTopic;
import com.lolmains.forms.CreateUser;
import com.lolmains.forms.CreateVideo;
import com.lolmains.forms.DeleteTopic;
import com.lolmains.forms.Greeting;
import com.lolmains.forms.HelloMessage;
import com.lolmains.services.ChampionService;
import com.lolmains.services.CommentService;
import com.lolmains.services.MainsService;
import com.lolmains.services.SummonerService;
import com.lolmains.services.TierListService;
import com.lolmains.services.DiscussionService;
import com.lolmains.services.ItemService;
import com.lolmains.services.KnowledgeService;
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/knowledge")
public class KnowledgeController {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	@Autowired
	VideoService videoservice;
	
	@Autowired
	KnowledgeService knowledgeservice;

	@Autowired
	TierListService tierlistservice;
	
	@Autowired
	MainsService mainsservice;

	@Autowired
	UserService userservice;

	@Autowired
	SummonerService summonerservice;
	
	@Autowired
	CommentService commentservice;
	
	@Autowired
	DiscussionService discussionservice;
	
	@Autowired
	LeagueChampionService leaguechampionservice;

	
	@RequestMapping("/{id}/TierList")
	public String discussionsTierList(@PathVariable(value = "id") String id,
			 Model model, HttpServletRequest ServletRequest) {

		int authCount = 0;
		Mains main = mainsservice.findByName(id);

		String sessionId = ServletRequest.getSession().getId();

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

		String name = auth.getName();

		int typen = 0;
		

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";
		
		TierList tl = tierlistservice.findAllByMain(main);
		
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);
	
	
		model.addAttribute("main", main);
		model.addAttribute("tl", tl);
		model.addAttribute("extraData", extraData);
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		model.addAttribute("champion", "Kindred");

		model.addAttribute("mainsid", id);
	
		model.addAttribute("topics_data", jsonInString);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
	
		return "knowledge_tier_list";
	}
	
	
	
	
	@PostMapping("/deleteknowledge")
	public String deleteTopic(Model model, DeleteTopic DeleteTopic)
	{
	
		knowledgeservice.deleteKnowledge(knowledgeservice.findTopic(DeleteTopic.getTopicid()));
		return "redirect:/main/" + mainsservice.findMain(DeleteTopic.getMainid()).getName();
		
	}
	@RequestMapping("/newtierlist/{id}")
	public String createTierList(@PathVariable(value = "id") int id, Model model) {

		Mains main = mainsservice.findMain(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userservice.findByUserName(name);
		model.addAttribute("user", user);
		model.addAttribute("main", main);
		model.addAttribute("CreateUser", new CreateUser());
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		model.addAttribute("CreateTierList", new CreateTierList());
		return "new_tier_list";
	}

	@PostMapping("/newtierlistpost")
	public String createTierList(@ModelAttribute CreateTierList CreateTierList, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		TierList tl = new TierList();
		List<LeagueChampion> tiera= new ArrayList<LeagueChampion>();
		for (Long champion:CreateTierList.getTierlista()) {
			
			if (champion!=0) {
				tiera.add(leaguechampionservice.findByChampionid(champion));
			}
		
			
		}
		tl.setTiera(tiera);
		
		List<LeagueChampion> tierb= new ArrayList<LeagueChampion>();
		for (Long champion:CreateTierList.getTierlistb()) {
			
			if (champion!=0) {
				tierb.add(leaguechampionservice.findByChampionid(champion));
			}
			
		}
		tl.setTierb(tierb);
		
		List<LeagueChampion> tierc= new ArrayList<LeagueChampion>();
		for (Long champion:CreateTierList.getTierlistc()) {
			
			if (champion!=0) {
				tierc.add(leaguechampionservice.findByChampionid(champion));
			}
			
		}
		tl.setTierc(tierc);
		
		List<LeagueChampion> tierd= new ArrayList<LeagueChampion>();
		for (Long champion:CreateTierList.getTierlistd()) {
			
			if (champion!=0) {
				tierd.add(leaguechampionservice.findByChampionid(champion));
			}
			
		}
		tl.setTierd(tierd);
		
		Mains main = mainsservice.findMain(CreateTierList.getMainid());
		
		tl.setMain(main);
		
		TierList t=tierlistservice.findAllByMain(main);
		tl.setId(t.getId());
		tierlistservice.addTierList(tl);
		
		return "redirect:/knowledge/" + main.getName() + "/TierList";

	}
	@RequestMapping("/{id}/Build/{type}")
	public String knowledgeBuild(@PathVariable(value = "id") String id, @PathVariable(value = "type") String type,
			 Model model, HttpServletRequest ServletRequest) {

		int authCount = 0;
		Mains main = mainsservice.findByName(id);

		String sessionId = ServletRequest.getSession().getId();

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
	
		Knowledge	knowledge = knowledgeservice.findAllByMainAndTypeAndHeader(main, 1, type);
		

		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);
		
		model.addAttribute("main", main);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
	//	model.addAttribute("champion", main.getChampion().getName());
	//	model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledge", knowledge);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}

		return "knowledge_build";
	}
	@RequestMapping("/{id}/Items/{page}")
	public String knowledgeItems(@PathVariable(value = "id") String id, @PathVariable(value = "page") int page,
			 Model model, HttpServletRequest ServletRequest) {

		int authCount = 0;
		Mains main = mainsservice.findByName(id);

		String sessionId = ServletRequest.getSession().getId();

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
	
		Page<Knowledge>	knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page-1, 10), main, 3);
		int count=knowledgeservice.coundByMainAndType(main, 3);
		model.addAttribute("nextPage", false);
		if(count-page*10>10)
		{
			model.addAttribute("nextPage", true);
		}
		
		JSONArray extraData = new JSONArray();
		
		for(Knowledge knowledgei:knowledge)
		{
			JSONObject jo= new JSONObject();
			jo.put("id", knowledgei.getId());
			jo.put("content", knowledgei.getContent());
			extraData.put(jo);
			
		}
			
		model.addAttribute("extraData", extraData);
		
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);
		
		model.addAttribute("main", main);
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page+1);
		model.addAttribute("prevPage", page-1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}

		return "knowledge_items";
	}
	@RequestMapping("/{id}/TipsAndTricks/{page}")
	public String knowledgeTips(@PathVariable(value = "id") String id, @PathVariable(value = "page") int page,
			 Model model, HttpServletRequest ServletRequest) {


		int authCount = 0;
		Mains main = mainsservice.findByName(id);

		String sessionId = ServletRequest.getSession().getId();

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
	
		Page<Knowledge>	knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page-1, 10), main, 4);
		int count=knowledgeservice.coundByMainAndType(main, 4);
		model.addAttribute("nextPageConf", false);
		if(count-page*10>0)
		{
			model.addAttribute("nextPageConf", true);
		}
		
		JSONArray extraData = new JSONArray();
		
		for(Knowledge knowledgei:knowledge)
		{
			JSONObject jo= new JSONObject();
			jo.put("id", knowledgei.getId());
			jo.put("content", knowledgei.getContent());
			extraData.put(jo);
			
		}
			
		model.addAttribute("extraData", extraData);
		
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		
		
		model.addAttribute("main", main);
		model.addAttribute("type", "TipsAndTricks");
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page+1);
		model.addAttribute("prevPage", page-1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}

		return "knowledge_tips";
	}
	@RequestMapping("/{id}/Combos/{page}")
	public String Combos(@PathVariable(value = "id") String id, @PathVariable(value = "page") int page,
			 Model model, HttpServletRequest ServletRequest) {


		int authCount = 0;
		Mains main = mainsservice.findByName(id);

		String sessionId = ServletRequest.getSession().getId();

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
	
		Page<Knowledge>	knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page-1, 10), main, 9);
		int count=knowledgeservice.coundByMainAndType(main, 4);
		model.addAttribute("nextPageConf", false);
		if(count-page*10>0)
		{
			model.addAttribute("nextPageConf", true);
		}
		
		JSONArray extraData = new JSONArray();
		
		for(Knowledge knowledgei:knowledge)
		{
			JSONObject jo= new JSONObject();
			jo.put("id", knowledgei.getId());
			jo.put("content", knowledgei.getContent());
			extraData.put(jo);
			
		}
			
		model.addAttribute("extraData", extraData);
		
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		
		
		model.addAttribute("main", main);
		model.addAttribute("type", "TipsAndTricks");
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page+1);
		model.addAttribute("prevPage", page-1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}

		return "knowledge_combos";
	}
	@RequestMapping("/{id}/Champions/{page}")
	public String knowledgeChampions(@PathVariable(value = "id") String id, @PathVariable(value = "page") int page,
			 Model model, HttpServletRequest ServletRequest) {


		int authCount = 0;
		Mains main = mainsservice.findByName(id);

		String sessionId = ServletRequest.getSession().getId();

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
	
		Page<Knowledge>	knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page-1, 10), main, 5);
		int count=knowledgeservice.coundByMainAndType(main, 5);
		model.addAttribute("nextPageConf", false);
		if(count-page*10>0)
		{
			model.addAttribute("nextPageConf", true);
		}
		
		JSONArray extraData = new JSONArray();
		
		for(Knowledge knowledgei:knowledge)
		{
			JSONObject jo= new JSONObject();
			jo.put("id", knowledgei.getId());
			jo.put("content", knowledgei.getContent());
			extraData.put(jo);
			
		}
			
		model.addAttribute("extraData", extraData);
		
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		
		
		model.addAttribute("main", main);
		model.addAttribute("type", "TipsAndTricks");
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page+1);
		model.addAttribute("prevPage", page-1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);
		
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		
		return "knowledge_champions";
	}
	@RequestMapping("/{id}/Bugs/{page}")
	public String knowledgeBugs(@PathVariable(value = "id") String id, @PathVariable(value = "page") int page,
			 Model model, HttpServletRequest ServletRequest) {


		int authCount = 0;
		Mains main = mainsservice.findByName(id);

		String sessionId = ServletRequest.getSession().getId();

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
	
		Page<Knowledge>	knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page-1, 10), main, 8);
		int count=knowledgeservice.coundByMainAndType(main, 8);
		model.addAttribute("nextPageConf", false);
		if(count-page*10>0)
		{
			model.addAttribute("nextPageConf", true);
		}
		
		JSONArray extraData = new JSONArray();
		
		for(Knowledge knowledgei:knowledge)
		{
			JSONObject jo= new JSONObject();
			jo.put("id", knowledgei.getId());
			jo.put("content", knowledgei.getContent());
			extraData.put(jo);
			
		}
			
		model.addAttribute("extraData", extraData);
		
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		
		
		model.addAttribute("main", main);
		model.addAttribute("type", "TipsAndTricks");
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page+1);
		model.addAttribute("prevPage", page-1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);
		
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
	
		

		return "knowledge_bugs";
	}
}
