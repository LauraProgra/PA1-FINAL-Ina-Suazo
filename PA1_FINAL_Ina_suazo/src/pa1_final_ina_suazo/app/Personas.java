/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pa1_final_ina_suazo.app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author inalaurasuazo
 */
@Entity
@Table(name = "PERSONAS", catalog = "", schema = "UTH4")
@NamedQueries({
    @NamedQuery(name = "Personas.findAll", query = "SELECT p FROM Personas p"),
    @NamedQuery(name = "Personas.findByIdentidad", query = "SELECT p FROM Personas p WHERE p.identidad = :identidad"),
    @NamedQuery(name = "Personas.findByNombre", query = "SELECT p FROM Personas p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Personas.findByApellido", query = "SELECT p FROM Personas p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Personas.findByPeso", query = "SELECT p FROM Personas p WHERE p.peso = :peso"),
    @NamedQuery(name = "Personas.findByAnionacimiento", query = "SELECT p FROM Personas p WHERE p.anionacimiento = :anionacimiento"),
    @NamedQuery(name = "Personas.findByPesoequipaje", query = "SELECT p FROM Personas p WHERE p.pesoequipaje = :pesoequipaje")})
public class Personas implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTIDAD")
    private String identidad;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESO")
    private Double peso;
    @Column(name = "ANIONACIMIENTO")
    private Integer anionacimiento;
    @Column(name = "PESOEQUIPAJE")
    private Double pesoequipaje;

    public Personas() {
    }

    public Personas(String identidad) {
        this.identidad = identidad;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        String oldIdentidad = this.identidad;
        this.identidad = identidad;
        changeSupport.firePropertyChange("identidad", oldIdentidad, identidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        Double oldPeso = this.peso;
        this.peso = peso;
        changeSupport.firePropertyChange("peso", oldPeso, peso);
    }

    public Integer getAnionacimiento() {
        return anionacimiento;
    }
    
   

    public void setAnionacimiento(Integer anionacimiento) {
        Integer oldAnionacimiento = this.anionacimiento;
        this.anionacimiento = anionacimiento;
        changeSupport.firePropertyChange("anionacimiento", oldAnionacimiento, anionacimiento);
    }

    public Double getPesoequipaje() {
        return pesoequipaje;
    }

    public void setPesoequipaje(Double pesoequipaje) {
        Double oldPesoequipaje = this.pesoequipaje;
        this.pesoequipaje = pesoequipaje;
        changeSupport.firePropertyChange("pesoequipaje", oldPesoequipaje, pesoequipaje);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identidad != null ? identidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personas)) {
            return false;
        }
        Personas other = (Personas) object;
        if ((this.identidad == null && other.identidad != null) || (this.identidad != null && !this.identidad.equals(other.identidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pa1_final_ina_suazo.app.Personas[ identidad=" + identidad + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
