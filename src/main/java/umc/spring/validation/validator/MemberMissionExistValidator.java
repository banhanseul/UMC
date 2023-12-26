package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.validation.annotation.ExistMemberMission;
import umc.spring.validation.annotation.ExistMembers;
import umc.spring.web.dto.MissionRequest;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberMissionExistValidator implements ConstraintValidator<ExistMemberMission, MissionRequest.StartMissionDTO> {
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;


    @Override
    public void initialize(ExistMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequest.StartMissionDTO value, ConstraintValidatorContext context) {
        Member member = memberRepository.findById(value.getMemberId()).get();
        Mission mission = missionRepository.findById(value.getMissionId()).get();
        List<MemberMission> memberMissionList = memberMissionRepository.findByMemberAndMission(member, mission);

        if (memberMissionList.size() != 0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_DONE.toString()).addConstraintViolation();
        }

        return false;
    }
}
