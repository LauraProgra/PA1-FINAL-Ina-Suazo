/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pa1_final_ina_suazo.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pa1_final_ina_suazo.objetos.Persona;

/**
 *
 * @author inalaurasuazo
 */
public class PersonaRepositorio1 implements Repositorio<Persona>{
    
      public Connection getConnection() throws Exception {
        try {
            String lib = "jdbc";
            String base = "derby";
            String servidor = "localhost";
            String puerto = "1527";
            String nombreBase = "uth4";

            //String cadenaConexion="jdbc:derby://localhost:1527/uth";
            String cadenaConexion = String.format("%s:%s://%s:%s/%s", lib, base, servidor, puerto, nombreBase
            );
            String usuario = "uth4";
            String contrasenia = "uth4";

            return DriverManager.getConnection(cadenaConexion, usuario, contrasenia);
        } catch (Exception e) {
            throw new Exception("No se pudo establecer la conexión: " + e.toString());
        }
        
    
}

    @Override
    public void crear(Persona t) throws Exception {
          try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "INSERT INTO PERSONAS() "
                    + " VALUES "
                    + "(?,?,?,?,?,?) ";
            
            PreparedStatement ps=cnx.prepareStatement(sql);
            ps.setString(1, t.getIdentidad());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getApellido());
            ps.setDouble(4, t.getPeso());
            ps.setInt(5, t.getAnionacimiento());
            ps.setDouble(6, t.getPesoequipaje());
            
            //ejecuta la sentencia
            ps.execute();
            
            //IMPORTANTE:  cerrar sesiones
            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void eliminar(Persona t) throws Exception {
        try  {
              Connection cnx=getConnection();
              
               String sql="DELETE FROM USUARIOS"
                    +"WHERE IDENTIDAD=?";
               
               PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, t.getIdentidad());
            
             ps.execute();

            //IMPORTANTE:  cerrar sesiones
            ps.close();
            cnx.close();
        } catch (Exception e) {
            throw new Exception("Error al eliminar: " + e.toString());
         }
    }

    @Override
    public void actualizar(Persona t) throws Exception {
        try{
            
             Connection cnx = getConnection();

            String sql = "UPDATE USUARIOS "
                    + "SET NOMBRE=?,PESOEQUIPAJE=?, APELLIDO=?  "
                    + "WHERE IDENTIDAD=?";
            
             PreparedStatement ps = cnx.prepareStatement(sql);
             
              ps.setString(1, t.getIdentidad());
              ps.setString(2, t.getNombre());
              ps.setDouble(6, t.getPesoequipaje());
              ps.setString(3, t.getApellido());
             
              
             ps.close();
            cnx.close();
          } catch (Exception e) {
            throw new Exception("Error al actualizar: " + e.toString());
       
            
         
        }
        
    }

    @Override
    public Persona buscar(Object id) throws Exception {
             Persona valorRetorno = new Persona();

        
        try{
            
            Connection cnx = getConnection();
            
              String sql = "select * from PERSONAS where  identidad = '"+id+"' ";

            Statement st = cnx.createStatement();

            //ejecuta la sentencia
            ResultSet resultado = st.executeQuery(sql);
            
             while (resultado.next()) {
                 
                String identidad= resultado.getString("IDENTIDAD");
                String nombre= resultado.getString("NOMBRE");
                String apellido= resultado.getString("APELLIDO");
                double peso= resultado.getDouble("PESO");
                int  anionacimiento = resultado.getInt("ANIONACIMIENTO");
               double pesoequipaje= resultado.getDouble("PESOEQUIPAJE");
                
                valorRetorno.setIdentidad(identidad);
                valorRetorno.setNombre(nombre);
                valorRetorno.setApellido(apellido);
                valorRetorno.setPeso(peso);
                valorRetorno.setAnionacimiento(anionacimiento);
                valorRetorno.setPesoequipaje(pesoequipaje);
                
                
                

    }
             
       st.close();
        cnx.close();
        
         }catch (Exception e) {
            
             throw new Exception("Error al buscar todos: " + e.toString());
        }
        
        return valorRetorno;
        }

    @Override
    public List<Persona> buscarTodo() throws Exception {
          List<Persona> listaRetorno=new ArrayList<>();
        try {
            //Traer la conexion o la session
            Connection cnx = getConnection();

            String sql = "select * from PERSONAS ";

            Statement st = cnx.createStatement();

            //ejecuta la sentencia
            ResultSet resultado = st.executeQuery(sql);
            
                while (resultado.next()) {    
                String identidad = resultado.getString("IDENTIDAD");
                String nombre= resultado.getString("NOMBRE");
                String apellido = resultado.getString("APELLIDO");
                double peso= resultado.getDouble("PESO");
                int anionacimiento = resultado.getInt("ANIONACIMIENTO");
                double pesoequipaje= resultado.getDouble("PESOEQUIPAJE");
                
                Persona v = new Persona();
                v.setIdentidad(identidad);
                v.setNombre(nombre);
                v.setApellido(apellido);
                v.setPeso(peso);
                v.setAnionacimiento(anionacimiento);
                v.setPesoequipaje(pesoequipaje);
               
                
                listaRetorno.add(v);

                }
                
                 st.close();
                cnx.close();

    }catch (Exception e) {
            throw new Exception("Error al buscar todos: " + e.toString());
        }
        return listaRetorno;
    }
      
      
}