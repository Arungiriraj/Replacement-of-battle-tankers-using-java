package miniproject;
import java.util.Arrays;
import java.sql.*;
import java.util.*;
public class DBConnection{
	Connection con=null;
    void getConnection() throws Exception
	{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/military","root","Akshaya@013");
	}
    void Defectedupdate(int tankerID) throws Exception
    {
       Statement st=con.createStatement();
       PreparedStatement p;
       p=con.prepareStatement("update status set status='defected' where tankerID=?");  
       p.setInt(1,tankerID);  
       int res=p.executeUpdate();
    }
    void Repairedupdate(int tankerID) throws Exception
    {
       Statement st1=con.createStatement();
       PreparedStatement p;
       p=con.prepareStatement("update status set status='repaired' where tankerID=?");  
       p.setInt(1,tankerID);  
       int res=p.executeUpdate();
    }
    int specID_find(String type) throws Exception {
    	Statement st2=con.createStatement();
    	PreparedStatement p;
    	p=con.prepareStatement("select spec_id from specialist where spec_type=?");
    	p.setString(1,type);
    	int id=0;
    	ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			id=rs.getInt(1);
		}
		return id;
    }
    String specName_find(String type) throws Exception {
    	Statement st3=con.createStatement();
    	PreparedStatement p;
    	p=con.prepareStatement("select spec_id from specialist where spec_type=?");
    	p.setString(1,type);
    	String name=null;
    	ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			name=rs.getString(1);
		}
		return name;
    }
    void updateCondition(int tankerID)throws Exception {
    	Statement st3=con.createStatement();
        PreparedStatement p;
        p=con.prepareStatement("update status set status='good' where tankerID=?");  
        p.setInt(1,tankerID);  
        int res=p.executeUpdate();
    }
    void updateRectified(int tankerID)throws Exception {
    	Statement st4=con.createStatement();
        PreparedStatement p;
        p=con.prepareStatement("update status set status='good' where tankerID=?");  
        p.setInt(1,tankerID);  
        int res=p.executeUpdate();
    }
   
}
    	