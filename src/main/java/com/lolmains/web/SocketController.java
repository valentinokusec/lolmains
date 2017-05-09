package com.lolmains.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.lolmains.domains.ChampionSpells;
import com.lolmains.domains.Comment;
import com.lolmains.domains.CommentLikes;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Item;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Notification;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.User;
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;
import com.lolmains.forms.GetContent;
import com.lolmains.forms.GetCount;
import com.lolmains.forms.Greeting;
import com.lolmains.forms.HelloMessage;
import com.lolmains.forms.ItemPojo;
import com.lolmains.forms.SearchData;
import com.lolmains.forms.Stats;
import com.lolmains.repository.CommentLikesDao;
import com.lolmains.services.BestOfService;
import com.lolmains.services.BuildService;
import com.lolmains.services.ChampionService;
import com.lolmains.services.ChampionSpellService;
import com.lolmains.services.CommentService;
import com.lolmains.services.DiscussionLikesService;
import com.lolmains.services.DiscussionService;
import com.lolmains.services.GuideService;
import com.lolmains.services.ItemService;
import com.lolmains.services.LeagueChampionService;
import com.lolmains.services.LeagueRunesService;
import com.lolmains.services.LeagueSummonersService;
import com.lolmains.services.MainsService;
import com.lolmains.services.MasteriesService;
import com.lolmains.services.NotificationService;
import com.lolmains.services.RunesService;
import com.lolmains.services.SummonerService;
import com.lolmains.services.SummonersService;
import com.lolmains.services.UserService;
import com.lolmains.services.VideoLikesService;
import com.lolmains.services.VideoService;

@Controller
public class SocketController {

	@Autowired
	MainsService mainsservice;
	
	@Autowired
	VideoService videoservice;
	
	@Autowired
	VideoLikesService videlikesservice;

	@Autowired
	ChampionSpellService spellservice;

	@Autowired
	NotificationService notificationservice;

	@Autowired
	DiscussionLikesService discussionlikesservice;

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
	CommentLikesDao commentlikesdao;

	@Autowired
	LeagueRunesService leaguerunesservice;

	@Autowired
	ChampionSpellService championspellservice;

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

	@MessageMapping("/comment/{id}")
	@SendTo("/topic/greetings/{id}")
	public Greeting greeting(@DestinationVariable String id, HelloMessage message) throws Exception {

		User user = userservice.findById(Integer.parseInt(message.getUser()));
		Comment comment = new Comment();
		comment.setContent(message.getName());
		comment.setUser(user.getSummoner());
		comment.setReply(false);
		comment.setDate(new Timestamp(System.currentTimeMillis()));
		comment.setVotes(0);
		comment.setCommentid(0);
		comment.setDiscussionId(Integer.parseInt(id));
		commentservice.addComment(comment);
		Notification not = new Notification();
		not.setFromuser(user.getSummoner());
		not.setContent("Upvoted your post");
		not.setTouser(comment.getUser());
		notificationservice.addNotification(not);

		Summoner owner = comment.getUser();
		List<Notification> listNot = owner.getNotification();
		listNot.add(not);
		int counter = owner.getNotificationcount();
		counter++;
		owner.setNotificationcount(counter);
		owner.setNotification(listNot);

		summonerservice.addSummoners(owner);
		return new Greeting(message.getName(), comment.getId(), comment.getReply(), message.getId(), user.getId(),
				user.getSummoner().getImage(), user.getSummoner().getName(), counter, not.toString());
	}

	@MessageMapping("/reply/{id}")
	@SendTo("/topic/greetings/{id}")
	public Greeting reply(@DestinationVariable String id, HelloMessage message) throws Exception {

		User user = userservice.findById(Integer.parseInt(message.getUser()));
		Comment comment = commentservice.findComment(message.getId());
		List<Comment> comlist = comment.getComment();
		Notification not = new Notification();
		not.setFromuser(user.getSummoner());
		not.setContent("Replied to your post");
		not.setTouser(comment.getUser());
		notificationservice.addNotification(not);

		Summoner owner = comment.getUser();
		List<Notification> listNot = owner.getNotification();
		listNot.add(not);
		int counter = owner.getNotificationcount();
		counter++;
		owner.setNotificationcount(counter);
		owner.setNotification(listNot);

		summonerservice.addSummoners(owner);
		Comment reply = new Comment();
		reply.setContent(message.getName());
		reply.setReply(true);
		reply.setVotes(0);
		reply.setDate(new Timestamp(System.currentTimeMillis()));
		reply.setUser(user.getSummoner());
		reply.setCommentid(comment.getId());
		commentservice.addComment(reply);

		comlist.add(reply);

		comment.setComment(comlist);
		commentservice.addComment(comment);
		return new Greeting(message.getName(), reply.getId(), reply.getReply(), message.getId(), user.getId(),
				user.getSummoner().getImage(), user.getSummoner().getName(), counter, not.toString());
	}

