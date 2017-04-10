package com.lolmains.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;
import com.lolmains.domains.Discussion;



public interface VideoLikesDao extends  JpaRepository< VideoLikes ,Integer>{

	
	public List<VideoLikes> findTop1ByUserNameAndVideoId(String username, int videoid);
	
}
