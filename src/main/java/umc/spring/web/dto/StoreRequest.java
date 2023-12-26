package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequest {
    @Getter
    public static class CreateStore{
        @NotNull
        String name;
        @NotNull
        String address;
        @NotNull
        Long regionId;
    }
}
