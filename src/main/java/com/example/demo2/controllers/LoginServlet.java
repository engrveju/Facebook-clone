package com.example.demo2.controllers;

import com.example.demo2.dao.UserDao;
import com.example.demo2.dao.impl.UserDaoImpl;
import com.example.demo2.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
   private  static final UserDao userDao = new UserDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the request parameters
        String email = request.getParameter("email");

        String password = request.getParameter("password");

        System.out.println(email);
        System.out.println(password);

        // validate if the user exists in Database
        System.out.println("got to password verification");

       User foundUser = userDao.findUserByEmailAndPassword(email, password);



        // store the user in session

       if(foundUser != null){
           HttpSession requestSession = request.getSession();

           requestSession.setAttribute("loggedUser", foundUser);
       }

        request.getRequestDispatcher("href=${pageContext.request.contextPath}/dashboard.jsp")
                .forward(request, response);

    }

}
