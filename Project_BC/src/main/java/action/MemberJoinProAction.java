package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberJoinProAction");
		
		ActionForward forward = null;
		
		MemberBean member = new MemberBean();
		member.setMember_id(request.getParameter("member_id"));
		member.setMember_pass(request.getParameter("member_pass"));
		member.setMember_name(request.getParameter("member_name"));
		member.setMember_phone(request.getParameter("member_phone1")+"-"+request.getParameter("member_phone2")+"-"+request.getParameter("member_phone3"));
		member.setMember_email(request.getParameter("email1")+"@"+request.getParameter("email2"));
		member.setMember_personalData(request.getParameter("member_personalData"));
		member.setMember_grand(Integer.parseInt(request.getParameter("member_grand")));
		
		MemberJoinProService service = new MemberJoinProService();
		boolean isJoinSuccess = service.joinMember(member);
		
		if(!isJoinSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원 가입 실패')");
			out.println("history.back()");
			out.println("</script>");
		}else {
			forward = new ActionForward();
			forward.setPath("MemberJoinResult.me");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
