package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MissionResponse;

public class MemberMissionConverter {

    public static MissionResponse.StartMissionResultDTO toStartMissionResult(MemberMission mission){

        return MissionResponse.StartMissionResultDTO
                .builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
