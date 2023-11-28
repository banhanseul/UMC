package umc.mission.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.mission.apiPayload.ApiResponse;
import umc.mission.converter.MissionConverter;
import umc.mission.web.dto.MissionResponse;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class MissionRestController {

    // 미션 성공 API
    @GetMapping("/missions/done")
    public ApiResponse<MissionResponse.MissionDTO> missionDoneAPI(){
        return ApiResponse.onDone(MissionConverter.tomissionDTO());
    }

    // 미션 중 API
    @GetMapping("/missions/nonpass")
    public ApiResponse<MissionResponse.MissionDTO> missionIngAPI(){
        return ApiResponse.onIng(MissionConverter.tomissionDTO());
    }
}
