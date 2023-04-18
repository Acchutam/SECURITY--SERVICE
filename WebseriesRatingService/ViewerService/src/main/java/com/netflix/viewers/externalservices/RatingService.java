package com.netflix.viewers.externalservices;

import com.netflix.viewers.models.Rating;
import com.netflix.viewers.models.Series;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @GetMapping(value="/rating/users/{usersid}")
    ResponseEntity<List<Rating>>getRatingsByUserId(@PathVariable int usersid);
}
