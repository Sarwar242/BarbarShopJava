package barbar_shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class connection_database {

	public static Connection getCon() throws SQLException {
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/barbardb","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static int insert(BarBarShop b){
		int status=0;
		try {
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into bshops(name,location,phone,haircut_p,shave_p) values(?,?,?,?,?)");
			ps.setString(1, b.getName());
			ps.setString(2, b.getLocation());
			ps.setString(3, b.getPhone());
			ps.setString(4, b.getHp());
			ps.setString(5, b.getSp());
			
			status=ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
		
	}
	
	public static int update(BarBarShop b){
		int status=0;
		try {
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("update bshops set haircut_p=?,shave_p=? where s_id=?");
			
			ps.setString(1, b.getHp());
			ps.setString(2, b.getSp());
			ps.setInt(3, b.getId());
			
			status=ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
		
	}
	
	public static int delete(int id){
	int status=0;
	try {
		Connection con=getCon();
		PreparedStatement ps=con.prepareStatement("delete from bshops where s_id=?");
		ps.setInt(1, id);
		status=ps.executeUpdate();
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	return status;
}
	
	public static List<BarBarShop> getAllShops(){
		List <BarBarShop> list=new ArrayList<BarBarShop>();
		try {
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from bshops");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BarBarShop b=new BarBarShop();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setLocation(rs.getString(3));
				b.setPhone(rs.getString(4));
				b.setHp(rs.getString(5));
				b.setSp(rs.getString(6));
		
				list.add(b);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	
}
