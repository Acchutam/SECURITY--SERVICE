package com.netflix.viewers.externalservices;

import com.netflix.viewers.models.Series;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name="SERIES-SERVICE")
public interface SeriesService {
    @GetMapping(value="api/series/{id}")
    ResponseEntity<Series> getById(@PathVariable int id);

    @GetMapping(value = "api/series")
    ResponseEntity<List<?>> getAllSeries();
}
