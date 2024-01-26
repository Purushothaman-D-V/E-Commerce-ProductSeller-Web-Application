package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SellerDao;
import dto.SellerDto;

@WebServlet("/signup")
public class SignUp extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long contact = Long.parseLong(req.getParameter("contact"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		SellerDto sellerdto = new SellerDto();
		sellerdto.setId(id);
		sellerdto.setName(name);
		sellerdto.setContact(contact);
		sellerdto.setEmail(email);
		sellerdto.setPassword(password);
		
		SellerDao sellerdao = new SellerDao();
		try 
		{
			int result = sellerdao.saveSeller(sellerdto);
			if(result == 1)
			{
				req.setAttribute("message", "SignUp Successful");
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "SignUp Failed");
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
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
