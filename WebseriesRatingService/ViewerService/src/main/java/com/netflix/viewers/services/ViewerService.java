package com.netflix.viewers.services;

import java.util.List;

import com.netflix.viewers.entities.Viewer;


public interface ViewerService {

	Viewer saveViewer(Viewer viewer);
	List<Viewer> getAllViewers();
	Viewer getViewer(int viewerId);
	
	void deleteViewer(int viewerId);
}
