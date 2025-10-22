package com.banksystem.banksystem.Controller;

import com.banksystem.banksystem.Entity.Rating;
import com.banksystem.banksystem.Service.RatingService;
import com.banksystem.banksystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/new")
    public String showRatingForm(Model model) {
        Rating rating = new Rating();
        rating.setStars(0);
        rating.setComment("");
        rating.setName("");
        model.addAttribute("rating", rating);
        return "create-rating";
    }

    @PostMapping("/submit")
    public String submitRating(@ModelAttribute Rating rating) {
        try {
            if (rating == null || rating.getName() == null || rating.getName().isBlank()) {
                throw new IllegalArgumentException("Name is required.");
            }
            ratingService.saveRating(rating);
        } catch (Exception e) {
            return "redirect:/error";
        }
        return "redirect:/ratings/view";
    }

    @GetMapping("/view")
    public String viewRatings(Model model) {
        model.addAttribute("ratings", ratingService.getAllRatings());
        return "view-ratings";
    }

    @GetMapping("/edit/{id}")
    public String editRating(@PathVariable int id, Model model) {
        Rating rating = ratingService.getRatingById(id);
        if (rating == null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("rating", rating);
        return "create-rating";
    }

    @PostMapping("/delete/{id}")
    public String deleteRating(@PathVariable int id) {
        try {
            ratingService.deleteRating(id);
        } catch (Exception e) {
            return "redirect:/error";
        }
        return "redirect:/ratings/view";
    }
}


