package com.lolmains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.repository.BestOfDao;



@Service
public class BestOfServiceImpl implements BestOfService {
	

	@Autowired
	BestOfDao bestofdao;


	@Override
	public List<BestOf> getAll() {
		// TODO Auto-generated method stub
		return bestofdao.findAll();
	}

	@Override
	public BestOf addBestOf(BestOf BestOf) {
		// TODO Auto-generated method stub
		return bestofdao.save(BestOf);
	}

	@Override
	public BestOf findBestOf(int id) {
		// TODO Auto-generated method stub
		return bestofdao.findOne(id);
	}


	


	


	
}
