package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ReviewResponse {
    @Builder
    @Getter
    public static class ReviewResultDTO{
        Long reviewId;
        LocalDateTime createdAt;
    }
}
