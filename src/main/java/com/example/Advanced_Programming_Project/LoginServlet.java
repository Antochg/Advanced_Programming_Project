package com.example.Advanced_Programming_Project;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.beans.TutorBean;
import model.entity.TutorEntity;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet  {

    @EJB
    TutorBean tutorBean;

    @Override
    public void init() {    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            HttpSession session = request.getSession(true);

            TutorEntity tutor = tutorBean.getTutor(login, password);

            if (tutor != null) {
                session.setAttribute("tutor", tutor);
                System.out.println(request.getContextPath());
                response.sendRedirect(request.getContextPath() + "/gestionServlet"); //Page d'accueil
            } else {
                response.sendRedirect(request.getContextPath() + "/"); // page d'erreur
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
