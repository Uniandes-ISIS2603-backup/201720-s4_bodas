package co.edu.uniandes.csw.boda.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ca.guerrero
 */
@Entity
public class TarjetaCreditoEntity extends BaseEntity implements Serializable{
    private Long numero;
    
    private int numDeSeg;
    
    @Temporal(TemporalType.DATE)
    private Date fechaVen;
    
    @PodamExclude
    @ManyToOne
    private ParejaEntity pareja;
    
    @PodamExclude
    @OneToMany(mappedBy = "tarjetaCredito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PagoEntity> pagos;
    
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

    public int getNumDeSeg() {
        return numDeSeg;
    }

    public void setNumDeSeg(int numDeSeg) {
        this.numDeSeg = numDeSeg;
    }

    public List<PagoEntity> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }
    public ParejaEntity getPareja() {
        return pareja;
    }

    public void setPareja(ParejaEntity pareja) {
        this.pareja = pareja;
    }
}