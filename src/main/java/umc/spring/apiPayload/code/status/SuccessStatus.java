package umc.spring.apiPayload.code.status;

import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.BaseCode;
import umc.spring.apiPayload.code.ReasonDTO;

public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public ReasonDTO getReason() {
        return ReasonDTO.builder().message(this.message).code(this.code).isSuccess(true).build();
    }

    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder().message(this.message).code(this.code).isSuccess(true).httpStatus(this.httpStatus).build();
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    private SuccessStatus(final HttpStatus httpStatus, final String code, final String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}

