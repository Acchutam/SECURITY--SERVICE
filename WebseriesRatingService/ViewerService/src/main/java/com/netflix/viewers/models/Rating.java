package com.netflix.viewers.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
	private int ratingId;
	private int userId;
	private int webSeriesId;
	private int rating;
	private String feedback;
	private Series series;
}
