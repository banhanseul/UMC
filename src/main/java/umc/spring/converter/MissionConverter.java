package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponse.CreateMissionResultDTO toCreateMissionResult(Mission mission){
        return MissionResponse.CreateMissionResultDTO
                .builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequest.CreateMissionDTO request){
        return Mission.builder()
                .content(request.getContent())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .build();
    }
}
