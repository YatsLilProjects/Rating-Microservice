package com.example.RatingService.serviceimpl;

import com.example.RatingService.dto.Response;
import com.example.RatingService.model.Rating;
import com.example.RatingService.repository.RatingRepository;
import com.example.RatingService.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RatingImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Response addRating(Rating rating) {
        Response response = new Response(false, new ArrayList<>(), null);
        try {
            if (rating != null) {
                Rating newRating = ratingRepository.save(rating);
                response.setSuccess(true);
                response.setResponseData(newRating);
            } else {
                response.getErrMessage().add("Rating Not Inserted");
            }
        } catch (Exception e) {
            response.getErrMessage().add("Rating Not Added");
            log.error("Error in  addRating {}", e);
        }
        return response;
    }

    @Override
    public List<Rating> findRatingsByCustomerId(int customerId) {
        return ratingRepository.findByCustomerId(customerId);
    }
}
