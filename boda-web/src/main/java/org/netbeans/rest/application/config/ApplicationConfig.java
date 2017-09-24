/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ca.guerrero
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.uniandes.csw.boda.mappers.BusinessLogicExceptionMapper.class);
        resources.add(co.edu.uniandes.csw.boda.mappers.UnsupportedOperationExceptionMapper.class);
        resources.add(co.edu.uniandes.csw.boda.mappers.WebApplicationExceptionMapper.class);
        resources.add(co.edu.uniandes.csw.boda.resources.BodaResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.CalificacionResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.InvitadoResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.OpcionServicioResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.PagoResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.ParejaResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.ProveedorResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.RegaloResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.ServicioResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.TareaResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.TarjetaCreditoResource.class);
        resources.add(co.edu.uniandes.csw.boda.resources.UbicacionResource.class);
    }
    
}
