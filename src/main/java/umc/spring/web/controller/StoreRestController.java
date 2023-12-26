package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/save")
    public ApiResponse<StoreResponse.CreateStoreResultDTO> createStore(
            @RequestBody
            @Valid StoreRequest.CreateStore request){
        Store store = storeCommandService.StoreCreate(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResult(store));
    }
}
