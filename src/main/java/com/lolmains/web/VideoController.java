package com.lolmains.web;

import org.springframework.web.bind.annotation.RestController;

import com.lolmains.domains.Champion;
import com.lolmains.domains.Comment;
import com.lolmains.domains.Mains;
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
@RequestMapping("/videos")
public class VideoController {

	private static final String API_KEY = "172d9054-b070-449d-bb68-cbbe94f29e7c";

	@Autowired
	VideoService videoservice;

	@Autowired
	MainsService mainsservice;
	
	@Autowired
	KnowledgeService knowledgeservice;

	@Autowired
	UserService userservice;

	@Autowired
	SummonerService summonerservice;

	@RequestMapping("/{id}/new/{page}")
	public String videoNew(@PathVariable(value = "id") String id,
			@PathVariable(value = "page") int page, Model model, HttpServletRequest ServletRequest) {

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

		Page<Video> videos = videoservice.findAllByMain(new PageRequest(page - 1, 12), main);
		int count = videoservice.countByMain(main);
		model.addAttribute("nextPage", false);
		if (count - page * 10 > 10) {
			model.addAttribute("nextPage", true);
		}

		JSONArray extraData = new JSONArray();

		for (Video video : videos) {
			JSONObject jo = new JSONObject();
			jo.put("id", video.getId());
			jo.put("content", video.getContent());
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

		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("videos", videos);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		return "video_new";
	}
	@RequestMapping("/{id}/rising/{page}")
	public String videoRising(@PathVariable(value = "id") String id,
			@PathVariable(value = "page") int page, Model model, HttpServletRequest ServletRequest) {

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

		Page<Video> videos = videoservice.findAllByMain(new PageRequest(page - 1, 10), main);
		int count = videoservice.countByMain(main);
		model.addAttribute("nextPage", false);
		if (count - page * 10 > 10) {
			model.addAttribute("nextPage", true);
		}

		JSONArray extraData = new JSONArray();

		for (Video video : videos) {
			JSONObject jo = new JSONObject();
			jo.put("id", video.getId());
			jo.put("content", video.getContent());
			extraData.put(jo);

		}

		model.addAttribute("extraData", extraData);

		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		

		model.addAttribute("main", main);
		model.addAttribute("pagination", page);
		model.addAttribute("nextPage", page + 1);
		model.addAttribute("prevPage", page - 1);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}
		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("videos", videos);
		return "video_rising";
	}
	@RequestMapping("/{id}/featured")
	public String videoFeatured(@PathVariable(value = "id") String id, 
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

		Page<Video> videos = videoservice.findAllByMain(new PageRequest( 0, 5), main);
		List<Video> main_video =new ArrayList<Video>();
		main_video = videoservice.findAllByMainOrderByLikesDesc(main);
	
		model.addAttribute("nextPage", false);
		

		JSONArray extraData = new JSONArray();

		for (Video video : videos) {
			JSONObject jo = new JSONObject();
			jo.put("id", video.getId());
			jo.put("content", video.getContent());
			extraData.put(jo);

		}

		model.addAttribute("extraData", extraData);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}

		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);
	

		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("videos", videos);
		return "video";
	}
	@RequestMapping("/{id}/{name}")
	public String videoName(@PathVariable(value = "id") String id, @PathVariable(value = "name") int name,
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

		Page<Video> videos = videoservice.findAllByMain(new PageRequest( 0, 5), main);
		
		JSONArray extraData = new JSONArray();
		
		
		for (Video video : videos) {
			JSONObject jo = new JSONObject();
			jo.put("id", video.getId());
			jo.put("content", video.getContent());
			extraData.put(jo);

		}
		Video main_video = videoservice.findVideo(name);
		
		model.addAttribute("nextPage", false);
		

	

		model.addAttribute("extraData", extraData);
		model.addAttribute("main_video", main_video);

		model.addAttribute("sessionid", sessionId);
		model.addAttribute("CreateUser", new CreateUser());
		model.addAttribute("nextpage", true);

		model.addAttribute("main", main);
		if (!knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).isEmpty()) {
			model.addAttribute("mainbuild", knowledgeservice.findAllTop1ByMainAndTypeAndHeader(main, 1).iterator().next().getHeader());
		} 
		else
		{
			model.addAttribute("mainbuild","empty");
		}

		model.addAttribute("user", user);
		model.addAttribute("authCount", authCount);
//		model.addAttribute("champion", main.getChampion().getName());
//		model.addAttribute("championid", main.getChampion().getId());
		model.addAttribute("mainsid", id);
		model.addAttribute("videos", videos);
		return "video";
	}
	@RequestMapping("/newvideo/{id}")
	public String createVideo(@PathVariable(value = "id") int id, Model model) {

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
		model.addAttribute("CreateVideo", new CreateVideo());
		return "new_video";
	}

	@PostMapping("/newvideo")
	public String addTopic(@ModelAttribute CreateVideo CreateVideo, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		Video video = new Video();
		video.setUser(userservice.findByUserName(name).getSummoner());
		video.setMain(mainsservice.findMain(CreateVideo.getMainsid()));
		video.setType(CreateVideo.getType());
		video.setHeader(CreateVideo.getHeader());
		video.setContent(CreateVideo.getContent());
		video.setDate(new Timestamp(System.currentTimeMillis()));
		Mains main = mainsservice.findMain(CreateVideo.getMainsid());
		// Champion ch=championservice.findChampion(1);
		String url = CreateVideo.getUrl();
		url = url.substring(32);
		String url_list[] = url.split("&");
		url = url_list[0];
		video.setUrl(url);
		videoservice.createVideo(video);

		return "redirect:/videos/" + main.getName() + "/main/1";

	}
}
