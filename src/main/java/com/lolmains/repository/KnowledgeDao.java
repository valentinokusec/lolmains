package com.lolmains.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Knowledge;



public interface KnowledgeDao extends  JpaRepository< Knowledge ,Integer>{
	Page<Knowledge> findAllByMain(Pageable pageable,Mains main);
	Page<Knowledge> findAllByMainAndType(Pageable pageable,Mains main, int type);
	public Knowledge findAllByMainAndTypeAndHeader(Mains main, int i , String header);
	public List<Knowledge> findAllByMainAndType(Mains main, int i );
	public int countByMainAndType(Mains main, int i );
}
