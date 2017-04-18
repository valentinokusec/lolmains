package com.lolmains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Mains;
import com.lolmains.domains.Subsctriction;
import com.lolmains.repository.DiscussionDao;
import com.lolmains.repository.SubstrictionDao;



@Service
public class SubstrictionServiceImpl implements SubstrictionService {
	

	@Autowired
	SubstrictionDao SubstrictionDao;

	@Override
	public List<Subsctriction> getAllSubsctrictions() {
		// TODO Auto-generated method stub
		return SubstrictionDao.findAll();
	}

	@Override
	public Subsctriction addSubsctriction(Subsctriction Subsctriction) {
		// TODO Auto-generated method stub
		return SubstrictionDao.save(Subsctriction);
	}

	@Override
	public void removeSubsctriction(Subsctriction Subsctriction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Subsctriction findSubsctriction(int id) {
		// TODO Auto-generated method stub
		return SubstrictionDao.findOne(id);
	}

	@Override
	public Page<Subsctriction> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return SubstrictionDao.findAll(pageable);
	}

	@Override
	public Page<Subsctriction> findAllByMain(Pageable pageable, Mains main) {
		// TODO Auto-generated method stub
		return SubstrictionDao.findAllByMain(pageable, main);
	}

	


	
}
