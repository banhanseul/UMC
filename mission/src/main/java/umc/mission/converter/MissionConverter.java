package umc.mission.converter;

import umc.mission.domian.Mission;
import umc.mission.web.dto.MissionResponse;

public class MissionConverter {
// converter는 repository에서 받아온 엔티티를 dto로 바꾸는 과정을 수행
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
