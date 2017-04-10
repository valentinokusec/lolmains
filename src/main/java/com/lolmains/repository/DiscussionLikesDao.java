package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Item;



public interface DiscussionLikesDao extends  JpaRepository< DiscussionLikes ,Integer>{
	DiscussionLikes findByUserAndDiscussion(User user, Discussion discussion);
	List<DiscussionLikes> findByDiscussion( Discussion discussion);
	
}
