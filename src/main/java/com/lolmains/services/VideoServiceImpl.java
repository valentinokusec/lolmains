package com.lolmains.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.exception.ConstraintViolationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.Video;
import com.lolmains.domains.Discussion;
import com.lolmains.repository.DiscussionDao;
import com.lolmains.repository.VideoDao;



@Service
public class VideoServiceImpl implements VideoService {
	

	@Autowired
	VideoDao videodao;

	@Override
	public List<com.lolmains.domains.Video> getAllVideo() {
		// TODO Auto-generated method stub
		return videodao.findAll();
	}

	@Override
	public com.lolmains.domains.Video createVideo(com.lolmains.domains.Video video) {
		// TODO Auto-generated method stub
		return videodao.save(video);
	}

	@Override
	public com.lolmains.domains.Video findVideo(int id) {
		// TODO Auto-generated method stub
		return videodao.findOne(id);
	}

	@Override
	public Page<Video> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return videodao.findAll(pageable);
	}

	@Override
	public List<Video> findTop1ByOrderByLikesDesc() {
		// TODO Auto-generated method stub
		return videodao.findTop1ByOrderByLikesDesc();
	}

	@Override
	public Page<Video> findByUser(Pageable pageable, Summoner user) {
		// TODO Auto-generated method stub
		return videodao.findByUser(pageable, user);
	}

	@Override
	public List<Video> findTop1ByOrderByLikesDescByMain(Mains main) {
		// TODO Auto-generated method stub
		return videodao.findTop1ByOrderByLikesDesc(main);
	}

	@Override
	public Page<Video> findAllByMain(Pageable pageable, Mains main) {
		// TODO Auto-generated method stub
		return videodao.findAllByMain(pageable, main);
	}

	@Override
	public int countByMain(Mains main) {
		// TODO Auto-generated method stub
		return videodao.countByMain(main);
	}

	@Override
	public List<Video> findAllByMainOrderByLikesDesc(Mains main) {
		// TODO Auto-generated method stub
		return videodao.findAllByMainOrderByLikesDesc(main);
	}

	@Override
	public List<Video> findTop1ByOrderByFeatured(boolean feat) {
		// TODO Auto-generated method stub
		return videodao.findTop1ByOrderByFeatured( feat);
	}

	




	


	
}
