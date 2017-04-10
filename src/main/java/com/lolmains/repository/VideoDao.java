package com.lolmains.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoner;
import com.lolmains.domains.Video;
import com.lolmains.domains.Discussion;



public interface VideoDao extends  JpaRepository< Video ,Integer>{

	public Page<Video> findAll(Pageable pageable);
	public int countByMain(Mains main);
	public Page<Video> findAllByMain(Pageable pageable, Mains main);
	public Page<Video> findByUser(Pageable pageable,Summoner user);
	public List<Video> findAllByMainOrderByLikesDesc(Mains main);
	public List<Video> findTop1ByOrderByLikesDesc(Mains main);
	public List<Video> findTop1ByOrderByLikesDesc();
	
}
