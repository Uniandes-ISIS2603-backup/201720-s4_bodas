/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.resources;

import co.edu.uniandes.csw.edu.ejb.ParejaLogic;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.*;
/**
 *
 * @author nf.ortiz
 */
@Path("parejas")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class ParejaResource {
    
    @Inject
    ParejaLogic parejaLogic;
    

}
