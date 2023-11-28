package com.example.RatingService.service;

import com.example.RatingService.dto.Response;
import com.example.RatingService.model.Rating;

import java.util.List;

public interface RatingService {

    Response addRating(Rating rating);

    List<Rating> findRatingsByCustomerId(int customerId);


}
