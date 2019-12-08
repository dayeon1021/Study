import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class StudentInsert {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.print("추가할 이름을 입력하세요 : "); String name=sc.next();
		System.out.print("추가할 학과을 입력하세요 : "); String dept=sc.next();
		System.out.print("추가할 학번을 입력하세요 : "); String id=sc.next();
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance(); //메모리를 올리는 작업, jdbc할 떄 무조건 있어야 함
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/play","root","mirim2"); //서버 주소 
			System.out.println("DB연결 완료");
			String sql = "insert into student (name,dept,id) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,dept);
			pstmt.setString(3,id);
			pstmt.executeUpdate();	
			
			sql="Select * from student";
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
