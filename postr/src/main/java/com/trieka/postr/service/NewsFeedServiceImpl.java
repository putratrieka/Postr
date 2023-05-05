package com.trieka.postr.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trieka.postr.dto.FeedRequestDTO;
import com.trieka.postr.entity.NewsFeed;
import com.trieka.postr.entity.NewsFeedRepository;

@Service
public class NewsFeedServiceImpl implements INewsFeedService{
	
	@Autowired
	private NewsFeedRepository feedrepository;

	@Override
	public List<NewsFeed> findAllFeed() {
		return feedrepository.findByIsMainFeedAndIsDeleted(true, false);
	}

	@Override
	public NewsFeed postNewFeed(FeedRequestDTO request) {
		NewsFeed feed = new NewsFeed();
		feed.setUsername(request.getUsername());
		feed.setContent(request.getContent());
		feed.setMainFeed(true);
		feed.setCreatedTm(new Date());
		return feedrepository.save(feed) ;
	}
	
	@Override
	public NewsFeed replyFeed(FeedRequestDTO request, String feedId) {
		
		Optional<NewsFeed> mainFeed = feedrepository.findById(feedId);
		if (mainFeed.isEmpty()) {
			throw new ValidationException("Feed Not Found");
		}
		
		NewsFeed feed = new NewsFeed();
		feed.setUsername(request.getUsername());
		feed.setContent(request.getContent());
		feed.setMainFeed(false);
		feed.setRepliedFor(mainFeed.get().getFeedId());
		feed.setCreatedTm(new Date());
		return feedrepository.save(feed) ;
	}
	
	@Override
	public List<NewsFeed> getReplies(String feedId){
		return feedrepository.findByRepliedFor(feedId);
	}
	

}
