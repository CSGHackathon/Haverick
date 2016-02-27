package com.haverick.portal;

import java.awt.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.haverick.util.Channel;


@WebServlet("/Viewable")
public class Viewable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Viewable() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RoviCtrl rovi= new RoviCtrl();
		//List channels=(List) rovi.getChannels();
		if(request.getParameter("viewableId")!=null){
			//lookup viewable object and forward to viewable view
		}
		else if(request.getParameter("networkId")!=null){
			//lookup network viewables, New, reccomended, and limited time
		}
		else{
			//lookup homepage video's and redirect to dashboard
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
