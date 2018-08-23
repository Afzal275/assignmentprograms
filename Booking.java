package com.virtusa;


import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Booking extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String warning ="";
	
	public boolean validate(String from,String to,String date,String phn,String email)
	{
		 warning ="";
		 String phn_pattern ="^[6-9]\\d{9}$";
		 String email_pattern = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
		boolean res=false,flag=true;
		if(from.equals(to)) {
			warning += "-FROM and TO can't be same";
			flag=false;
		}
		
		if(!phn.matches(phn_pattern))
			warning += "-Phn number is not proper";
		if(!email.matches(email_pattern))
			warning += "-Email is not proper";
		
		if(date!=null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			try {
				
				//if not valid, it will throw ParseException
				Date date1 = sdf.parse(date);
				Date today = sdf.parse(sdf.format(new Date()));
				
				
				if(date1.compareTo(today)<0)
				{
					warning += "-Date should be valid";
					flag=false;
				}
				
			
			} catch (ParseException e) {
				
				e.printStackTrace();
				warning += "-Give proper date";
				return false;
			}
		}
		
		
		if(flag)
			res = true;
		else
			res = false;
		
		return res;
			
	}
	
	public boolean insert(String from,String to,String date,String phn,String email,String name)
	{
		boolean flag=true;
		// JDBC driver name and database URL
		    String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
		    String DB_URL = "jdbc:mysql://localhost/virtusa";

		   //  Database credentials
		    String USER = "root";
		    String PASS = "";
		   
		   
		   Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "INSERT INTO `book`( `from_place`, `to_place`, `date`, `name`, `phn`, `email`) VALUES (?,?,?,?,?,?)";
		      PreparedStatement  preparedStatement = conn.prepareStatement(sql);
		      preparedStatement.setString(1, from);
			  preparedStatement.setString(2, to);
			  preparedStatement.setDate(3,  new java.sql.Date(new Date(date).getTime()));
			  preparedStatement.setString(4,name);
			  preparedStatement.setLong(5,Long.parseLong(phn.trim()));
			  preparedStatement.setString(6,email);
			 //System.out.println(preparedStatement.toString());
		      int rs = preparedStatement.executeUpdate();

		      if(rs!=1)
		    	  flag = false; 
		    
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		     
		      se.printStackTrace();
		      flag=false;
		   }catch(Exception e){
			   flag=false;
		      e.printStackTrace();
		   }
		   
		   finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		 
		return flag;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	       response.setContentType("text/html;charset=UTF-8");
	        //PrintWriter out = response.getWriter();
	        try {
	           
	            String from=request.getParameter("from");
	            String to=request.getParameter("to");
	            String date=request.getParameter("date");
	            String name=request.getParameter("name");
	            String phn=request.getParameter("phn");
	            String email=request.getParameter("email");
	            if(from!=null&to!=null&&date!=null&&name!=null&&phn!=null&&email!=null)
		          {
	            	if(validate(from,to,date,phn,email)&&insert(from,to,date,phn,email,name))
	            	{
		            	request.setAttribute("from",from);
		            	request.setAttribute("to",to);
		            	request.setAttribute("doj",date);
		            	request.setAttribute("name",name);
		            	request.setAttribute("phone_number",phn);
		            	request.setAttribute("mailid",email);
		            	
		            	request.getRequestDispatcher("ticket.jsp").forward(request, response); 
		            }
	            	else
	            	{
	            		request.setAttribute("warning",warning);
		            	request.getRequestDispatcher("index.jsp").forward(request, response);
	            		
	            	}
	            	
	            	
	            }
	            else
	            {
	            	
	            	warning = "-Please Fill All Details";
	            	request.setAttribute("warning",warning);
	            	request.getRequestDispatcher("index.jsp").forward(request, response); 
	            }
	           
	        } catch(Exception e) {            
	         
	        }
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            
    }
}
