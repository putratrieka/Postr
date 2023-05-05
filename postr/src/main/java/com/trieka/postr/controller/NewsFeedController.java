package com.trieka.postr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trieka.postr.dto.FeedRequestDTO;
import com.trieka.postr.dto.GenericResponseDTO;
import com.trieka.postr.entity.NewsFeed;
import com.trieka.postr.service.INewsFeedService;

@RestController
@RequestMapping("postr")
public class NewsFeedController {

	@Autowired
	private INewsFeedService feedService;

	@GetMapping(value = "/feed")
	public GenericResponseDTO<List<NewsFeed>> ShowFeed() {
		List<NewsFeed> feeds = feedService.findAllFeed();
		GenericResponseDTO<List<NewsFeed>> response = new GenericResponseDTO<>();
		response.setContent(feeds);
		response.setStatus(GenericResponseDTO.SUCCESS);
		return response;
	}

	@PostMapping(value = "/feed")
	public GenericResponseDTO<String> PostNewsFeed(@RequestBody @Valid FeedRequestDTO request) {

		NewsFeed feed = feedService.postNewFeed(request);

		GenericResponseDTO<String> response = new GenericResponseDTO<>();
		if (feed != null && feed.getFeedId() != null) {
			response.setStatus(GenericResponseDTO.SUCCESS);
			response.setContent("OK");
		} else {
			response.setStatus(GenericResponseDTO.FAILED);
		}

		return response;
	}

	@PostMapping(value = "/feed/reply/{id}")
	public GenericResponseDTO<String> ReplyFeed(@PathVariable(required = false, name = "id") String feedId,
			@RequestBody @Valid FeedRequestDTO request) {
		NewsFeed feed = feedService.replyFeed(request, feedId);

		GenericResponseDTO<String> response = new GenericResponseDTO<>();
		if (feed != null && feed.getFeedId() != null) {
			response.setStatus(GenericResponseDTO.SUCCESS);
			response.setContent("OK");
		} else {
			response.setStatus(GenericResponseDTO.FAILED);
		}

		return response;
	}

	@GetMapping(value = "/feed/reply/{referenceFeedId}")
	public GenericResponseDTO<List<NewsFeed>> ShowFeedReplies(
			@PathVariable(required = false, name = "referenceFeedId") String referenceFeedId) {
		List<NewsFeed> replies =  feedService.getReplies(referenceFeedId);
		
		GenericResponseDTO<List<NewsFeed>> response = new GenericResponseDTO<>();
		response.setContent(replies);
		response.setStatus(GenericResponseDTO.SUCCESS);
		return response;
	}

}
