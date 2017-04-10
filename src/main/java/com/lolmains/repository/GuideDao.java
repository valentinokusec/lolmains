package com.lolmains.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Guide;




public interface GuideDao extends  JpaRepository< Guide ,Integer>{
	
	public Guide findByName(String name);

}
