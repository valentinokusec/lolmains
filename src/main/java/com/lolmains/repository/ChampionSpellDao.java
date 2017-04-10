package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Build;
import com.lolmains.domains.ChampionSpells;
import com.lolmains.domains.Guide;




public interface ChampionSpellDao extends  JpaRepository< ChampionSpells ,Integer>{

	
	public List<ChampionSpells> findByNameIgnoreCaseContaining(String name);
}
