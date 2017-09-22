

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.InvitadoEntity;

/**
 *
 * @author mf.valllejo
 */
public class InvitadoDetailDTO extends InvitadoDTO{
    
    public InvitadoDetailDTO() {
    }
    
    public InvitadoDetailDTO(InvitadoEntity entity){
        super(entity);
    }
    
    @Override
    public InvitadoEntity toEntity(){
        InvitadoEntity invitadoE = super.toEntity();
        return invitadoE;
    }
}