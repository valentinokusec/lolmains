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
import com.lolmains.domains.Video;
import com.lolmains.domains.VideoLikes;
import com.lolmains.domains.Discussion;
import com.lolmains.repository.DiscussionDao;
import com.lolmains.repository.VideoDao;
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



	


	


	
}