	@MessageMapping("/setlikediscussion/{id}")
	@SendTo("/topic/main/{id}")
	public Greeting connectToMains(@DestinationVariable String id, GetCount message) throws Exception {

		DiscussionLikes dl = new DiscussionLikes();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userservice.findByUserName(auth.getName());
		Discussion topic = discussionservice.findTopic(message.getId());

		Notification not = new Notification();
		not.setFromuser(user.getSummoner());
		
		not.setTouser(topic.getUser().getSummoner());

		dl.setDiscussion(topic);
		dl.setUser(user);
		int count;
		if (message.getType() == 1) {
			count = message.getCount() + 1;
			dl.setState(true);
			not.setContent("Upvoted your post");
		} else {
			count = message.getCount() - 1;
			dl.setState(false);
			not.setContent("Downvoted your post");
		}
		discussionlikesservice.addDiscussionLikes(dl);
		topic.setVotes(count);
		discussionservice.addTopic(topic);
		notificationservice.addNotification(not);

		Summoner owner = topic.getUser().getSummoner();
		List<Notification> listNot = owner.getNotification();
		listNot.add(not);
		int counter = owner.getNotificationcount();
		counter++;
		owner.setNotificationcount(counter);
		owner.setNotification(listNot);

		summonerservice.addSummoners(owner);
		return new Greeting(count + "", message.getId(), dl.isState(), 0, count, 0, id, counter, not.toString());
	}
	@MessageMapping("/setlikevideo/{id}")
	@SendTo("/topic/video/{id}")
	public Greeting connectToVideo(@DestinationVariable String id, GetCount message) throws Exception {

		VideoLikes dl = new VideoLikes();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userservice.findByUserName("tino");
		Video topic = videoservice.findVideo(message.getId());

		Notification not = new Notification();
		not.setFromuser(user.getSummoner());
		
		not.setTouser(topic.getUser());

		dl.setVideo(topic);
		dl.setUser(user.getSummoner());
		int count;
	//	if (message.getType() == 1) {
			count = message.getCount() + 1;
			dl.setState(true);
			not.setContent("Upvoted your video");
//		} else {
//			count = message.getCount() + 1;
//			dl.setState(false);
//			not.setContent("Upvoted your video");
//		}
		videlikesservice.createVideoLikes(dl);
		topic.setLikes(count);
		videoservice.createVideo(topic);
		notificationservice.addNotification(not);

		Summoner owner = topic.getUser();
		List<Notification> listNot = owner.getNotification();
		listNot.add(not);
		int counter = owner.getNotificationcount();
		counter++;
		owner.setNotificationcount(counter);
		owner.setNotification(listNot);

		summonerservice.addSummoners(owner);
		return new Greeting(count + "", message.getId(), dl.isState(), 0, count, 0, id, counter, not.toString());
	}
	@MessageMapping("/setlikediscussiontopic/{id}")
	@SendTo("/topic/topiclikes/{id}")
	public Greeting setlikediscussiontopic(@DestinationVariable String id, GetCount message) throws Exception {

		int count;
		User user = userservice.findById(message.getUser());
		Discussion topic = discussionservice.findTopic(message.getId());
		Notification not = new Notification();
		not.setFromuser(user.getSummoner());
		
		not.setTouser(topic.getUser().getSummoner());
		

		DiscussionLikes dl = discussionlikesservice.findByUserAndDiscussion(user, topic);
		if (dl == null) {
			dl = new DiscussionLikes();
			dl.setDiscussion(topic);
			dl.setUser(user);

			if (message.getType() == 1) {
				count = message.getCount() + 1;
				dl.setState(true);
				not.setContent("Upvoted your post");

			} else {
				count = message.getCount() - 1;
				dl.setState(false);
				not.setContent("Downvoted your post");
			}
			discussionlikesservice.addDiscussionLikes(dl);
			topic.setVotes(count);
			discussionservice.addTopic(topic);
		} else {
			if (message.getType() == 1) {
				not.setContent("Upvoted your post");
				count = message.getCount() + 2;
				dl.setState(true);

			} else {
				not.setContent("Upvoted your post");
				count = message.getCount() - 2;
				dl.setState(false);
			}
			discussionlikesservice.addDiscussionLikes(dl);
			topic.setVotes(count);
			discussionservice.addTopic(topic);
		}
		notificationservice.addNotification(not);

		Summoner owner = topic.getUser().getSummoner();
		List<Notification> listNot = owner.getNotification();
		listNot.add(not);
		int counter = owner.getNotificationcount();
		counter++;
		owner.setNotificationcount(counter);
		owner.setNotification(listNot);

		summonerservice.addSummoners(owner);
		return new Greeting(count + "", message.getId(), dl.isState(), 0, count, counter, not.toString(), counter,
				not.toString());
	}

