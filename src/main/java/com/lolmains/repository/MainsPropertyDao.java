package com.lolmains.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.MainsProperties;




public interface MainsPropertyDao extends  JpaRepository< MainsProperties ,Integer>{

}
