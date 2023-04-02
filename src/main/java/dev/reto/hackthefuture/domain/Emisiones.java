package dev.reto.hackthefuture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "emisiones")
public class Emisiones {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipos_emisiones_seq")
    @SequenceGenerator(name = "tipos_emisiones_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "combustible_id")
    private Long combustibleId;

    @Column(name = "emision_id")
    private Long emisionId;

    @Column(name = "cantidad")
    private Long cantidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "Emisiones [id=" + id + ", combustibleId=" + combustibleId + ", emisionId=" + emisionId + ", cantidad=" + cantidad + "]";
    }
}
