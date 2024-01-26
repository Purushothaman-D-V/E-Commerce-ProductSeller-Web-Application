package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SellerDao;
import dto.SellerDto;

@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		SellerDao sellerdao = new SellerDao();
		try 
		{
			SellerDto sellerdto = sellerdao.findByEmail(email);
			//if(email.equals(sellerdto.getEmail()) )
			if(sellerdto!=null )
			{
				if(password.equals(sellerdto.getPassword()))
				{
					HttpSession session = req.getSession();
					session.setAttribute("email", email);
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Incorrect Password!!!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
					dispatcher.include(req, resp);
				}
				
			}
			else
			{
				req.setAttribute("message", "Login Failed!!! Incorrect Email");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
				dispatcher.include(req, resp);
			}
			
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
