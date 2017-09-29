/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.PagoEntity;
import co.edu.uniandes.csw.boda.entities.TarjetaCreditoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.guerrero
 */
public class TarjetaCreditoDetailDTO extends TarjetaCreditoDTO {
    
    private List<PagoDTO> pagos;
    
    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDetailDTO() {
        super();
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public TarjetaCreditoDetailDTO(TarjetaCreditoEntity entity) {
        super(entity);
            if (entity.getPagos() != null) {
            pagos = new ArrayList<>();
            for (PagoEntity entityPago : entity.getPagos()) {
                pagos.add(new PagoDTO(entityPago));
            }

        }
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public TarjetaCreditoEntity toEntity() {
        return super.toEntity();
    }

    public List<PagoDTO> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }
    
}
