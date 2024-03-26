package com.austin.reviewms.reviewservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.reviewms.reviewservice.model.Review;
import com.austin.reviewms.reviewservice.repository.ReviewRepository;
import com.austin.reviewms.reviewservice.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

   @Autowired
   ReviewRepository reviewRepository;

  

   @Override
   public List<Review> getAllReviewsByCompanyId(Long companyId) {
      return reviewRepository.findByCompanyId(companyId);
   }

  // @SuppressWarnings("null")
   @Override
   public Review getReviewById( Long id) {
      try {
        Review review = reviewRepository.findById(id).orElse(null);
        return review;
      } catch (Exception e) {
         return null;
      }
      
   }

   @Override
   public boolean updateReviewById(Long id, Review updateReview) {

      Review review = reviewRepository.findById(id).orElse(null);
      
      if(id != null){
          review.setTitle(updateReview.getTitle());
          review.setDescription(updateReview.getDescription());
          review.setRating(updateReview.getRating());
          review.setCompanyId(updateReview.getCompanyId());
          updateReview.setId(id);
          reviewRepository.save(updateReview);
          return true;
      }

      return false;
   }

   //@SuppressWarnings("null")
   @Override
   public boolean createReview(Long companyId, Review review) {

         if (companyId != null && review != null) {
             review.setCompanyId(companyId);
             reviewRepository.save(review);
             return true;
         }
         return false;
      }
      
   


   //@SuppressWarnings("null")
   @Override
   public boolean deleteReviewById(Long id) {

      Review review = reviewRepository.findById(id).orElse(null);

      if(review != null){
         reviewRepository.deleteById(id);
         return true;
      }
         return false;
   }
   
}
