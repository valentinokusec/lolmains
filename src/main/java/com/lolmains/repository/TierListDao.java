package com.lolmains.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.TierList;
import com.lolmains.domains.User;
import com.lolmains.domains.Discussion;



public interface TierListDao extends  JpaRepository< TierList ,Integer>{
	TierList findAllByMain(Mains main);
	
}
