package dev.reto.hackthefuture.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_combustible")
public class TiposCombustible {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipos_combustible_seq")
    @SequenceGenerator(name = "tipos_combustible_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "desc_tipo")
    private String descTipo;

    @Column(name = "emisiones_id")
    private Long emisionesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescTipo() {
        return descTipo;
    }

    public void setDescTipo(String descTipo) {
        this.descTipo = descTipo;
    }

    public Long getEmisionesId() {
        return emisionesId;
    }

    public void setEmisionesId(Long emisionesId) {
        this.emisionesId = emisionesId;
    }

    @Override
    public String toString() {
        return "TiposCombustible [id=" + id + ", descTipo=" + descTipo + ", emisionesId=" + emisionesId + "]";
    }
}
