import java.sql.*;

public class DBConnection {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance(); //�޸𸮸� �ø��� �۾�, jdbc�� �� ������ �־�� ��
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/play","root","mirim2"); //���� �ּ� 
			//7,8�� ���� �׻� �־�� ��!!!
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