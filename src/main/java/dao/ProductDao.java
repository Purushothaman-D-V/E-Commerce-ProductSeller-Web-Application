package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.ProductDto;

public class ProductDao 
{
	public Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/productseller?user=root&password=toor");
	}
	
	public int saveProduct(ProductDto product) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
		pst.setInt(1, product.getId());
		pst.setString(2, product.getName());
		pst.setDouble(3, product.getPrice());
		pst.setString(4, product.getBrand());
		pst.setDouble(5, product.getDiscount());
		
		Blob image = new SerialBlob(product.getImage());
		pst.setBlob(6, image);
		
		return pst.executeUpdate();
	}
	
	public int updateProduct(ProductDto product) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("update product set name=?, price=?, brand=?, discount=?, image=? where id=?");
		pst.setString(1, product.getName());
		pst.setDouble(2, product.getPrice());
		pst.setString(3, product.getBrand());
		pst.setDouble(4, product.getDiscount());
		
		Blob image = new SerialBlob(product.getImage());
		pst.setBlob(5, image);
		
		pst.setInt(6, product.getId());
		
		return pst.executeUpdate();
		
	}
	
	public ProductDto findById(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from product where id = ?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		ProductDto product = new ProductDto();
		product.setId(rs.getInt(1));
		product.setName(rs.getString(2));
		product.setPrice(rs.getDouble(3));
		product.setBrand(rs.getString(4));
		product.setDiscount(rs.getDouble(5));
		
		Blob myblob = rs.getBlob(6);
		int myblobLength = (int)myblob.length();
		byte[] myblobAsBytes = myblob.getBytes(1, myblobLength);
		product.setImage(myblobAsBytes);
		
		return product;
	}
	
	public int deleteById(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("delete from product where id = ?");
		pst.setInt(1, id);
		int result = pst.executeUpdate();
		return result;
	}
	
	public List<ProductDto> findAll() throws SQLException, ClassNotFoundException
	{
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from product");
		ResultSet rs = pst.executeQuery();
		List<ProductDto> products = new ArrayList<ProductDto>();
		while(rs.next())
		{
			ProductDto product = new ProductDto();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getDouble(3));
			product.setBrand(rs.getString(4));
			product.setDiscount(rs.getDouble(5));
			
			Blob myblob = rs.getBlob(6);
			int myblobLength = (int)myblob.length();
			byte[] myblobAsBytes = myblob.getBytes(1, myblobLength);
			product.setImage(myblobAsBytes);
			
			products.add(product);
		}
		
		
		return products;
		
	}

}
