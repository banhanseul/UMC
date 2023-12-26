package umc.spring.converter;

import umc.spring.web.dto.TempResponse;
import umc.spring.web.dto.TempResponse.TempExceptionDTO;
import umc.spring.web.dto.TempResponse.TempTestDTO;

import umc.spring.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO(){
        return TempResponse.TempTestDTO.builder()
                .testString("This is Test!")
                .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag){
        return TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
