package co.edu.uniandes.csw.boda.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
public class TarjetaCreditoEntity extends BaseEntity {
    private Long numero;
    private Double numDeSeg;
    @Temporal(TemporalType.DATE)
    private Date fechaVen;
    
    @PodamExclude
    @ManyToOne
    private ParejaEntity pareja;

    public ParejaEntity getPareja() {
        return pareja;
    }

    public void setPareja(ParejaEntity pareja) {
        this.pareja = pareja;
    }
    
    public Date getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(Date fechaVen) {
        this.fechaVen = fechaVen;
    }
    
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Double getNumDeSeg() {
        return numDeSeg;
    }

    public void setNumDeSeg(Double numDeSeg) {
        this.numDeSeg = numDeSeg;
    }
}