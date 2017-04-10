package com.lolmains.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Champion;



public interface ChampionDao extends  JpaRepository< Champion ,Integer>{

}
