package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Item;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueMasteries;



public interface LeagueMasteriesDao extends  JpaRepository< LeagueMasteries ,Integer>{
	public List<LeagueMasteries> findByNameIgnoreCaseContaining(String string);
	
}
