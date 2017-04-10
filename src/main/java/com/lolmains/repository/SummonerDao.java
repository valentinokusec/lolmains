package com.lolmains.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.Summoner;



public interface SummonerDao extends  JpaRepository< Summoner ,Integer>{
	public Summoner findByName(String name);
	public Summoner findByMain(Mains main);
	public Page<Summoner> findByMain(Pageable page, Mains main);
	public int countByMain(Mains main);

}
