/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.salon.dao.UsuarioJPAJpaController;
import com.salon.entity.UsuarioJPA;
import java.util.List;

/**
 *
 * @author Medina
 */
public class Pruebas {

    public static void main(String[] args) {
        try {
//        UsuarioJPA usuarioJPA = new UsuarioJPA(21, "gris", "jsh","pomjn","1234");
////        UsuarioJPA usuarioJPA1 = new UsuarioJPA(22, "gris", "jsh","pomjn","1234");
////        UsuarioJPA usuarioJPA2 = new UsuarioJPA(2, "gris", "jsh","pomjn","1234");
////        UsuarioJPA usuarioJPA3 = new UsuarioJPA(29, "gris", "jsh","pomjn","1234");
//        
            UsuarioJPAJpaController instance = new UsuarioJPAJpaController();
            //  instance.createUsuario(usuarioJPA);
////         instance.createUsuario(usuarioJPA1);
////          instance.createUsuario(usuarioJPA2);
////           instance.createUsuario(usuarioJPA3);
////        
//        UsuarioJPA usuarioEdit = new UsuarioJPA(5, "luz", "medinaluz@gmail.com","9511111111","1234");
//      instance.editUsuario(usuarioEdit);
//           System.out.println("\nusuario 5: "+instance.findUsuarioJPA(5).toString());

//           instance.destroyUsuario(21);
            List<UsuarioJPA> usuarios = instance.listarUsuarios();

            for (UsuarioJPA usuario : usuarios) {

                System.out.println("\n" + usuario.toString() + "\n");
            }

//        if(instance.login("medinaluz@gmail.com", "1234")!=null){
//            System.out.println("\ningreso\n");
//        }else{
//            System.out.println("no se pudo ingresar");
//        }
            instance.desconectar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
