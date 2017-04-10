package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.LeagueRunes;
import com.lolmains.domains.LeagueSummoners;
import com.lolmains.domains.Summoners;


public interface LeagueSummonersDao extends  JpaRepository< LeagueSummoners ,Integer>{
	public List<LeagueSummoners> findByNameIgnoreCaseContaining(String string);
	public LeagueSummoners findBySummonersid(long param7);
}
