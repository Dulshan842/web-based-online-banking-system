package com.banksystem.banksystem.Repository;

import com.banksystem.banksystem.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
