package com.example.Advanced_Programming_Project;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        /* Récupération et destruction de la session en cours */
        try {
            HttpSession session = request.getSession();

            if (session != null) {
                session.invalidate();

                /* Redirection vers la page de connexion ! */
                response.sendRedirect(request.getContextPath() + "/");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
