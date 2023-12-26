package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequest;

public interface ReviewCommandService {
    Review reviewWrite(Long storeId, Long memberId, ReviewRequest.ReviewWriteDTO request);
}
