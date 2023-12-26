package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.MissionRequest;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final StoreQueryService storeQueryService;
    private final MemberQueryService memberQueryService;
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public Mission MissionCreate(Long storeId, MissionRequest.CreateMissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);
        Store store = storeQueryService.findById(request.getStoreId()).get();

        newMission.setStore(store);

        return missionRepository.save(newMission);
    }

    @Override
    public MemberMission MissionStart(MissionRequest.StartMissionDTO request) {
        MemberMission memberMission = MemberMission.builder().status(MissionStatus.CHALLENGING).build();

        Long memberId = request.getMemberId();
        Long missionId = request.getMissionId();
        memberMission.setMember(memberQueryService.findById(memberId).get());
        memberMission.setMission(missionRepository.findById(missionId).get());

        return memberMissionRepository.save(memberMission);
    }
}
