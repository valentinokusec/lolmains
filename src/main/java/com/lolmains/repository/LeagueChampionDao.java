package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Item;
import com.lolmains.domains.LeagueChampion;

public interface LeagueChampionDao extends  JpaRepository< LeagueChampion ,Integer>{
	public List<LeagueChampion> findByNameIgnoreCaseContaining(String string);
	public LeagueChampion findByChampionid(Long id);
	public LeagueChampion findByName(String id);
}
