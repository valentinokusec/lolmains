package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Item;
import com.lolmains.domains.LinkGroup;



public interface LinkGroupDao extends  JpaRepository< LinkGroup ,Integer>{
	public List<LinkGroup> findByMain(Mains main);
}
