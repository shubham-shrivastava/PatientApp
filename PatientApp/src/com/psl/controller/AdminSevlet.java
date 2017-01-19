package com.psl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psl.dao.Helper;
import com.psl.model.UserBean;

@WebServlet("/admin")
public class AdminSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<UserBean> users = Helper.displayUser();
		request.setAttribute("UserList", users);
		System.out.println("In Admin Servlet");
		request.getRequestDispatcher("DisplayUser.jsp").forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
