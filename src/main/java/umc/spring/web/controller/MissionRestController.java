package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.MissionService.MissionCommandServiceImpl;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/{storeId}")
    public ApiResponse<MissionResponse.CreateMissionResultDTO> createMission(
            @ExistStores @PathVariable(name = "storeId") Long storeId,
            @RequestBody @Valid MissionRequest.CreateMissionDTO request
            ){
        Mission mission = missionCommandService.MissionCreate(storeId, request);

        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResult(mission));
    }

    @PostMapping("/change/start")
    public ApiResponse<MissionResponse.StartMissionResultDTO> startMission(
            @RequestBody @Valid MissionRequest.StartMissionDTO request){
        MemberMission memberMission = missionCommandService.MissionStart(request);

        return ApiResponse.onSuccess(MemberMissionConverter.toStartMissionResult(memberMission));
    }

}
