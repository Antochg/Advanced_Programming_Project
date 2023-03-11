package com.example.Advanced_Programming_Project;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.entity.TutorEntity;

import java.io.IOException;

@WebServlet("/gestionServlet")
public class GestionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        TutorEntity tutor = (TutorEntity) session.getAttribute("tutor");

        if(tutor != null){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/interships.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }

    }
}
