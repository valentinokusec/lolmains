package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Link;



public interface LinkDao extends  JpaRepository< Link ,Integer>{
}
