package umc.mission.converter;

import umc.mission.domian.Mission;
import umc.mission.web.dto.MissionResponse;

public class MissionConverter {

    public static MissionResponse.MissionDTO tomissionDTO(){
        return MissionResponse.MissionDTO
                .builder()
                // 임시로 넣어 놓은 데이터들
                .missionId(1l)
                .name("야호")
                .point(1000)
                .build();
    }
}
