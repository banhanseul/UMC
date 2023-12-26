package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/create")
    public ApiResponse<ReviewResponse.ReviewResultDTO> write(
            @ExistStores @PathVariable(name = "storeId") Long storeId,
            @ExistMembers @RequestParam(name = "memberId") Long memberId,  // 회원아이디는 쿼리스트링으로 넘겨 받음
            @Valid @RequestBody ReviewRequest.ReviewWriteDTO request){
        Review review = reviewCommandService.reviewWrite(storeId, memberId, request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }
}
