/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pa1_final_ina_suazo.repositorio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import pa1_final_ina_suazo.app.Personas;

/**
 *
 * @author inalaurasuazo
 */
public class PersonasRepositorio implements Repositorio<Personas> {
    
     private EntityManager em;

    public static EntityManager getEm() {
        try {
            String nombreEM = "uth4PU";

            return Persistence.createEntityManagerFactory(nombreEM).createEntityManager();

        } catch (Exception e) {
            throw new UnsupportedOperationException("Error al obtener la EM." + e.toString());
        }
    }
    
    private void iniciarTransaccion() {
        em = getEm();

        em.getTransaction().begin();
    }
    
     private void guardarCambios(){
        em.getTransaction().commit();
    }

    @Override
    public void crear(Personas t) throws Exception {
        iniciarTransaccion();
        em.persist(t);
        guardarCambios();
    }

    @Override
    public void eliminar(Personas t) throws Exception {
           iniciarTransaccion();
        
        //Obteniendo el identificador
        String identidad=t.getIdentidad();
        
        //Obteniendo el valor desde la base
        Personas personaEliminar=buscar(identidad);
        
        em.remove(personaEliminar);
        guardarCambios();
    }
    

    @Override
    public void actualizar(Personas t) throws Exception {
         iniciarTransaccion();
        
        //Obteniendo el identificador
        String identidad=t.getIdentidad();
        
        //Obteniendo el valor desde la base
        Personas personaactualizar=buscar(identidad);
        
        //Actualizando campo a campo
        personaactualizar.setNombre(t.getNombre());
        personaactualizar.setApellido(t.getApellido());
        personaactualizar.setPeso(t.getPeso());
        personaactualizar.setAnionacimiento(t.getAnionacimiento());
        personaactualizar.setPesoequipaje(t.getPesoequipaje());

        
        em.persist(personaactualizar);
        
        guardarCambios();
    }

    @Override
    public Personas buscar(Object id) throws Exception {
                return em.find(Personas.class, id);

    }

    @Override
    public List<Personas> buscarTodo() throws Exception  {
       iniciarTransaccion();
      
        return em.createQuery("SELECT p FROM Personas p").getResultList();
    }
    }
    