	@MessageMapping("/setlikediscussioncomment/{id}")
	@SendTo("/topic/topiclikesreply/{id}")
	public Greeting setlikediscussiontopiccomment(@DestinationVariable String id, GetCount message) throws Exception {

		CommentLikes vl = new CommentLikes();

		User user = userservice.findById(message.getUser());
		Comment topic = commentservice.findComment(message.getId());
		Notification not = new Notification();
		not.setFromuser(user.getSummoner());
		
		not.setTouser(topic.getUser());
	
		CommentLikes dl = commentlikesdao.findByUserAndComment(user, topic);
		int count;
		if (dl == null) {
			dl = new CommentLikes();
			dl.setComment(topic);
			dl.setUser(user);

			if (message.getType() == 1) {
				count = message.getCount() + 1;
				dl.setState(true);
				not.setContent("Upvoted your post");

			} else {
				count = message.getCount() - 1;
				dl.setState(false);
				not.setContent("Downvoted your post");
			}
			commentlikesdao.save(dl);
			topic.setVotes(count);
			commentservice.addComment(topic);
		} else {
			if (message.getType() == 1) {
				not.setContent("Upvoted your post");
				count = message.getCount() + 2;
				dl.setState(true);

			} else {
				not.setContent("Upvoted your post");
				count = message.getCount() - 2;
				dl.setState(false);
			}
			commentlikesdao.save(dl);
			topic.setVotes(count);
			commentservice.addComment(topic);
		}
		notificationservice.addNotification(not);

		Summoner owner = topic.getUser();
		List<Notification> listNot = owner.getNotification();
		listNot.add(not);
		int counter = owner.getNotificationcount();
		counter++;
		owner.setNotificationcount(counter);
		owner.setNotification(listNot);

		summonerservice.addSummoners(owner);
		return new Greeting(count + "", message.getId(), dl.isState(), 0, count, 0, id, counter, not.toString());
	}

	@MessageMapping("/content/{id}")
	@SendTo("/topic/content/{id}")
	public Page<Discussion> content(@DestinationVariable String id, GetContent message) throws Exception {

		Page<Discussion> dList;
		Mains main = mainsservice.findMain(message.getMain());
		if (message.getType() == 0) {
			dList = discussionservice.findAllByMain(new PageRequest(0, 10), main);
		} else {
			dList = discussionservice.findAllByMainAndType(new PageRequest(0, 10), main, message.getType());
		}

		return dList;
	}

	@MessageMapping("/resetnotification/{id}")
	@SendTo("/topic/resetnotification/{id}")
	public String resetnotification(@DestinationVariable int id, String message) throws Exception {

		Summoner user = userservice.findById(id).getSummoner();
		user.setNotificationcount(0);
		summonerservice.addSummoners(user);
		return message;
	}

	@MessageMapping("/notification/{id}")
	@SendTo("/topic/notification/{id}")
	public String Notification(@DestinationVariable String id, String message) throws Exception {

		return message;
	}

	@MessageMapping("/alldata/{id}")
	@SendTo("/topic/getall/{id}")
	public List<Item> allItems(@DestinationVariable String id, SearchData message) throws Exception {

		return itemservice.findByNameIgnoreCaseContaining(message.getData());
	}

	@MessageMapping("/getguideitemdata/{id}")
	@SendTo("/topic/getguidedata/{id}")
	public List<Item> allGuideItems(@DestinationVariable String id, SearchData message) throws Exception {

		return itemservice.findByNameIgnoreCaseContaining(message.getData());
	}

	@MessageMapping("/getguidechampiondata/{id}")
	@SendTo("/topic/getguidedata/{id}")
	public List<LeagueChampion> allGuidesChampions(@DestinationVariable String id, SearchData message)
			throws Exception {

		return leaguechampionservice.findByNameIgnoreCaseContaining(message.getData());
	}

	@MessageMapping("/getguidechampionabilitydata/{id}")
	@SendTo("/topic/getguidedata/{id}")
	public List<ChampionSpells> getguidechampionabilitydata(@DestinationVariable String id, SearchData message)
			throws Exception {

		LeagueChampion lc = leaguechampionservice.findLeagueChampion(Integer.parseInt(message.getData()));
		return lc.getSpells();
	}

