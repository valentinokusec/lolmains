package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Item;
import com.lolmains.domains.LeagueChampion;
import com.lolmains.domains.LeagueRunes;



public interface LeagueRunesDao extends  JpaRepository< LeagueRunes ,Integer>{
	public List<LeagueRunes> findByNameIgnoreCaseContaining(String string);
	public LeagueRunes findByRuneid(int id);
}
