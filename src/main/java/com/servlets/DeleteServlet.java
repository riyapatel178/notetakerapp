package com.servlets;

import java.io.IOException;

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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		try {
			int noteId = Integer.parseInt(request.getParameter("note_id").trim());
			FactoryProvider factory = new FactoryProvider();
			 Session session = factory.getFactory().openSession();
			 Transaction ts = session.beginTransaction();
			Note note = session.get(Note.class, noteId);
			session.delete(note);
			ts.commit();
			session.close();
			 RequestDispatcher rd = request.getRequestDispatcher("Allnotes.jsp"); 
			  rd.include(request, response);
			 response.setContentType("text/html");
			 response.getWriter().println("<h1>Notes deleted successfully.</h1>");
		}catch(Exception e) {
			
		}
		
		
}
}
