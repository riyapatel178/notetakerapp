package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.provider.FactoryProvider;

@WebServlet("/Addnote")
public class AddnotesServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String NoteTitle = request.getParameter("title");
		 String Content = request.getParameter("content");
		 
		 Note note1 = new Note(NoteTitle, Content, new Date());
		 
		// hibernate save
		 
		 FactoryProvider factory = new FactoryProvider();
		 Session session = factory.getFactory().openSession();
		 session.save(note1);
		 Transaction ts = session.beginTransaction();
		 
		 ts.commit();
		 session.close();
		 RequestDispatcher rd = request.getRequestDispatcher("Add_notes.jsp"); 
		  rd.include(request, response);
		 response.setContentType("text/html");
		 response.getWriter().println("<h1>Notes added successfully.</h1>");
		 
		 
	}

}
