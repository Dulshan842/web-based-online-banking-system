package com.banksystem.banksystem.Service;

import com.banksystem.banksystem.Entity.Rating;
import com.banksystem.banksystem.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepo;

    public void saveRating(Rating rating) {
        ratingRepo.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    public Rating getRatingById(int id) {
        return ratingRepo.findById(id).orElse(null);
    }

    public void deleteRating(int id) {
        ratingRepo.deleteById(id);
    }
}
