package com.lolmains.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Masteries;




public interface MasteriesDao extends  JpaRepository< Masteries ,Integer>{

}
