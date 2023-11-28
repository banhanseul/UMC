package umc.mission.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorReasonDTO {

    private HttpStatus httpStatus;

    private final boolean isSuccess;
    private final String code;
    private final String message;

    // 이건 어디다 쓰는건지 ..
    public boolean getInSuccess(){ return isSuccess; }
}
