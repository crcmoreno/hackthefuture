package dev.reto.hackthefuture.service.dto;

import java.io.Serializable;

public class EmisionesDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long combustibleId;
    private Long emisionId;
    private Long cantidad;

    public Long getCombustibleId() {
        return combustibleId;
    }

    public void setCombustibleId(Long combustibleId) {
        this.combustibleId = combustibleId;
    }

    public Long getEmisionId() {
        return emisionId;
    }

    public void setEmisionId(Long emisionId) {
        this.emisionId = emisionId;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "EmisionesDTO [combustibleId=" + combustibleId + ", emisionId=" + emisionId + ", cantidad=" + cantidad + "]";
    }
}
