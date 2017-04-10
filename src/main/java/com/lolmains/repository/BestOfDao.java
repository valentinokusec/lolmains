package com.lolmains.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;




public interface BestOfDao extends  JpaRepository< BestOf ,Integer>{

}
