package br.com.joao.ms_joao.infrastructure.rest.in.exceptions;

public class RestErrorExceptionDTO {
    private String msg;
    private String code;
    private String timestamp;

    public RestErrorExceptionDTO() {
    }

    public RestErrorExceptionDTO(String msg, String code, String timeStamp) {
        this.msg = msg;
        this.code = code;
        this.timestamp = timeStamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "RestErrorException{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", timeStamp='" + timestamp + '\'' +
                '}';
    }
}