package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MissionRequest;

public interface MissionCommandService {
    Mission MissionCreate(Long storeId, MissionRequest.CreateMissionDTO request);

    MemberMission MissionStart(MissionRequest.StartMissionDTO request);
}
