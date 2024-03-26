package com.austin.reviewms.reviewservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.austin.reviewms.reviewservice.model.Review;
import com.austin.reviewms.reviewservice.service.ReviewService;

@RestController
@RequestMapping("/app/reviews")
public class ReviewController {

   @Autowired ReviewService reviewService;



//@SuppressWarnings({ "rawtypes", "unchecked" })
@GetMapping  //return all reviews
public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
      // ResponseEntity(reviewService.getAllReviews(), HttpStatus.OK);
       return new ResponseEntity<>(reviewService.getAllReviewsByCompanyId(companyId), HttpStatus.OK);
};


@GetMapping("/{id}") //return specific ids
public ResponseEntity<Review> getReviewById(@PathVariable Long id){

 return new ResponseEntity<>(reviewService.getReviewById(id), HttpStatus.OK);
};

@PostMapping //add review
 public ResponseEntity<String> createReview(@RequestParam Long companyId, @RequestBody Review review){
   if(reviewService.createReview(companyId, review)){
      return new ResponseEntity<>("Review Succefully created", HttpStatus.CREATED);
   }

   return new ResponseEntity<>("Review not created", HttpStatus.EXPECTATION_FAILED);
 };

 @PutMapping("/{id}") //update review
 public ResponseEntity<String> updateReviewById(@PathVariable Long id, @RequestBody Review review){
 
    if (reviewService.updateReviewById(id, review)) {
       return new ResponseEntity<>("Review Succefully Updated", HttpStatus.FOUND);
    }
 
    return new ResponseEntity<>("Review not updated", HttpStatus.NOT_FOUND);
 };

@DeleteMapping("/{id}") //remove review
public ResponseEntity<String> deleteReviewById(@PathVariable Long id){
   if (reviewService.deleteReviewById(id)) {
      return new ResponseEntity<>("Review Succefully deleted", HttpStatus.FOUND);
   }

   return new ResponseEntity<>("Review could be deleted", HttpStatus.NOT_FOUND);
   
};
}
