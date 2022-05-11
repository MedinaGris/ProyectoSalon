/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Medina
 */
public class LoginUsuarioServlet extends HttpServlet {

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//               
//      
//    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
		String contraseña=request.getParameter("contraseña");
                System.out.println("request--"+email+" "+contraseña);
                UsuarioService service= new UsuarioServiceImplement();
                        
                UsuarioJPA login=service.login(email, contraseña);
                        
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

    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

   
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }

}
