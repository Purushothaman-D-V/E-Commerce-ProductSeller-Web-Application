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

import dao.ProductDao;
import dto.ProductDto;

@WebServlet("/edit")
public class Edit extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		ProductDao productdao = new ProductDao();
		
		try 
		{
			HttpSession session = req.getSession();
			String email = (String)session.getAttribute("email");
			
			if(email!=null)
			{
				ProductDto productdto = productdao.findById(id);
				req.setAttribute("product", productdto);
				RequestDispatcher dispatcher = req.getRequestDispatcher("Edit.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "Login is Required");
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