	@MessageMapping("/getguiderunesdata/{id}")
	@SendTo("/topic/getguidedata/{id}")
	public List<LeagueRunes> allGuideRunes(@DestinationVariable String id, SearchData message) throws Exception {

		return leaguerunesservice.findByNameIgnoreCaseContaining(message.getData());
	}

	@MessageMapping("/getguidesummonersdata/{id}")
	@SendTo("/topic/getguidedata/{id}")
	public List<LeagueSummoners> allGuidesummoners(@DestinationVariable String id, SearchData message)
			throws Exception {

		return leaguesummonersservice.findByNameIgnoreCaseContaining(message.getData());
	}

	@MessageMapping("/getrunesdata/{id}")
	@SendTo("/topic/getall/{id}")
	public List<LeagueRunes> getrunesdata(@DestinationVariable String id, SearchData message) throws Exception {

		return leaguerunesservice.findByNameIgnoreCaseContaining(message.getData());
	}

	@MessageMapping("/getsummonersdata/{id}")
	@SendTo("/topic/getall/{id}")
	public List<LeagueSummoners> getsummonersdata(@DestinationVariable String id, SearchData message) throws Exception {

		return leaguesummonersservice.findByNameIgnoreCaseContaining(message.getData());
	}

	@MessageMapping("/getchampiondata/{id}")
	@SendTo("/topic/getall/{id}")
	public List<LeagueChampion> allChampions(@DestinationVariable String id, SearchData message) throws Exception {

		return leaguechampionservice.findByNameIgnoreCaseContaining(message.getData());
	}

	@MessageMapping("/loadmore/{id}")
	@SendTo("/topic/loadmore/{id}")
	public Page<Discussion> loadMore(@DestinationVariable String id, SearchData message) throws Exception {

		return discussionservice.findAll(new PageRequest(Integer.parseInt(message.getData()), 5));
	}

	@MessageMapping("/gettooltipitemdata/{id}")
	@SendTo("/topic/gettooltipdata/{id}")
	public ItemPojo gettooltipitemdata(@DestinationVariable String id, SearchData message) throws Exception {

		Item item = itemservice.findByItemId(Integer.parseInt(message.getData()));
		JSONObject itemObject = new JSONObject(item);

		ItemPojo itemData = new ItemPojo();
		itemData.setItemid(itemObject.getInt("itemId"));
		itemData.setGold(itemObject.getInt("gold"));
		itemData.setType(itemObject.getInt("type"));
		itemData.setImage(itemObject.getString("imageId"));
		itemData.setName(itemObject.getString("name"));
		itemData.setDescription(itemObject.getString("description"));
		List<Stats> stats = new ArrayList<Stats>();
		String[] itemlists = itemObject.getNames(itemObject);
		for (int j = 0; j < itemlists.length; j++) {
			try {
				Double value = itemObject.getDouble(itemlists[j]);
				if (value != 0) {
					if (!itemlists[j].contains("id") && !itemlists[j].contains("itemId")
							&& !itemlists[j].contains("gold")) {
						stats.add(new Stats(itemlists[j], value));
					}

				}
			} catch (Exception e) {

			}

		}

		itemData.setStats(stats);

		return itemData;
	}

	@MessageMapping("/gettooltiprunedata/{id}")
	@SendTo("/topic/gettooltipdata/{id}")
	public LeagueRunes gettooltiprunedata(@DestinationVariable String id, SearchData message) throws Exception {

		return leaguerunesservice.findByRuneid(Integer.parseInt(message.getData()));
	}

	@MessageMapping("/gettooltipuserdata/{id}")
	@SendTo("/topic/gettooltipdata/{id}")
	public User gettooltipuserdata(@DestinationVariable String id, SearchData message) throws Exception {

		return userservice.findById(Integer.parseInt(message.getData()));
	}

	@MessageMapping("/gettooltipchampiondata/{id}")
	@SendTo("/topic/gettooltipdata/{id}")
	public LeagueChampion gettooltipchampiondata(@DestinationVariable String id, SearchData message) throws Exception {

		return leaguechampionservice.findByChampionid(Long.parseLong(message.getData()));
	}

	@MessageMapping("/gettooltispelldata/{id}")
	@SendTo("/topic/gettooltipdata/{id}")
	public ChampionSpells gettooltispelldata(@DestinationVariable String id, SearchData message) throws Exception {

		return spellservice.findChampionSpells(Integer.parseInt(message.getData()));
	}

	@MessageMapping("/gettooltipsummonerdata/{id}")
	@SendTo("/topic/gettooltipdata/{id}")
	public LeagueSummoners gettooltipsummonerdata(@DestinationVariable String id, SearchData message) throws Exception {

		return leaguesummonersservice.findBySummonersid(Integer.parseInt(message.getData()));
	}
}
