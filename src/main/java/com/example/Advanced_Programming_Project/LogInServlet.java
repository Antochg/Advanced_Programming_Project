package com.example.Advanced_Programming_Project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LogInServlet extends HttpServlet  {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

//        String login = request.getParameter("login");
//        String password = request.getParameter("password");
//
//        HttpSession session = request.getSession(true);
//
//        session.setAttribute("login", login);
//        session.setAttribute("password", password);
//
//        try {
//            Class.forName("persistantdata.MediathequeData");
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }

//        Utilisateur user = Mediatheque.getInstance().getUser(login, password);
//
//        if (user != null) {
//
//            session.setAttribute("sessionUtilisateur", user);
//
//
//            if(user.isBibliothecaire()) {
//                response.sendRedirect(request.getContextPath()+"/AccueilBibliothecaire.jsp"); //Page d'accueil pour bibliothecaire
//            }
//            else {
//                response.sendRedirect(request.getContextPath()+"/AccueilAbonne.jsp"); //Page d'accueil pour abonne
//            }
//        }
//        else {
//            session.setAttribute("erreurLogin", "1");
//            response.sendRedirect(request.getContextPath()+"/Login.jsp"); // page d'erreur
//        }

    }
}
