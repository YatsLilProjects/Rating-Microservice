package com.example.RatingService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {

    public Rating(Integer customerId, Integer restaurantId, int rating, String feedback) {
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.feedback = feedback;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "rating_generator")
    @SequenceGenerator(
            name = "rating_generator",
            sequenceName = "rating_sequence_name",
            allocationSize = 1
    )
    @Column(name = "rating_id")
    private Integer ratingId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "feedback")
    private String feedback;


}
