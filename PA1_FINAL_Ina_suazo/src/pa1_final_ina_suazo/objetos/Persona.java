/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pa1_final_ina_suazo.objetos;

/**
 *
 * @author inalaurasuazo
 */
public class Persona {
    
    private String identidad;
    private String nombre;
    private String apellido;
    private double peso;
    private int anionacimiento;
    private double pesoequipaje;

    public Persona(String identidad, String nombre, String apellido, double peso, int anionacimiento, double pesoequipaje) {
        this.identidad = identidad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.anionacimiento = anionacimiento;
        this.pesoequipaje = pesoequipaje;
    }

    public Persona() {
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAnionacimiento() {
        return anionacimiento;
    }

    public void setAnionacimiento(int anionacimiento) {
        this.anionacimiento = anionacimiento;
    }

    public double getPesoequipaje() {
        return pesoequipaje;
    }

    public void setPesoequipaje(double pesoequipaje) {
        this.pesoequipaje = pesoequipaje;
    }

    @Override
    public String toString() {
        return "Persona{" + "identidad=" + identidad + ", nombre=" + nombre + ", apellido=" + apellido + ", peso=" + peso + ", anionacimiento=" + anionacimiento + ", pesoequipaje=" + pesoequipaje + '}';
    }
    
    
    
}
