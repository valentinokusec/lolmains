package com.lolmains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Discussion;
import com.lolmains.domains.Mains;
import com.lolmains.repository.DiscussionDao;



@Service
public class DiscussionServiceImpl implements DiscussionService {
	

	@Autowired
	DiscussionDao topicdao;

	@Override
	public List<Discussion> getAllTopics() {
		// TODO Auto-generated method stub
		return topicdao.findAll();
	}

	@Override
	public Discussion addTopic(Discussion topic) {
		// TODO Auto-generated method stub
		return topicdao.save(topic);
	}

	@Override
	public Discussion findTopic(int id) {
		// TODO Auto-generated method stub
		return topicdao.findOne(id);
	}

	@Override
	public Page<Discussion> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return topicdao.findAll(pageable);
	}

	@Override
	public Page<Discussion> findAllByMain(Pageable pageable, Mains main) {
		// TODO Auto-generated method stub
		return topicdao.findAllByMain(pageable, main);
	}

	@Override
	public Page<Discussion> findAllByMainAndType(Pageable pageable, Mains main, int type) {
		// TODO Auto-generated method stub
		return topicdao.findAllByMainAndType(pageable, main, type);
	}

	@Override
	public void removeTopic(Discussion topic) {
		// TODO Auto-generated method stub
		topicdao.delete(topic);
	}

	@Override
	public Page<Discussion> findAllByMainAndSticky(Pageable pageable, Mains main, boolean sticky) {
		// TODO Auto-generated method stub
		return topicdao.findAllByMainAndSticky(pageable, main, sticky);
	}

	@Override
	public Page<Discussion> findAllByMainAndTypeAndSticky(Pageable pageable, Mains main, int type, boolean sticky) {
		// TODO Auto-generated method stub
		return topicdao.findAllByMainAndTypeAndSticky(pageable, main, type, sticky);
	}
	


	
}
