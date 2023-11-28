package com.example.RatingService.controller;

import com.example.RatingService.dto.Response;
import com.example.RatingService.model.Rating;
import com.example.RatingService.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rating-service/food-delivery")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/addRating")
    public ResponseEntity<Response> addRating(@Valid @RequestBody Rating rating) {
        Response response = ratingService.addRating(rating);
        return new ResponseEntity<>(response, response.isSuccess() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ratingsByCustomerId/{customerId}")
    public ResponseEntity<List<Rating>> findRatingsByCustomerId(@PathVariable int customerId) {
        List<Rating> ratings = ratingService.findRatingsByCustomerId(customerId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

}
