package com.netflix.viewers.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.netflix.viewers.externalservices.RatingService;
import com.netflix.viewers.externalservices.SeriesService;
import com.netflix.viewers.models.Rating;
import com.netflix.viewers.models.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.viewers.entities.Viewer;
import com.netflix.viewers.exceptions.ResourceNotFoundException;
import com.netflix.viewers.repositories.ViewerRepository;
@Service
public class ViewerServiceImpl implements ViewerService {
	@Autowired
	private ViewerRepository viewerRepository;
	@Autowired
	private SeriesService seriesService;
	@Autowired
	private RatingService ratingService;
	@Override
	public Viewer saveViewer(Viewer viewer) {
		// TODO Auto-generated method stub
	
		return viewerRepository.save(viewer);
	}

	@Override
	public List<Viewer> getAllViewers() {
		// TODO Auto-generated method stub
		return viewerRepository.findAll();
	}

	@Override
	public Viewer getViewer(int viewerId) {
		// TODO Auto-generated method stub
		Viewer  viewer=viewerRepository.findById(viewerId).orElseThrow(()->new ResourceNotFoundException("Viewer with given id is not found on server!!: "+viewerId));
		ResponseEntity<List<Rating>> ratingList=ratingService.getRatingsByUserId(viewerId);
		List<Rating> finalList= ratingList.getBody().stream().map(rating -> {
			Series series= seriesService.getById(rating.getWebSeriesId()).getBody();
			rating.setSeries(series);
			return  rating;



		}).collect(Collectors.toList());
//		List<Rating> alt=ratingList.getBody();
		viewer.setRatings(finalList);
		return  viewer;

	}

	@Override
	public void deleteViewer(int viewerId) {
		// TODO Auto-generated method stub
		viewerRepository.deleteById(viewerId);
	}

}
