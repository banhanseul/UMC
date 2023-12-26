package umc.spring.converter;

import lombok.RequiredArgsConstructor;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequest;
import umc.spring.web.dto.StoreResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RequiredArgsConstructor
public class StoreConverter {

    public static StoreResponse.CreateStoreResultDTO toCreateResult(Store store){
        return StoreResponse.CreateStoreResultDTO
                .builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .build();
    }

    // converter 에서 가게 생성
    public static Store toStore(StoreRequest.CreateStore request){
        return Store.builder()
                .name(request.getName())
                .reviewList(new ArrayList<>())
                .build();
    }
}
