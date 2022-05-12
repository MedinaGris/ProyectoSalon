
package com.salon.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;

/**
 *
 * @author Griselda Medina Avendaño
 * Creado: 9 Mayo 2022
 * Actualizado: 11 Mayo 20211
 */
@Entity
@Table(name="usuario")
public class UsuarioJPA implements Serializable {

   // private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="idusuario")
    private int id;

    @Column (name="nombreusuario")
    private String nombreUsuario;
    
    @Column (name="email")
    private String email;
            
    @Column (name="telefono")
    private String telefono;
    
    @Column (name="contraseña") 
   private String contraseña;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
    public UsuarioJPA(int id, String nombreUsuario, String email, String telefono, String contraseña) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public UsuarioJPA() {
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioJPA)) {
            return false;
        }
        UsuarioJPA other = (UsuarioJPA) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioJPA{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", email=" + email + ", telefono=" + telefono + ", contrase\u00f1a=" + contraseña + '}';
    }

    
    
}
