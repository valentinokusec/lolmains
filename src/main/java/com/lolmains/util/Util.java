package com.lolmains.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.lolmains.domains.Comment;
import com.lolmains.domains.CommentLikes;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Mains;
import com.lolmains.repository.CommentLikesDao;
import com.lolmains.services.CommentService;
import com.lolmains.services.DiscussionService;

public class Util {

	@Autowired
	DiscussionService discussionservice;
	
	@Autowired
	CommentService commentservice;
	
	@Autowired
	CommentLikesDao commentlikesdao;
	
	public static ArrayList<Discussion> sortDiscussions(Page<Discussion> list) {
		// TODO Auto-generated method stub
		ArrayList<Discussion> data=new ArrayList<Discussion>();
		JSONArray sortedJsonArray = new JSONArray();
		for (Discussion discussion:list) {
			Long time=discussion.getDate().getTime();
			Timestamp ctime= new Timestamp(System.currentTimeMillis());
			Long difTime=ctime.getTime() - time;
			double timeScore=((1000000000l-difTime)/100000)*2.5;
			
			int score=discussion.getVotes()*1000+(int)timeScore;
			System.out.println(score);
			JSONObject jo=new JSONObject();
			jo.put("score", score);
			jo.put("object", discussion);
			sortedJsonArray.put(jo);
		}
		
		JSONArray rlysortedJsonArray= getSortedList(sortedJsonArray);
		for (int i=0; i<rlysortedJsonArray.length();i++) {
			data.add((Discussion) rlysortedJsonArray.getJSONObject(i).get("object"));
		}
		
		return data;
	}
	private static JSONArray getSortedList(JSONArray allChampionList) {
		JSONArray sortedJsonArray = new JSONArray();
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		for (int i = 0; i < allChampionList.length(); i++) {
			jsonList.add(allChampionList.getJSONObject(i));
		}
		Collections.sort(jsonList, new Comparator<JSONObject>() {

			public int compare(JSONObject a, JSONObject b) {
				Integer valA = 0;
				Integer valB = 0;

				try {
					valA = (Integer) a.get("score");
					valB = (Integer) b.get("score");
				} catch (JSONException e) {
					// do something
				}

				return valA.compareTo(valB);
			}
		});
		for (int i = 0; i < allChampionList.length(); i++) {
			sortedJsonArray.put(jsonList.get(i));
		}
	
	

		return sortedJsonArray;
	}
	public static  JSONArray GetExtraData(Mains main) {
		// TODO Auto-generated method stub
//		Page<Discussion> list=discussionservice.findAll(new PageRequest(0, 5));
//		
//		JSONArray extraData=new JSONArray();
//		for(Discussion dis:list)
//		{
//			String time="";
//			JSONObject data=new JSONObject();
//			int count=commentservice.countIdfindByDiscussionId(dis.getId());
//			Timestamp date=dis.getDate();
//			int day=date.getDate();
//			int hour=date.getHours();
//			int minute=date.getMinutes();
//			Timestamp cData=new Timestamp(System.currentTimeMillis());
//			if(day-cData.getDate()==1)
//			{
//				time="1 day ago";
//			}
//			else if(day-cData.getDate()==0)
//			{
//				if (hour-cData.getHours()==0) {
//					
//		
//					time=cData.getMinutes()-minute+" minutes ago";
//				
//			
//				}
//				else if(hour-cData.getHours()==1)
//				{
//					if(cData.getMinutes()<minute)
//					{
//						time=minute+cData.getMinutes()+60+" minutes ago";
//					}
//					else
//					{
//						time=minute+cData.getMinutes()+" minutes ago";
//					}
//				}
//			}
//			else
//			{
//				time=cData.getDate()-day+" days ago";
//			}
//			data.put("id", dis.getId());
//			data.put("time", time);
//			data.put("count", count);
//			extraData.put(data);
//		}
		return null;
	}
	public static List<Comment> sortComments(List<Comment> comList) {
		// TODO Auto-generated method stub
		List<Comment> data=new ArrayList<Comment>();
		JSONArray sortedJsonArray = new JSONArray();
		for (Comment comment:comList) {
			if (comment.getComment().size()!=0) {
				sortComments(comment.getComment());
			}
			
			Long time=comment.getDate().getTime();
			Timestamp ctime= new Timestamp(System.currentTimeMillis());
			Long difTime=ctime.getTime() - time;
			double timeScore=((1000000000l-difTime)/100000)*2.5;
			
			int score=comment.getVotes()*1000+(int)timeScore;
			System.out.println(score);
			JSONObject jo=new JSONObject();
			jo.put("score", score);
			jo.put("object", comment);
			
			sortedJsonArray.put(jo);
		}
		
		JSONArray rlysortedJsonArray= getSortedList(sortedJsonArray);
		for (int i=0; i<rlysortedJsonArray.length();i++) {
			data.add((Comment) rlysortedJsonArray.getJSONObject(i).get("object"));
		}
		
		return data;
	}
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	
}
