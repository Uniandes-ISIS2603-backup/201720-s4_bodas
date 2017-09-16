/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.resources;

import co.edu.uniandes.csw.boda.persistence.BodaPersistence;
import co.edu.uniandes.csw.edu.ejb.BodaLogic;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author vn.gomez
 */
@Path("bodas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class BodaResource {
    
    @Inject
    private BodaLogic bodaLogic;
    
     private static final Logger LOGGER = Logger.getLogger(BodaPersistence.class.getName());

    
}
