package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Item;
import com.lolmains.domains.LinkGroup;
import com.lolmains.domains.MailingList;



public interface MailingListDao extends  JpaRepository< MailingList ,Integer>{
	public List<MailingList> findByMain(Mains main);
}
