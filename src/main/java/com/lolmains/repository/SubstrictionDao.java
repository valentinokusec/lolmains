package com.lolmains.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.Subsctriction;
import com.lolmains.domains.User;
import com.lolmains.domains.Discussion;



public interface SubstrictionDao extends  JpaRepository< Subsctriction ,Integer>{

	Page<Subsctriction> findAllByMain(Pageable pageable,Mains main);

}
