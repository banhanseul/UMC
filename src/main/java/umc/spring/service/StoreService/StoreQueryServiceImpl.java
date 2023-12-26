package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    @Override
    public Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }
}
