package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Item;



public interface ItemDao extends  JpaRepository< Item ,Integer>{
	List<Item> findByNameIgnoreCaseContaining(String name);
	Item findByItemId(int id);
}
