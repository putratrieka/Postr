package com.trieka.postr.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsFeedRepository extends JpaRepository<NewsFeed, String>{
	
	public List<NewsFeed> findByIsMainFeedAndIsDeleted(boolean isMainFeed, boolean isDeleted);
	
	public List<NewsFeed> findByRepliedFor(String feedReference);

}
