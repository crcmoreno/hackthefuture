package dev.reto.hackthefuture.service.dto;

public class GenericResponseDTO {

    private String code;
    private String msg;
    private Object object;

    public GenericResponseDTO() {}

    public GenericResponseDTO(String code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.object = obj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
