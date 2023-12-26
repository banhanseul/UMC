package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;
import umc.spring.service.RegionService.RegionQueryService;
import umc.spring.web.dto.StoreRequest;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionQueryService regionQueryService;

    @Override
    public Store StoreCreate(StoreRequest.CreateStore request) {
        Store newStore = StoreConverter.toStore(request);
        Region region = regionQueryService.findById(request.getRegionId()).get();

        newStore.setRegion(region);
        return storeRepository.save(newStore);
    }
}

