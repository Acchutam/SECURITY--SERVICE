package com.netflix.viewers.controllers;

import java.util.List;

import com.netflix.viewers.externalservices.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.viewers.entities.Viewer;
import com.netflix.viewers.services.ViewerService;


@RestController
@RequestMapping("/viewers")
public class ViewerController {

	@Autowired
	private ViewerService viewerService;
	@Autowired
	private SeriesService seriesService;
	@PostMapping
	public ResponseEntity<Viewer> createViewer(@RequestBody Viewer viewer)
	{
		Viewer user1=viewerService.saveViewer(viewer);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	@GetMapping("/{viewerId}")
	public ResponseEntity<Viewer> getSingleViewer(@PathVariable int viewerId)
	{
		Viewer user=viewerService.getViewer(viewerId);
		return ResponseEntity.ok(user);
	}
	@DeleteMapping("/{viewerId}")
	public void deleteViewer(@PathVariable int viewerId)
	{
		viewerService.deleteViewer(viewerId);
	}
	@GetMapping
	public ResponseEntity<List<Viewer>> getAllViewers()
	{
		List<Viewer> allUser=viewerService.getAllViewers();
		return ResponseEntity.ok(allUser);
	}
	@GetMapping("/allseries")
	public  ResponseEntity<List<?>> getALLSeries()
	{
		return  seriesService.getAllSeries();
	}
}
