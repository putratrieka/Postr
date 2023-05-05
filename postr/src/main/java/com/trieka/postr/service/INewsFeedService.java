package com.trieka.postr.service;

import java.util.List;

import javax.validation.Valid;

import com.trieka.postr.dto.FeedRequestDTO;
import com.trieka.postr.entity.NewsFeed;

public interface INewsFeedService {
	
	public List<NewsFeed> findAllFeed();

	public NewsFeed postNewFeed(@Valid FeedRequestDTO request);

	public NewsFeed replyFeed(FeedRequestDTO request, String feedId);

	public List<NewsFeed> getReplies(String referenceFeedId);

}
 