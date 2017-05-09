package com.lolmains.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lolmains.domains.Summoner;
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;



@Service
public interface VideoLikesService {
	public List<VideoLikes> findTop1ByUserNameAndVideoId(String username, int videoid);
	public VideoLikes createVideoLikes(VideoLikes video);
	VideoLikes findByUserAndVideo(Summoner user, Video video);
	
} 
