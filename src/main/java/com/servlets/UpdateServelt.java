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
@WebServlet("/Updatenote")
public class UpdateServelt extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		FactoryProvider factory = new FactoryProvider();
		 Session session = factory.getFactory().openSession();
		 Transaction ts = session.beginTransaction();
		 Note note = session.get(Note.class, noteId);
		 note.setTitle(title);
		 note.setContent(content);
		 note.setAddeddate(new Date());
		 session.save(note);
		 ts.commit();
		 session.close();
		 
		 RequestDispatcher rd = request.getRequestDispatcher("Allnotes.jsp"); 
		  rd.include(request, response);
		 response.setContentType("text/html");
		 response.getWriter().println("<h1>Notes updated successfully.</h1>");
		
	}catch(Exception e) {
		
	}
	}
}

