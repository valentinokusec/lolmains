package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Runes;
import com.lolmains.domains.Summoners;




public interface RunesDao extends  JpaRepository< Runes ,Integer>{

}
