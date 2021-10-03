package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberBean;

public class MemberJoinProService {

	public boolean joinMember(MemberBean member) {
		
		boolean isJoinSuccess = false;
		
		Connection con = getConnection();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		dao.setConnection(con);
		
		int insertCount = dao.insertMember(member);
		
		if(insertCount > 0) { // 작업 성공 시
//			JdbcUtil.commit(con);
			commit(con);
			isJoinSuccess = true;
		} else { // 작업 실패 시
//			JdbcUtil.rollback(con);
			rollback(con);
		}
		close(con);
		
		return isJoinSuccess;
	}



}
