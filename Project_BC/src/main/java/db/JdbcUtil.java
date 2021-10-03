package db;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

///DB관련 작업을 수행하는 JdbcUtil 클래스 정의
// = > DB 연결 해제 commit rollback 작업 수행.

public class JdbcUtil {
	// DB연결 작업을 수행하는 getConnection 메서드 정의

	public static Connection getconnConnection() {
		// context.xml 에 섲ㄹ정된 DBCP 커넥션풀 로부터 Connection 객체를 가져와 리턴.

		Connection con = null;
		try {
			Context initCtx = new InitialContext();// 톰캣으로부터 컨텍스트 객체 가져오기.
			// context.xml 내의 Resource 태그에 정의된 jdbc/MySQL 커넥션풀 가져오기
			DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/MySQL");
			// 가져온 커넥션풀로부터 Connection객체 1개 가져오기
			con = ds.getConnection();

			// 데이터베이스 작업단위 (트랜젝션Tranjaction)에 대한 처리 시키
			// Commint 기능과 Rollback 기능을 수동으로 동작하기 위해
			// MySQL 의 Auto Commit 기능을 해제해야함..!(기본값은 오토커밋)
			// =>Connetcion 객체의 setAutoCommit() 메서드를 호출하여 false값 전달.

			con.setAutoCommit(false);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}

	// ㅇDB자원 반환을 위한close 메서드 정의.
	//=>하나의 메서드명으로 서로다른 파라미터를 전달받기위해 오버로딩을 활용하여 메서드 정의.
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Auto commit 기능을 해제 했으므로
	//별도로 Commit, Rollback 작업을 수행할 메서드 정의.
	//=>파라미터 :Connection객체(commit(),rollback()메서드 정의)
	public static void commit(Connection con) {
		
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	public static void rollback(Connection con) {
		
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
