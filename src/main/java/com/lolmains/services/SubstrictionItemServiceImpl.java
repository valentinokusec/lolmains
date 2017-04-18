package com.lolmains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Mains;
import com.lolmains.domains.SubsctrictionItem;




@Service
public class SubstrictionItemServiceImpl implements SubstrictinItemService {
	

	@Autowired
	com.lolmains.repository.SubstrictionItemDao SubstrictionItemDao;

	@Override
	public List<SubsctrictionItem> getAllSubsctrictionItems() {
		// TODO Auto-generated method stub
		return SubstrictionItemDao.findAll();
	}

	@Override
	public SubsctrictionItem addSubsctrictionItem(SubsctrictionItem SubsctrictionItem) {
		// TODO Auto-generated method stub
		return SubstrictionItemDao.save(SubsctrictionItem);
	}

	@Override
	public void removeSubsctrictionItem(SubsctrictionItem SubsctrictionItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SubsctrictionItem findSubsctrictionItem(int id) {
		// TODO Auto-generated method stub
		return SubstrictionItemDao.findOne(id);
	}




	
	


	
}
