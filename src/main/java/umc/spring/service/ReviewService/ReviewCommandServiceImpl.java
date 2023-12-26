package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.ReviewRequest;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final MemberQueryService memberQueryService;
    private final StoreQueryService storeQueryService;

    @Override
    public Review reviewWrite(Long storeId, Long memberId, ReviewRequest.ReviewWriteDTO request) {
        Review newReview = ReviewConverter.toReview(request);
        newReview.setStore(storeQueryService.findById(storeId).get());
        newReview.setMember(memberQueryService.findById(memberId).get());

        return reviewRepository.save(newReview);
    }
}
