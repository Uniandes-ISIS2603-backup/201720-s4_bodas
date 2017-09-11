/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.boda.persistence;

import co.edu.uniandes.csw.boda.entities.DefaultEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author mf.valllejo
 */
@RunWith(Arquillian.class)
public class DefaultPersistenceTest {
    
    public DefaultPersistenceTest() {
    }
    
     /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Default, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DefaultEntity.class.getPackage())
                .addPackage(DefaultPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase EmployeePersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private DefaultPersistence defaultPersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from DefaultEntity").executeUpdate();
    }

    /**
     *
     */
    private List<DefaultEntity> data = new ArrayList<DefaultEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DefaultEntity entity = factory.manufacturePojo(DefaultEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Default.
     *
     *
     */
    @Test
    public void createDefaultTest() {
        PodamFactory factory = new PodamFactoryImpl();
        DefaultEntity newEntity = factory.manufacturePojo(DefaultEntity.class);
        DefaultEntity result = defaultPersistence.create(newEntity);

        Assert.assertNotNull(result);

        DefaultEntity entity = em.find(DefaultEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar la lista de Default.
     *
     *
     */
    @Test
    public void getDefaultTest() {
        List<DefaultEntity> list = defaultPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (DefaultEntity ent : list) {
            boolean found = false;
            for (DefaultEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Default.
     *
     *
     */
    @Test
    public void getDefaulTest() {
        DefaultEntity entity = data.get(0);
        DefaultEntity newEntity = defaultPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Prueba para eliminar un Default.
     *
     *
     */
    @Test
    public void deleteDefaultTest() {
        DefaultEntity entity = data.get(0);
        defaultPersistence.delete(entity.getId());
        DefaultEntity deleted = em.find(DefaultEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Default.
     *
     *
     */
    @Test
    public void updateDefaultTest() {
        DefaultEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        DefaultEntity newEntity = factory.manufacturePojo(DefaultEntity.class);

        newEntity.setId(entity.getId());

        defaultPersistence.update(newEntity);

        DefaultEntity resp = em.find(DefaultEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
