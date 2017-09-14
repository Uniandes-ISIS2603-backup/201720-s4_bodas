/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.dtos;

import co.edu.uniandes.csw.boda.entities.ParejaEntity;

/**
 *CityDTO Objeto de transferencia de datos de Cityes. Los DTO
 * contienen las represnetaciones de los JSON que se transfieren entre el cliente y el servidor.
 * @author nf.ortiz
 */
public class ParejaDTO {

    
    ///////////////////////////////
    /////Atributos////////////////
    
    /**
     * Constructor por defecto
     */
    public ParejaDTO() {
    }
    
    /**
     * Conviertir Entity a DTO
     * (Crea un nuevo DTO con los valores que recibe en  la entidad que viene de argumento.
     * @param pareja: Es la entidad que se va a convertir a DTO 
     */
    public ParejaDTO(ParejaEntity pareja) {
        
        
    }
    
}
