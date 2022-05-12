/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salon.service;

import com.salon.dao.UsuarioJPAJpaController;
import com.salon.dao.exceptions.NonexistentEntityException;
import com.salon.entity.UsuarioJPA;
import java.util.List;


/**
 *
 * @author Medina
 */
public class UsuarioServiceImplement implements UsuarioService{
    UsuarioJPAJpaController usuarioJPA = new UsuarioJPAJpaController();
   
    @Override
    public UsuarioJPA crearRegistro(UsuarioJPA usuario) {
        try {
            usuarioJPA.createUsuario(usuario);
            //usuarioJPA.desconectar();
            return usuario;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizarRegistro(UsuarioJPA usuario) {
        boolean resp=false;
        try {
            usuarioJPA.editUsuario(usuario);
            //usuarioJPA.desconectar();

            resp= true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    @Override
    public List<UsuarioJPA> obtenerRegistros() {
        List<UsuarioJPA> lista=usuarioJPA.listarUsuarios();
       // usuarioJPA.desconectar();
        return lista; 
                    

    }

    @Override
    public UsuarioJPA obtenerRegistro(int idUsuario) {
        UsuarioJPA usuario=usuarioJPA.findUsuarioJPA(idUsuario);
        usuarioJPA.desconectar();
        return usuario;
    }

    @Override
    public boolean eliminarRegistro(int idUsuario) {
        boolean resp=false;
        try {
            usuarioJPA.deleteUsuario(idUsuario);
            //usuarioJPA.desconectar();

            resp=true;
        } catch (NonexistentEntityException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }
    
    @Override
    public UsuarioJPA login(String email,String contraseña){
        UsuarioJPA resp=null;
        try {
             resp=usuarioJPA.login(email, contraseña);
             //usuarioJPA.desconectar();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    
}
