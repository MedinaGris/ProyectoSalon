/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salon.service;

import com.salon.entity.UsuarioJPA;
import java.util.List;

/**
 *
 * @author Medina
 */
public interface UsuarioService {
     public UsuarioJPA crearRegistro(UsuarioJPA usuario);

    public boolean actualizarRegistro(UsuarioJPA usuario);

    public List<UsuarioJPA> obtenerRegistros();

    public UsuarioJPA obtenerRegistro(int idUsuario);

    public boolean eliminarRegistro(int idUsuario);
    
    public UsuarioJPA login(String email,String contraseña);

}
