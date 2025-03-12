package br.com.joao.ms_joao.domain.exceptions;

public class InterServerErrorRequestException extends RuntimeException{
    private String msg;
    private String code;
    public InterServerErrorRequestException(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }
    public InterServerErrorRequestException() {
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
    @Override
    public String toString() {
        return "BadRequestException{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
