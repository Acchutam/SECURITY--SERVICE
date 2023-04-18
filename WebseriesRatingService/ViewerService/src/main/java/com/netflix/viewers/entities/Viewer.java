package com.netflix.viewers.entities;

import java.util.ArrayList;
import java.util.List;



import com.netflix.viewers.models.Rating;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name="viewers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Viewer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VIEWERID")
	private int viewerId;
	@Column(name="NAME",length=15)
	private String name;
	@Column(name="EMAIL")
	private String email;
	@Column(name="ABOUT")
	private String about;
	@Column(name="GENDER")
	private String gender;
	@Column(name="AGE")
	private int age;
	@Transient
	private List<Rating> ratings=new ArrayList<>();
}
