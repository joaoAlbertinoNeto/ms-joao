package br.com.joao.ms_joao.domain.exceptions;

public class UnauthorizedrRequestException extends RuntimeException{
    private String msg;
    private String code;
    public UnauthorizedrRequestException(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }
    public UnauthorizedrRequestException() {
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
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
