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
            resp= true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    @Override
    public List<UsuarioJPA> obtenerRegistros() {
        return usuarioJPA.listarUsuarios();
    }

    @Override
    public UsuarioJPA obtenerRegistro(int idUsuario) {
        return usuarioJPA.findUsuarioJPA(idUsuario);
    }

    @Override
    public boolean eliminarRegistro(int idUsuario) {
        boolean resp=false;
        try {
            usuarioJPA.deleteUsuario(idUsuario);
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
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    
}
