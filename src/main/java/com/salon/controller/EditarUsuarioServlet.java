
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
public class EditarUsuarioServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                        int id=Integer.parseInt(request.getParameter("idUsuario"));
               
                UsuarioService service= new UsuarioServiceImplement();
              UsuarioJPA usuario= service.obtenerRegistro(id);
                              if(usuario!=null) {
				
				request.setAttribute("usuario",usuario);			
				RequestDispatcher rd= request.getRequestDispatcher("/editar.jsp");
				rd.forward(request,response);				
			}else	{
				request.setAttribute("error","error!");	
				RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				rd.forward(request,response);
			}
              

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             int id=Integer.parseInt(request.getParameter("idUsuario"));
                String nombre = request.getParameter("nombreUsuario");
                String email = request.getParameter("email");
		String contraseña=request.getParameter("password");
                String telefono = request.getParameter("telefono");
                
                
                UsuarioService service= new UsuarioServiceImplement();

                UsuarioJPA usuario= new UsuarioJPA(id,nombre,email,telefono,contraseña);//=service.login(email, contraseña);
                boolean editar= service.actualizarRegistro(usuario);
                
                if(editar) {
                                List <UsuarioJPA> lista=service.obtenerRegistros();
                                request.setAttribute("usuarios",lista);
				RequestDispatcher rd= request.getRequestDispatcher("/registrados.jsp");
				rd.forward(request,response);				
			}else	{
				request.setAttribute("error","error!");	
				RequestDispatcher rd= request.getRequestDispatcher("/editar.jsp");
				rd.forward(request,response);
			}
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
