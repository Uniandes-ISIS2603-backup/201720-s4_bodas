/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.ParejaEntity;

/**
 *
 * @author nf.ortiz
 */
public class ParejaDetailDTO  extends ParejaDTO {

    public ParejaDetailDTO() {
    }

    public ParejaDetailDTO(ParejaEntity pareja) {
        super(pareja);
    }
     /**
     * Transformar un DTO a un Entity
     *
     * @return 
     */
    @Override
    public ParejaEntity toEntity() {
       ParejaEntity parejaE = super.toEntity();
        return parejaE;
    }
}
