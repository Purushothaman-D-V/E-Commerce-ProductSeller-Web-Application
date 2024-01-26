package dto;

public class SellerDto 
{
	private int id;
	private String name;
	private long contact;
	private String email;
	private String password;
	
	public int getId() 
	{
		return id;
	}
	public String getName() 
	{
		return name;
	}
	public long getContact() 
	{
		return contact;
	}
	public String getEmail() 
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
	
	
	public void setId(int id) 
	{
		this.id = id;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setContact(long contact) 
	{
		this.contact = contact;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
