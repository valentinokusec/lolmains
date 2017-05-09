package com.lolmains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Summoner;
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;
import com.lolmains.repository.VideoLikesDao;



@Service
public class VideoLikesServiceImpl implements VideoLikesService {
	

	@Autowired
	VideoLikesDao videolikesdao;

	@Override
	public List<VideoLikes> findTop1ByUserNameAndVideoId(String username, int videoid) {
		// TODO Auto-generated method stub
		return videolikesdao.findTop1ByUserNameAndVideoId(username,videoid);
	}

	@Override
	public VideoLikes createVideoLikes(VideoLikes video) {
		// TODO Auto-generated method stub
		return videolikesdao.save(video);
	}

	@Override
	public VideoLikes findByUserAndVideo(Summoner user, Video video) {
		// TODO Auto-generated method stub
		return videolikesdao.findByUserAndVideo(user, video);
	}



	


	


	
}
