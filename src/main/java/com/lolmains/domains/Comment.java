package com.lolmains.domains;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="commentid")
	private int commentid;
	@Column(name="discussionid")
	private int discussionId;
	@Column(name="content")
	private String content;
	@JoinColumn(name = "user")
	  @ManyToOne
	  @OneToMany(fetch = FetchType.EAGER)
	private Summoner user;
	@Column(name="reply")
	private boolean reply;
	@Column(name="date")
	private Timestamp date;
	@Column(name="votes")
	private int votes;

	@JoinColumn(name = "comment")
    @OneToMany(fetch = FetchType.EAGER)
	private List<Comment> comment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getDiscussionId() {
		return discussionId;
	}
	public void setDiscussionId(int discussionid) {
		this.discussionId = discussionid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Summoner getUser() {
		return user;
	}
	public void setUser(Summoner user) {
		this.user = user;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp timestamp) {
		this.date = timestamp;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	
	public boolean getReply() {
		return reply;
	}
	public void setReply(boolean reply) {
		this.reply = reply;
	}
	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"commentid\":" + commentid + ", \"discussionId\":" + discussionId + ", \"votes\":" + votes +", \"content\":\""
				+ content.replace("\"", "'") + "\", \"user\":" + user.toString() + ",\"reply\":" + reply + ", \"date\":" + date.getSeconds() + ", \"comment\":" + comment.toString() + "}";
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}

	
	

	
}
