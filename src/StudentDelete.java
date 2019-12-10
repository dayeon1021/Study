package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDelete {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.print("삭제할 학번을 입력하세요 : "); String id=sc.next();

		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance(); //메모리를 올리는 작업, jdbc할 떄 무조건 있어야 함
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javap","root","mirim2"); //서버 주소 
			System.out.println("DB연결 완료");
			String sql = "delete from student where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);	
			pstmt.executeUpdate();	
			
			sql="Select * from student";
			//쿼리문이 나오면 prepareStatement문을 생성해주어야 한다.!!
			pstmt = conn.prepareStatement(sql);
			ResultSet srs = pstmt.executeQuery();
			System.out.println("NAME   DEPT     ID");
			while(srs.next()) {  //next는 하나 하나 위치를 바꿔주는 것이다!!!
				System.out.print(srs.getString("name")+"     ");
				System.out.print(srs.getString("dept")+"     ");
				System.out.print(srs.getString("id")+"     ");
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
