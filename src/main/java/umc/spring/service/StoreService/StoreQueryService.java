package umc.spring.service.StoreService;

import org.springframework.stereotype.Service;
import umc.spring.domain.Store;

import java.util.Optional;

@Service
public interface StoreQueryService {
    Optional<Store> findById(Long id);  // 가게 id를 기반으로 가게에 대한 정보 조회 메소드
}
