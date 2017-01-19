package com.psl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.psl.dao.Helper;
import com.psl.model.Facility;
import com.psl.model.UserBean;

@WebServlet("/register.do")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
	    String lastName =request.getParameter("lastName");
	    String email=request.getParameter("email");
	    String[] facilityarray=request.getParameterValues("FacilityName");
	    String role = request.getParameter("role");
	    System.out.println(role);
	    String status=request.getParameter("activation");
	    String password = firstName+"_"+lastName;
	    boolean first = true;
	    
	    
	    List<Facility> facilities = Helper.displayFacility();
	    List<Facility> toBeAdded = new ArrayList<>();
	    Iterator<Facility> iterator = facilities.iterator();
	    for(String f : facilityarray){
	    	System.out.println("Facility String "+f);
	    	for(Facility facility2 : facilities){
	    		if(f.equals(facility2.getName())){
	    			System.out.println("Facility: "+facility2.getName());
	    			toBeAdded.add(facility2);
	    		}
	    	}
	    
	    UserBean userBean = new UserBean(firstName, lastName, email, password, toBeAdded, true, role, status, first);
	    
	    
	    Helper.saveData(userBean);
	    response.setStatus(307); //this makes the redirection keep your requesting method as is.
	    response.addHeader("Location", "admin");
	    //request.getRequestDispatcher("/admin").include(request, response);
	    
	    }

}
}