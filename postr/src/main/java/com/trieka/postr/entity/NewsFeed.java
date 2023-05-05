package com.trieka.postr.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "newsfeed")
@Data
public class NewsFeed {
	
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private String feedId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "is_main_feed")
	private boolean isMainFeed;
	
	@Column(name = "replied_for")
	private String repliedFor;
	
	@Column(name = "created_tm")
	private Date createdTm;
	
	@Column(name = "updated_tm")
	private Date updatedTm;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;

}
