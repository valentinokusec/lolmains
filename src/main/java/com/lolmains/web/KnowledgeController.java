package com.lolmains.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lolmains.domains.CreateMessage;
import com.lolmains.domains.Knowledge;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.Link;
import com.lolmains.domains.LinkGroup;
import com.lolmains.domains.MailingList;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Subsctriction;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.TierList;
import com.lolmains.domains.User;
import com.lolmains.forms.CreateTierList;
import com.lolmains.forms.CreateUser;
import com.lolmains.forms.DeleteTopic;
import com.lolmains.services.CommentService;
import com.lolmains.services.DiscussionService;
import com.lolmains.services.KnowledgeService;
import com.lolmains.services.LeagueChampionService;
import com.lolmains.services.LinkGroupService;
import com.lolmains.services.LinkService;
import com.lolmains.services.MailService;
import com.lolmains.services.MailingListService;
import com.lolmains.services.MainsService;
import com.lolmains.services.SummonerService;
import com.lolmains.services.TierListService;
import com.lolmains.services.UserService;
import com.lolmains.services.VideoService;

@Controller
@RequestMapping("/knowledge")
public class KnowledgeController {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	@Autowired
	VideoService videoservice;

	@Autowired
	com.lolmains.services.SubstrictionService SubstrictionService;

	@Autowired
	com.lolmains.services.SubstrictinItemService SubstrictinItemService;

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
	
	@Autowired
	MailService mailservice;

	@Autowired
	LinkGroupService linkgroupservice;

	@Autowired
	LinkService linkservice;
	
	@Autowired
	MailingListService mailnglistservice;

	@RequestMapping("/{id}/TierList")
	public String discussionsTierList(@PathVariable(value = "id") String id, Model model,
			HttpServletRequest ServletRequest) {

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

		model.addAttribute("main", main);
		model.addAttribute("tl", tl);
		model.addAttribute("extraData", extraData);
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		model.addAttribute("champion", "Kindred");

		model.addAttribute("mainsid", id);

		model.addAttribute("topics_data", jsonInString);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_tier_list";
	}

