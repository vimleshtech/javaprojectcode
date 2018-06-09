package dbexample;

import java.sql.Connection;	//establish the connection 
import java.sql.DriverManager; //register/load driver
import java.sql.ResultSet;   // container of select/result
import java.util.Scanner;
import java.sql.PreparedStatement; //execute sql command 


public class dbinteaction {

	public static void main(String[] args) {
		
		try
		{
		
			Scanner sc=new Scanner(System.in);
			
			int id ,price;
			String name;
			
			System.out.println("enter pid :" );
			id = sc.nextInt();
			
			System.out.println("enter pname " );
			name = sc.next();
			
			System.out.println("enter price " );
			price = sc.nextInt();
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","root");
			PreparedStatement st = con.prepareStatement("insert into product(pid,pname,price) values(?,?,?)");
			
			st.setInt(1, id);
			st.setString(2, name);
			st.setInt(3, price);
			
			
			st.executeUpdate(); //insert, update, delete
			
			System.out.println("data saved");
			
		
			//veiw data 
			st = con.prepareStatement("select * from product");
			ResultSet rs = st.executeQuery(); //select 
			
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));
			}
			
			
		}
		catch (Exception e) 
		{
			
		}

	}

}
