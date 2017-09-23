package co.edu.uniandes.csw.boda.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ca.guerrero
 */
@Entity
public class PagoEntity extends BaseEntity{
    private Double montoTotal;
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}