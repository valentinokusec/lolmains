package com.lolmains.web;

import org.springframework.web.bind.annotation.RestController;

import com.lolmains.domains.Champion;
import com.lolmains.domains.Comment;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Knowledge;
import com.lolmains.domains.User;
import com.lolmains.domains.UserRole;
import com.lolmains.domains.Video;
import com.lolmains.forms.CreateKnowledge;
import com.lolmains.forms.CreateMain;
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
@RequestMapping("/members")
public class MembersController {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	@Autowired
	VideoService videoservice;

	@Autowired
	MainsService mainsservice;

	@Autowired
	UserService userservice;
	
	@Autowired
	KnowledgeService knowledgeservice;

	@Autowired
	SummonerService summonerservice;

	@RequestMapping("/{mainn}/stats")
	public String membersStats(Model model, @PathVariable(value = "mainn") String mainn) {
		
		
		Mains main = mainsservice.findByName(mainn);
		
		int authCount = 0;
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
		
		List<Summoner> members= main.getSummoner();
		
		int challenger=0;
		int masters=0;
		int diamond=0;
		int platinum=0;
		int gold=0;
		int silver=0;
		int bronze=0;
		
		int morethan60=0;
		int morethan70=0;
		
		for (Summoner summoner: members) 
		{
		
			if(summoner.getTierNumber()<6)
			{
				bronze++;
			}
			else if(summoner.getTierNumber()<11)
			{
				silver++;
			}
			else if(summoner.getTierNumber()<16)
			{
				gold++;
			}
			else if(summoner.getTierNumber()<21)
			{
				platinum++;
			}
			else if(summoner.getTierNumber()<26)
			{
				diamond++;
			}
			else if(summoner.getTierNumber()<27)
			{
				masters++;
			}
			else if(summoner.getTierNumber()<28)
			{
				challenger++;
			}
			for(Champion champion:summoner.getChampion())
			{
				if (champion.getName().contains(main.getName())) {
					if (champion.getWinrate()>=70) {
						morethan70++;
					}
					else if(champion.getWinrate()>=60)
					{
						morethan60++;
					}
				}
			}
		}
		int count = summonerservice.countByMain(main);
		model.addAttribute("nextPage", false);
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		model.addAttribute("users", main.getSummoner());
		model.addAttribute("main",main);
		model.addAttribute("challenger",challenger);
		model.addAttribute("masters",masters);
		model.addAttribute("diamond",diamond);
		model.addAttribute("platinum",platinum);
		model.addAttribute("gold",gold);
		model.addAttribute("silver",silver);
		model.addAttribute("bronze",bronze);
		model.addAttribute("morethan70",morethan70);
		model.addAttribute("morethan60",morethan60);
		model.addAttribute("CreateUser", new CreateUser());
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		return "members_stats";
	}
	
	@RequestMapping("/{mainn}/{page}")
	public String members(Model model, @PathVariable(value = "mainn") String mainn,  @PathVariable(value = "page") int page) {

		Mains main = mainsservice.findByName(mainn);
		Page<Summoner> members= summonerservice.findByMain(new PageRequest(page-1,10), main);
		int authCount = 0;
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
		int challenger=0;
		int masters=0;
		int diamond=0;
		int platinum=0;
		int gold=0;
		int silver=0;
		int bronze=0;
		
		int morethan60=0;
		int morethan70=0;
		
		for (Summoner summoner: members) 
		{
		
			if(summoner.getTierNumber()<6)
			{
				bronze++;
			}
			else if(summoner.getTierNumber()<11)
			{
				silver++;
			}
			else if(summoner.getTierNumber()<16)
			{
				gold++;
			}
			else if(summoner.getTierNumber()<21)
			{
				platinum++;
			}
			else if(summoner.getTierNumber()<26)
			{
				diamond++;
			}
			else if(summoner.getTierNumber()<27)
			{
				masters++;
			}
			else if(summoner.getTierNumber()<28)
			{
				challenger++;
			}
			for(Champion champion:summoner.getChampion())
			{
				if (champion.getName().contains(main.getName())) {
					if (champion.getWinrate()>=70) {
						morethan70++;
					}
					else if(champion.getWinrate()>=60)
					{
						morethan60++;
					}
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
		int count = summonerservice.countByMain(main);
		model.addAttribute("nextPage", false);
		if (count - page * 10 > 10) {
			model.addAttribute("nextPage", true);
		}
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		model.addAttribute("users", main.getSummoner());
		model.addAttribute("main",main);
		model.addAttribute("challenger",challenger);
		model.addAttribute("masters",masters);
		model.addAttribute("diamond",diamond);
		model.addAttribute("platinum",platinum);
		model.addAttribute("gold",gold);
		model.addAttribute("silver",silver);
		model.addAttribute("bronze",bronze);
		model.addAttribute("morethan70",morethan70);
		model.addAttribute("morethan60",morethan60);
		model.addAttribute("CreateUser", new CreateUser());
		
		return "members";
	}
	@PostMapping("/deletemember")
	public String deleteTopic(Model model, DeleteTopic DeleteTopic)
	{
		Mains main=mainsservice.findMain(DeleteTopic.getMainid());
		List<Summoner> summl=main.getSummoner();
	
			Summoner sum=summonerservice.findSummoners(DeleteTopic.getTopicid());
			summl.remove(summl.indexOf(sum));
		
		main.setSummoner(summl);
		mainsservice.addMain(main);
		return "redirect:/main/" + mainsservice.findMain(DeleteTopic.getMainid()).getName();
		
	}
	@PostMapping("/addAdmin")
	public String addAdmin(Model model, DeleteTopic DeleteTopic)
	{
		Mains main=mainsservice.findMain(DeleteTopic.getMainid());
		List<User> summl=main.getAdmins();
	
			User sum=userservice.findById(DeleteTopic.getTopicid());
			summl.add(sum);
		
		main.setAdmins(summl);
		mainsservice.addMain(main);
		return "redirect:/main/" + mainsservice.findMain(DeleteTopic.getMainid()).getName();
		
	}
}
