import java.sql.*;

public class DBConnection {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance(); //메모리를 올리는 작업, jdbc할 떄 무조건 있어야 함
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/play","root","mirim2"); //서버 주소 
			//7,8번 줄은 항상 있어야 함!!!
			System.out.println("Sussess");
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ex);
		}catch(Exception ex) {
			System.out.println("Exception: "+ex );
		}finally {
			if(con != null)
				try { con.close();
				}catch(SQLException sqle) {}
		}
	}
}