package jdbc;

import java.io.*;
import java.sql.*;
import java.util.Scanner;
//"updata student set dept ='JSSTUDT' where id = '2116987'"
public class StudentUpdate {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.print("������ �а��� �Է��ϼ��� : "); String dept=sc.next();
		System.out.print("������ �й��� �Է��ϼ��� : "); String id=sc.next();

		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance(); //�޸𸮸� �ø��� �۾�, jdbc�� �� ������ �־�� ��
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javap","root","mirim2"); //���� �ּ� 
			System.out.println("DB���� �Ϸ�");
			String sql = "update student set dept =? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dept);
			pstmt.setString(2,id);	
			pstmt.executeUpdate();	
			sql="Select * from student where id = '2116987'";
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			System.out.println("NAME   DEPT     ID");
			while(srs.next()) {
				System.out.print(srs.getString("name")+" ");
				System.out.print(srs.getString("dept")+" ");
				System.out.print(srs.getString("id")+" ");
				System.out.println();
			}
		}catch(SQLException ex) {
			System.out.println("SQLException : "+ex);
		}catch(Exception ex) {
			System.out.println("Exception : "+ex);
		}finally {
			if(conn != null)
				try { conn.close();
				}catch(SQLException sqle) {}
			if(pstmt != null)
				try {
					pstmt.close();
				}catch(SQLException sqle) {}
		}	
	}
}
