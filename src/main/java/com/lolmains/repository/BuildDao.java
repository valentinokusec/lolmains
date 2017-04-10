package com.lolmains.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;




public interface BuildDao extends  JpaRepository< Build ,Integer>{

}
