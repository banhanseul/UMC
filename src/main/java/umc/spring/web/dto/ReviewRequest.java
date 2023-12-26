package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequest {
    @Getter
    public static class ReviewWriteDTO{
        @NotBlank
        String content;
        @NotNull
        Integer star;
    }
}
