package umc.mission.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.mission.apiPayload.code.BaseErrorCode;
import umc.mission.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
// GeneralException 모든 커스텀 예외가 상속받는 상위 예외
public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
