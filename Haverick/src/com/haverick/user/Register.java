package com.haverick.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterAction")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
    	super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*TODO check if user exists, create if not, than log user in and redirect to index*/
		System.out.println("Info: Register Action hit.");
		
		/*Logs the user in using the info from the form*/
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/LoginAction");    
		rd.include(request, response);
		response.sendRedirect(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
