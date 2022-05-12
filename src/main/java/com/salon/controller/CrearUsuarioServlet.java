
package com.salon.controller;

import com.salon.entity.UsuarioJPA;
import com.salon.service.UsuarioService;
import com.salon.service.UsuarioServiceImplement;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CrearUsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                int id=Integer.parseInt(request.getParameter("idUsuario"));
                String nombre = request.getParameter("nombreUsuario");
                String email = request.getParameter("email");
		String contraseña=request.getParameter("password");
                String telefono = request.getParameter("telefono");
                
                
                UsuarioService service= new UsuarioServiceImplement();

                UsuarioJPA usuario= new UsuarioJPA(id,nombre,email,telefono,contraseña);//=service.login(email, contraseña);
                UsuarioJPA login= service.crearRegistro(usuario);
                
                if(login!=null) {
				
				request.setAttribute("usuario",login);			
				RequestDispatcher rd= request.getRequestDispatcher("/bienvenido.jsp");
				rd.forward(request,response);				
			}else	{
				request.setAttribute("error","error!");	
				RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				rd.forward(request,response);
			}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
