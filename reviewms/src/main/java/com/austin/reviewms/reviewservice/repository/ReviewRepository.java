package com.austin.reviewms.reviewservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.austin.reviewms.reviewservice.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

   List<Review> findByCompanyId(Long companyId);
   
}
