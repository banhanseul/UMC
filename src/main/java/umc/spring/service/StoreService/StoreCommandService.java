package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequest;


public interface StoreCommandService {
    Store StoreCreate(StoreRequest.CreateStore request);
}