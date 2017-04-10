package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;



@Service
public interface VideoLikesService {
	public List<VideoLikes> findTop1ByUserNameAndVideoId(String username, int videoid);
	public VideoLikes createVideoLikes(VideoLikes video);
	
} 
