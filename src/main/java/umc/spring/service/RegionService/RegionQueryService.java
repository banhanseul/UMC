package umc.spring.service.RegionService;

import umc.spring.domain.Region;

import java.util.Optional;

public interface RegionQueryService {
    Optional<Region> findById(Long id);  // 지역의 id를 기반으로 지역에 대한 가게 조회 메소드
}
