package umc.mission.converter;

import umc.mission.web.dto.TempResponse;

public class TempConverter {
// converter는 repository에서 받아온 엔티티를 dto로 바꾸는 과정을 수행

    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO
                .builder()
                .testString("This is Test!!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO
                .builder()
                .flag(flag)
                .build();
    }
}
