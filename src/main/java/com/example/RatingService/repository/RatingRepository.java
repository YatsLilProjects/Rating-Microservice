package com.example.RatingService.repository;

import com.example.RatingService.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {


 /*   @Query("select r from Rating r where r.customerId=:customerId")
    List<Rating> findRatingsByCustomerId(@Param("customerId") int customerId);*/

    List<Rating> findByCustomerId(int customerId);


}
