package com.netflix.viewers.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.viewers.entities.Viewer;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ViewerRepository extends JpaRepository<Viewer,Integer>
{
	
}
