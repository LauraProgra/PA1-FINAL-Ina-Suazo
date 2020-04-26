/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pa1_final_ina_suazo.controlador;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import pa1_final_ina_suazo.app.Personas;
import pa1_final_ina_suazo.repositorio.PersonasRepositorio;

/**
 *
 * @author inalaurasuazo
 */
public class Personascontrolador {
    
      static PersonasRepositorio vr = new PersonasRepositorio();

    static String[] columnasTablaPersonas = new String[]{
        "Identidad", "Nombre", "Apellido", "Peso","Anionacimiento","Pesoequipaje"
    };

    public static Object[][] convertirLista(List<Personas> lista) {
        int tamanioLista = lista.size();
        int numeroColumnas = columnasTablaPersonas.length;

        Object[][] tablaRetorno = new Object[tamanioLista][numeroColumnas];

        for (int i = 0; i < tamanioLista; i++) {
            tablaRetorno[i][0] = lista.get(i).getIdentidad();
            tablaRetorno[i][1] = lista.get(i).getNombre();
            tablaRetorno[i][2] = lista.get(i).getApellido();
            tablaRetorno[i][3] = lista.get(i).getPeso();
            tablaRetorno[i][4] = lista.get(i).getAnionacimiento();
             tablaRetorno[i][4] = lista.get(i).getPesoequipaje();
            
        }
        return tablaRetorno;
    }

    public static DefaultTableModel getTblPersonas() throws Exception {
        List<Personas> listaVehiculosBD = vr.buscarTodo();

        DefaultTableModel defaultTableModel = new DefaultTableModel(
                convertirLista(listaVehiculosBD),
                columnasTablaPersonas
        );

        return defaultTableModel;
    }

    public static void guardarPersona(Personas persona) throws Exception {
        vr.crear(persona);
    }

    public static void actualizarPersona(Personas persona) throws Exception {
        vr.actualizar(persona);
    }

    public static void eliminarPersona(Personas persona) throws Exception {
        vr.eliminar(persona);
    }

    
}
