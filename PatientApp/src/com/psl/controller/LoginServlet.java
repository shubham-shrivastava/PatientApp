package com.psl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.psl.dao.Helper;
import com.psl.model.Facility;
import com.psl.model.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = new UserBean();		   
	    user.setEmail(request.getParameter("email"));
	    user.setPassword(request.getParameter("password"));
	    HttpSession session = request.getSession();
	    UserBean bean = Helper.login(user);
	    
	    if(bean.isValid()){
	    	
	    	
	    	if(bean.getRole().equals("Admin")){
	    		session.setAttribute("User", bean);
	    		System.out.println("Successfully Logged in and role(If): "+bean.getRole());
	    		request.getRequestDispatcher("admin").include(request, response);
	    	}
	    	for(Facility facility : bean.getFacilities()){
	    		System.out.println(facility.getName());
	    	}
	    }
	    else{
	    	System.out.println("Wrong");
	    }
	}

}
