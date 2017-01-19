package com.psl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psl.dao.Helper;
import com.psl.model.Facility;

/**
 * Servlet implementation class FacilityController
 */
@WebServlet("/facility.do")
public class FacilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacilityController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getSession().getAttribute("newFacility") != null){
    		  request.getSession().removeAttribute("newFacility");
			  String Name=request.getParameter("firstName");
		      String Address =request.getParameter("address");
		      String City=request.getParameter("city");
		      String State=request.getParameter("state");
		      String Zipcode = request.getParameter("zipcode");
		      Facility facility = new Facility();
		      facility.setName(Name);
		      facility.setAddress(Address);
		      facility.setCity(City);
		      facility.setState(State);
		      facility.setZip(Zipcode);
		      Helper.saveData(facility);
		      //List<Facility> facilities = Helper.displayFacility();
		      request.getRequestDispatcher("showFacility.jsp").forward(request, response);
		      
		}
		else{
			  request.getRequestDispatcher("showFacility.jsp").forward(request, response);
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
