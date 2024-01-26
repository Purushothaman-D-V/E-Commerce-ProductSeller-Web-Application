package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDao;
import dao.SellerDao;
import dto.ProductDto;

@WebServlet("/addproduct")
@MultipartConfig
public class AddProduct extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double price = Double.parseDouble(req.getParameter("price"));
		String brand = req.getParameter("brand");
		double discount = Double.parseDouble(req.getParameter("discount"));
		
		Part part = req.getPart("file");
		byte[] image = part.getInputStream().readAllBytes();
		
		ProductDto productdto = new ProductDto();
		productdto.setId(id);
		productdto.setName(name);
		productdto.setPrice(price);
		productdto.setBrand(brand);
		productdto.setDiscount(discount);
		productdto.setImage(image);
		
		ProductDao productdao = new ProductDao();
		try 
		{
			int result = productdao.saveProduct(productdto);
			if(result == 1)
			{
				//req.setAttribute("products", productdao.findAll());
				RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "Data Save Failed");
				RequestDispatcher dispatcher = req.getRequestDispatcher("AddProduct.jsp");
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
