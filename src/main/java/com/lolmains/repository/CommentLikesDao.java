package com.lolmains.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.domains.Comment;
import com.lolmains.domains.CommentLikes;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.DiscussionLikes;
import com.lolmains.domains.Item;



public interface CommentLikesDao extends  JpaRepository< CommentLikes ,Integer>{
	CommentLikes findByUserAndComment(User user, Comment comment);

}