	@PostMapping("/deleteknowledge")
	public String deleteTopic(Model model, DeleteTopic DeleteTopic) {

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
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}
		model.addAttribute("CreateTierList", new CreateTierList());
		return "new_tier_list";
	}

	@PostMapping("/newtierlistpost")
	public String createTierList(@ModelAttribute CreateTierList CreateTierList, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		TierList tl = new TierList();
		List<LeagueChampion> tiera = new ArrayList<LeagueChampion>();
		for (Long champion : CreateTierList.getTierlista()) {

			if (champion != 0) {
				tiera.add(leaguechampionservice.findByChampionid(champion));
			}

		}
		tl.setTiera(tiera);

		List<LeagueChampion> tierb = new ArrayList<LeagueChampion>();
		for (Long champion : CreateTierList.getTierlistb()) {

			if (champion != 0) {
				tierb.add(leaguechampionservice.findByChampionid(champion));
			}

		}
		tl.setTierb(tierb);

		List<LeagueChampion> tierc = new ArrayList<LeagueChampion>();
		for (Long champion : CreateTierList.getTierlistc()) {

			if (champion != 0) {
				tierc.add(leaguechampionservice.findByChampionid(champion));
			}

		}
		tl.setTierc(tierc);

		List<LeagueChampion> tierd = new ArrayList<LeagueChampion>();
		for (Long champion : CreateTierList.getTierlistd()) {

			if (champion != 0) {
				tierd.add(leaguechampionservice.findByChampionid(champion));
			}

		}
		tl.setTierd(tierd);

		Mains main = mainsservice.findMain(CreateTierList.getMainid());

		tl.setMain(main);

		TierList t = tierlistservice.findAllByMain(main);
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
			if (main.getSummoner().contains(user.getSummoner())) {
				authCount = 2;
				if (main.getAdmins().contains(user)) {
					authCount = 3;
				}
			}
		}

		Knowledge knowledge = knowledgeservice.findAllByMainAndTypeAndHeader(main, 1, type);
		Page<Knowledge> knowledgeList = knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1);
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("summoners_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 11));
		model.addAttribute("runes_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 7));
		model.addAttribute("masteries_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 6));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledge", knowledge);
		model.addAttribute("knowledgeList", knowledgeList);
		
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_build";
	}
	@RequestMapping("/{id}/Summoners/{type}")
	public String knowledgeSummoners(@PathVariable(value = "id") String id, @PathVariable(value = "type") String type,
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

		Knowledge knowledge = knowledgeservice.findAllByMainAndTypeAndHeader(main, 11, type);
		Page<Knowledge> knowledgeList = knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 11);
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);
		model.addAttribute("summoners_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 11));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledge", knowledge);
		model.addAttribute("knowledgeList", knowledgeList);
		
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_summoners";
	}
	@RequestMapping("/{id}/Masteries/{type}")
	public String knowledgeMasteries(@PathVariable(value = "id") String id, @PathVariable(value = "type") String type,
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

		Knowledge knowledge = knowledgeservice.findAllByMainAndTypeAndHeader(main, 6, type);
		Page<Knowledge> knowledgeList = knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 6);
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledge", knowledge);
		model.addAttribute("knowledgeList", knowledgeList);
		
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_masteries";
	}
	@RequestMapping("/{id}/Runes/{type}")
	public String knowledgeRunes(@PathVariable(value = "id") String id, @PathVariable(value = "type") String type,
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

		Knowledge knowledge = knowledgeservice.findAllByMainAndTypeAndHeader(main, 7, type);
		Page<Knowledge> knowledgeList = knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 7);
		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("summoners_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 11));
		model.addAttribute("runes_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 7));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledge", knowledge);
		model.addAttribute("knowledgeList", knowledgeList);
		
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_runes";
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
			if (main.getSummoner().contains(user.getSummoner())) {
				authCount = 2;
				if (main.getAdmins().contains(user)) {
					authCount = 3;
				}
			}
		}

		Page<Knowledge> knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page - 1, 10), main, 3);
		int count = knowledgeservice.coundByMainAndType(main, 3);
		model.addAttribute("nextPage", false);
		if (count - page * 10 > 10) {
			model.addAttribute("nextPage", true);
		}

		JSONArray extraData = new JSONArray();

		for (Knowledge knowledgei : knowledge) {
			JSONObject jo = new JSONObject();
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
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_items";
	}

	@RequestMapping("/{id}/Links")
	public String knowledgeLinks(@PathVariable(value = "id") String id, Model model,
			HttpServletRequest ServletRequest) {

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

		List<LinkGroup> links = linkgroupservice.findByMain(main);

		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);

		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("linksgroups", links);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_links";
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
			if (main.getSummoner().contains(user.getSummoner())) {
				authCount = 2;
				if (main.getAdmins().contains(user)) {
					authCount = 3;
				}
			}
		}

		Page<Knowledge> knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page - 1, 10), main, 4);
		int count = knowledgeservice.coundByMainAndType(main, 4);
		model.addAttribute("nextPageConf", false);
		if (count - page * 10 > 0) {
			model.addAttribute("nextPageConf", true);
		}

		JSONArray extraData = new JSONArray();

		for (Knowledge knowledgei : knowledge) {
			JSONObject jo = new JSONObject();
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
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_tips";
	}

	@RequestMapping("/{id}/Combos/{page}")
	public String Combos(@PathVariable(value = "id") String id, @PathVariable(value = "page") int page, Model model,
			HttpServletRequest ServletRequest) {

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

		Page<Knowledge> knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page - 1, 10), main, 9);
		int count = knowledgeservice.coundByMainAndType(main, 4);
		model.addAttribute("nextPageConf", false);
		if (count - page * 10 > 0) {
			model.addAttribute("nextPageConf", true);
		}

		JSONArray extraData = new JSONArray();

		for (Knowledge knowledgei : knowledge) {
			JSONObject jo = new JSONObject();
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
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
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
			if (main.getSummoner().contains(user.getSummoner())) {
				authCount = 2;
				if (main.getAdmins().contains(user)) {
					authCount = 3;
				}
			}
		}

		Page<Knowledge> knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page - 1, 10), main, 5);
		int count = knowledgeservice.coundByMainAndType(main, 5);
		model.addAttribute("nextPageConf", false);
		if (count - page * 10 > 0) {
			model.addAttribute("nextPageConf", true);
		}

		JSONArray extraData = new JSONArray();

		for (Knowledge knowledgei : knowledge) {
			JSONObject jo = new JSONObject();
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
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);

		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
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
			if (main.getSummoner().contains(user.getSummoner())) {
				authCount = 2;
				if (main.getAdmins().contains(user)) {
					authCount = 3;
				}
			}
		}

		Page<Knowledge> knowledge = knowledgeservice.findAllByMainAndType(new PageRequest(page - 1, 10), main, 8);
		int count = knowledgeservice.coundByMainAndType(main, 8);
		model.addAttribute("nextPageConf", false);
		if (count - page * 10 > 0) {
			model.addAttribute("nextPageConf", true);
		}

		JSONArray extraData = new JSONArray();

		for (Knowledge knowledgei : knowledge) {
			JSONObject jo = new JSONObject();
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
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("knowledges", knowledge);

		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_bugs";
	}

	@RequestMapping("/{id}/Substrictions/{page}")
	public String knowledgeSubstrictions(@PathVariable(value = "id") String id, @PathVariable(value = "page") int page,
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

		Page<Subsctriction> Subsctriction = SubstrictionService.findAllByMain(new PageRequest(page - 1, 10), main);
		int count = knowledgeservice.coundByMainAndType(main, 3);
		model.addAttribute("nextPage", false);
		if (count - page * 10 > 10) {
			model.addAttribute("nextPage", true);
		}

		JSONArray extraData = new JSONArray();

		for (Subsctriction Subsctrictioni : Subsctriction) {
			JSONObject jo = new JSONObject();
			jo.put("id", Subsctrictioni.getId());
			jo.put("content", Subsctrictioni.getContent());
			extraData.put(jo);

		}

		model.addAttribute("extraData", extraData);

		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("MailingList", new MailingList());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("SubsctrictionsData", Subsctriction);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_substriction";
	}

	@RequestMapping("/{id}/Substriction/{substriction}")
	public String knowledgeSubstriction(@PathVariable(value = "id") String id,
			@PathVariable(value = "substriction") int substriction, Model model, HttpServletRequest ServletRequest) {

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

		Subsctriction Subsctriction = SubstrictionService.findSubsctriction(substriction);

		JSONObject jo = new JSONObject();
		jo.put("id", Subsctriction.getId());
		jo.put("content", Subsctriction.getContent());

		model.addAttribute("extraData", jo);

		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);

		model.addAttribute("build_list", knowledgeservice.findAllByMainAndType(new PageRequest(0, 10), main, 1));
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
		// model.addAttribute("champion", main.getChampion().getName());
		// model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("subsctriction", Subsctriction);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}

		return "knowledge_substriction_item";
	}

	@RequestMapping("/newsubsctriction/{id}")
	public String newSubsctriction(@PathVariable(value = "id") int id, Model model) {

		Mains main = mainsservice.findMain(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userservice.findByUserName(name);
		model.addAttribute("user", user);
		model.addAttribute("main", main);
		model.addAttribute("mainobject", main.toString());
		model.addAttribute("CreateUser", new CreateUser());
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild",
					knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} else {
			model.addAttribute("mainbuild", "empty");
		}
		model.addAttribute("Subsctriction", new Subsctriction());
		return "new_substriction";
	}

	@PostMapping("/newsbsctriction")
	public String newSubstriction(Model model, Subsctriction Subsctriction, @RequestParam("mainid") int id) {

		Subsctriction.setMain(mainsservice.findMain(id));
		Subsctriction.setDate(new Timestamp(System.currentTimeMillis()));
		SubstrictionService.addSubsctriction(Subsctriction);
		return "redirect:/main/" + Subsctriction.getMain().getName();

	}

	@PostMapping("/newlink")
	public String newLink(Model model, Link link, @RequestParam("groupid") int id) {

		LinkGroup lg = linkgroupservice.findAll(id);
		List<Link> linkList = lg.getLink();
		linkservice.addLink(link);
		linkList.add(link);
		linkgroupservice.addLinkGroup(lg);
		return "redirect:/main/" + lg.getMain().getName();

	}

	@PostMapping("/newsubstrictor")
	public String newSubstrictor(Model model, MailingList email, @RequestParam("mainid") int id,
			@RequestParam("userid") int userId) {
		
		mailnglistservice.addMailingList(email);
		Mains main = mainsservice.findMain(id);
		List<MailingList> mailingListt= main.getMailingList();
		mailingListt.add(email);
		main.setMailingList(mailingListt);
		mainsservice.addMain(main);
		Summoner summoner=userservice.findById(userId).getSummoner();
		List<MailingList> mailingListUser=summoner.getMailingList();
		mailingListUser.add(email);
		summoner.setMailingList(mailingListUser);
		summonerservice.addSummoners(summoner);
	
		return "redirect:/main/" + main.getName();

	}
	@PostMapping("/sendmail")
	public String sendMails(Model model, MailingList email, @RequestParam("mainid") int id) {
		
	
		Mains main = mainsservice.findMain(id);
		List<MailingList> mailingListt= main.getMailingList();
		for (MailingList mailingList : mailingListt) {
		
			CreateMessage cm= new CreateMessage();
			cm.setEmail(	mailingList.getEmail());
			cm.setMessage("dd");
			mailservice.sendMail(cm);
		}
	
		return "redirect:/main/" + main.getName();

	}
}