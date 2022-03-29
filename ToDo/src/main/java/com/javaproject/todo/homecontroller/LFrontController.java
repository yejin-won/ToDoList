package com.javaproject.todo.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.command.BWriteCommand;
import com.javaproject.todo.command.LCommand;
import com.javaproject.todo.command.LCreateCommand;

@WebServlet("*.do")
public class LFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LFrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actiondo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actiondo(request, response);
	}


	private void actiondo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		LCommand command = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		switch(com) {
		case("/create.do"):
			viewPage = "create.jsp";
			break;
		case("/create_list.do"):
			command = new LCreateCommand();
			command.execute(request, response);
			viewPage = "list.do"; 
		
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
