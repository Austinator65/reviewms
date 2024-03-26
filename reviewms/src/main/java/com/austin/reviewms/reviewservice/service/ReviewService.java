package com.austin.reviewms.reviewservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.austin.reviewms.reviewservice.model.Review;

@Service
public interface ReviewService {
   List<Review> getAllReviewsByCompanyId(Long companyId);
   Review getReviewById(Long id);
   boolean updateReviewById(Long id, Review review);
   boolean createReview(Long companyId, Review review);
   boolean deleteReviewById(Long id);
}
