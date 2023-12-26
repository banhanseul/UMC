package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponse.ReviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponse.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequest.ReviewWriteDTO request){
        return Review.builder()
                .content(request.getContent())
                .score(request.getStar())
                .build();
    }
}
