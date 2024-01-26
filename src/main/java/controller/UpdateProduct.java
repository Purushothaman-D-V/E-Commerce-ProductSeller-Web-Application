package controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import dao.ProductDao;
import dto.ProductDto;

@WebServlet("/updateproduct")
@MultipartConfig
public class UpdateProduct extends HttpServlet
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
		if(part.getSize()<1)
		{
			ProductDao prod = new ProductDao();
			try {
				ProductDto p = prod.findById(id);
				image = p.getImage();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		ProductDto productdto = new ProductDto();
		productdto.setId(id);
		productdto.setName(name);
		productdto.setPrice(price);
		productdto.setBrand(brand);
		productdto.setDiscount(discount);
		productdto.setImage(image);
		ProductDao productdao = new ProductDao();
		try {
			productdao.updateProduct(productdto);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
		dispatcher.include(req, resp);
		
		
		//
		/*try 
		{
			
			if(part.getSize()<1)
			{
				ProductDto productdto1 = productdao.findById(id);
				byte[] image1 = productdto1.getImage();
				
				Blob image2 = new SerialBlob(image1);
				productdto.setImage(image2.getBytes(1, (int)image2.length()));
				
				productdao.updateProduct(productdto);
				RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				productdao.updateProduct(productdto);
				RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
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
		}*/
	}
	
	
}
