package com.lolmains.web;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lolmains.domains.Champion;
import com.lolmains.domains.Comment;
import com.lolmains.domains.Mains;
import com.lolmains.domains.TierList;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Knowledge;
import com.lolmains.domains.User;
import com.lolmains.domains.UserRole;
import com.lolmains.domains.Video;
import com.lolmains.forms.CreateKnowledge;
import com.lolmains.forms.CreateMain;
import com.lolmains.forms.CreateTierList;
import com.lolmains.forms.CreateTopic;
import com.lolmains.forms.CreateUser;
import com.lolmains.forms.CreateVideo;
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
@RequestMapping("/discussions")
public class DiscussionsController {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	@Autowired
	VideoService videoservice;

	@Autowired
	TierListService tierlistservice;
	
	@Autowired
	KnowledgeService knowledgeservice;
	
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
			if (main.getSummoner().contains(user.getSummoner())) {
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
	
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		model.addAttribute("main", main);
		model.addAttribute("extraData", extraData);
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		model.addAttribute("champion", "Kindred");

		model.addAttribute("mainsid", id);
	
		model.addAttribute("topics_data", jsonInString);
		
	
		return "discussions_tier_list";
	}
	
	
	@RequestMapping("/{id}/{page}/{type}")
	public String discussions(@PathVariable(value = "id") String id, @PathVariable(value = "type") String type,
			@PathVariable(value = "page") int page, Model model, HttpServletRequest ServletRequest) {

		int authCount = 0;
		Mains main = mainsservice.findByName(id);

		String sessionId = ServletRequest.getSession().getId();

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

		String name = auth.getName();
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		int typen = 0;
		Page<Discussion> list;
		if (type.equals("General")) {
			typen = 1;
		} else if (type.equals("Build")) {
			typen = 2;
		} else if (type.equals("Compare")) {
			typen = 3;
		} else if (type.equals("Item")) {
			typen = 4;
		} else if (type.equals("MathUp")) {
			typen = 5;
		} else if (type.equals("Vide")) {
			typen = 6;
		} else if (type.equals("PathNotes")) {
			typen = 7;
		}

		if (typen == 0) {
			list = discussionservice.findAllByMain(new PageRequest(page - 1, 10), main);
		} else {
			list = discussionservice.findAllByMainAndType(new PageRequest(page - 1, 10), main, typen);
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";
		try {
			jsonInString = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Discussion dis : list) {
			String time = "";
			JSONObject data = new JSONObject();
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
			if (list.getSize() == 10) {

			}
			data.put("id", dis.getId());
			data.put("time", time);

			data.put("count", count);
			extraData.put(data);
		}
		int count = list.getSize();
		model.addAttribute("nextPage", false);
		if (count - page * 10 > 10) {
			model.addAttribute("nextPage", true);
		}
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);
		model.addAttribute("pagination", page);
		model.addAttribute("type", type);
		model.addAttribute("main", main);
		model.addAttribute("extraData", extraData);
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		model.addAttribute("champion", "Kindred");
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		model.addAttribute("mainsid", id);
		model.addAttribute("topics", list);
		model.addAttribute("topics_data", jsonInString);
		
		if (id.contentEquals("Top") || id.contentEquals("Jungle") || id.contentEquals("Adc") || id.contentEquals("Support") || id.contentEquals("Mid")) {
			return "discussions_group";
		}
		
		return "discussions";
	}
	
	
	
	
	
}
