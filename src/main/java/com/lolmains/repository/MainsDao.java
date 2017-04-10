package com.lolmains.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Guide;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoner;



public interface MainsDao extends  JpaRepository< Mains ,Integer>{
	public Mains findByName(String name);	
	public Page<Summoner> findBySummoner(Pageable pageable);
	public Page<Guide> findByGuide(Pageable pageable);
 
}
