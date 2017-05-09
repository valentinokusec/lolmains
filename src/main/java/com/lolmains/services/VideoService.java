package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.Video;



@Service
public interface VideoService {
	public List<Video> getAllVideo();
	public Video createVideo(Video video);
	public Video findVideo(int id);
	public Page<Video> findAll(Pageable pageable);
	public List<Video> findTop1ByOrderByLikesDesc();
	public Page<Video> findByUser(Pageable pageable,Summoner user);
	public List<Video> findTop1ByOrderByLikesDescByMain(Mains main);
	public Page<Video> findAllByMain(Pageable pageable,  Mains main);
	public int countByMain(Mains main);
	public List<Video> findAllByMainOrderByLikesDesc(Mains main);
	public List<Video> findTop1ByOrderByFeatured(boolean feat);
} 
