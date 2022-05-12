
package com.salon.controller;

import com.salon.entity.UsuarioJPA;
import com.salon.service.UsuarioService;
import com.salon.service.UsuarioServiceImplement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Griselda Medina Avendaño
 * Creado: 9 Mayo 2022
 * Actualizado: 11 Mayo 20211
 */
public class EliminarUsuarioServlet extends HttpServlet {

 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          int id=Integer.parseInt(request.getParameter("idUsuario"));                 
                
                UsuarioService service= new UsuarioServiceImplement();

                boolean eliminado= service.eliminarRegistro(id);
               List <UsuarioJPA> lista=service.obtenerRegistros();
                                request.setAttribute("usuarios",lista);
				RequestDispatcher rd= request.getRequestDispatcher("/registrados.jsp");
				rd.forward(request,response);	
    }

   

}
