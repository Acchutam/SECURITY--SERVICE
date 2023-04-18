package com.netflix.viewers.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Series {
	private int id;
	private String name;
	private String genre;
	private String about;
}
