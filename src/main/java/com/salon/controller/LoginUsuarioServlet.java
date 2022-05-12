package com.salon.controller;

import com.salon.entity.UsuarioJPA;
import com.salon.service.UsuarioService;
import com.salon.service.UsuarioServiceImplement;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Griselda Medina Avendaño Creado: 9 Mayo 2022 Actualizado: 11 Mayo
 * 20211
 */
public class LoginUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String contraseña = request.getParameter("contraseña");
        System.out.println("request--" + email + " " + contraseña);
        UsuarioService service = new UsuarioServiceImplement();

        UsuarioJPA login = service.login(email, contraseña);

        if (login != null) {

            request.setAttribute("usuario", login);
            RequestDispatcher rd = request.getRequestDispatcher("/bienvenido.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error", "error!");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }

    }

}
