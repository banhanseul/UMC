package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequest {
    @Getter
    public static class CreateMissionDTO{
        @NotBlank
        String content;
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotNull
        Long storeId;
    }

    @Getter
    public static class StartMissionDTO{
        @NotNull
        Long missionId;
        @NotNull
        Long memberId;
    }
}
