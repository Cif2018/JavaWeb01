package com.test;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Login
 */
//@WebServlet(urlPatterns = { "/login.do", "*.do","/"}, initParams = WebInitParam(name="ProductName", value="WelcomeApp")) <- not working
@WebServlet(urlPatterns = { "/Login2.do","/login.do","/"}) //, "*.do" 
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static String pathLocation="C:\\Users\\user\\eclipse-workspace\\JavaWeb01\\WebContent\\WEB-INF\\DB\\";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
//		System.out.print("From constructor! ");
//		System.out.println(Calendar.getInstance().getTime());
//		System.out.printf()

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		PrintWriter out = response.getWriter();

//		out.println("Hi! I'm a Servlet");
//		out.println("name=" + request.getParameter("name"));
//		out.println("password=" + request.getParameter("passwd"));

//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		String strHost = request.getHeader("Host");
//		System.out.println(strHost);		
//		BufferedReader br=request.getReader();	
//		System.out.println(br.readLine());

		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String goBack = request.getParameter("goBack");

		try {
			if (goBack.equals(null)) {
				goBack = "initialStatus";
			}
		} catch (Exception e) {
			// TODO: handle exception
			goBack = "initialStatus";
		}

		System.out.println(goBack);

		boolean check = false;

		try {
			check = CheckCredentials.confirm(name, passwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(name);
		System.out.println(passwd);
		System.out.println(check);

//		boolean check=false;

		if (check && name.equals("admin") || goBack.equals("goBackAdmin")) {
			System.out.println("Go to Administrator Page");
			request.setAttribute("name", name);
			request.setAttribute("passwd", passwd);
			request.getRequestDispatcher("/WEB-INF/views/WelcomeAdmin.jsp").forward(request, response);
		} else if (check && !name.equals("admin") || goBack.equals("goBackUser")) {
			System.out.println("Go to Normal User Page");
			request.setAttribute("name", name);
			request.setAttribute("passwd", passwd);
			request.getRequestDispatcher("/WEB-INF/views/WelcomeNonAdmin.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "The credentials invalid, input them again!");
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		}
	}

}
