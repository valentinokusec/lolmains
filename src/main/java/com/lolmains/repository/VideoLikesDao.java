package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Summoner;
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;



public interface VideoLikesDao extends  JpaRepository< VideoLikes ,Integer>{

	
	public List<VideoLikes> findTop1ByUserNameAndVideoId(String username, int videoid);
	VideoLikes findByUserAndVideo(Summoner user, Video video);
	
}
