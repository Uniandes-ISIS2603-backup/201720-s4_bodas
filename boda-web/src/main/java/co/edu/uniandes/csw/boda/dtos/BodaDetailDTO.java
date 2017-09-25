/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.BodaEntity;
import co.edu.uniandes.csw.boda.entities.InvitadoEntity;
import co.edu.uniandes.csw.boda.entities.RegaloEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vn.gomez
 */
public class BodaDetailDTO extends BodaDTO{
    
    private List<RegaloDTO> regalos;
    private List<InvitadoDTO> invitados;
    /**
     * Constructor por defecto
     */
    public BodaDetailDTO(){
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity
     */
    public BodaDetailDTO( BodaEntity entity) {
        super(entity);
        if (entity.getRegalos() != null) {
            regalos = new ArrayList<>();
            for (RegaloEntity entityRegalo : entity.getRegalos()) {
                regalos.add(new RegaloDTO(entityRegalo));
            }
        }
         if (entity.getInvitados() != null) {
            invitados = new ArrayList<>();
            for (InvitadoEntity entityInvitado : entity.getInvitados()) {
                invitados.add(new InvitadoDTO(entityInvitado));
            }
        }
    }

}
