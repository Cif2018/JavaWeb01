package com.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandleOptions
 */
@WebServlet("/HandleOptions")
public class HandleOptions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HandleOptions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String option = request.getParameter("option");
//		System.out.println(option);
//		response.getWriter().append("You have selected: " + option);
		
	
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    response.setDateHeader("Expires", 0); // Proxies.


		switch (option) {
		case "ListUsers":
			System.out.println("ListUsers!");
			response.getWriter().append("You have selected: " + "ListUsers!");

			try {

				String[] theTableColumns = new String[2];
				theTableColumns[0] = "user";
				theTableColumns[1] = "password";

				ReadDataFromDB rdfdb = new ReadDataFromDB();
				ArrayList<String[]> data = rdfdb.read(Login.pathLocation, "usersDB", "usersAndPasswords",
						theTableColumns);
				for (String[] s : data) {
					System.out.print(s[0] + " ");
					System.out.println(s[1]);
				}

				request.setAttribute("data", data);
				request.getRequestDispatcher("/WEB-INF/views/ListUsers.jsp").forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("DB access problem!!!");
				e.printStackTrace();
			}

			break;
		case "addUser":
			System.out.println("addUser!");
			response.getWriter().append("You have selected: " + "addUser!");

			request.getRequestDispatcher("/WEB-INF/views/AddUser.jsp").forward(request, response);

			break;
		case "modifyUser":
			System.out.println("modifyUser!");
			response.getWriter().append("You have selected: " + "modifyUser!");
			break;
		case "checkTickets":
			System.out.println("checkTickets!");
			response.getWriter().append("You have selected: " + "checkTickets!");
			break;
		case "listNetworkElements":
			System.out.println("listNetworkElements!");
			response.getWriter().append("You have selected: " + "listNetworkElements!");
			break;
		case "dashboard":
			System.out.println("dashboard!");
			response.getWriter().append("You have selected: " + "dashboard!");
			break;

		default:
			System.out.println("Other...");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
