package com.example.Advanced_Programming_Project;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response ) {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();

        if (session != null) {
            session.invalidate();

            /* Redirection vers la page de connexion ! */
            response.sendRedirect("Login.jsp");
        }
    }
}
