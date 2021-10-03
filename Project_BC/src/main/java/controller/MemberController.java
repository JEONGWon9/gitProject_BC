package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;


@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/Member.me")) {
			// 글쓰기 작업을 위한 뷰페이지로 포워딩
			forward = new ActionForward();
			forward.setPath("/member/member_join_form.jsp");
			forward.setRedirect(false); // Dispatcher 방식(기본값이므로 생략 가능)
		}
		
		
		if(forward != null) {
			// 2. ActionForward 객체 내의 isRedirect 값이 true(= Redirect 방식) 인지 판별
			if(forward.isRedirect()) { // true = Redirect 방식
				// response 객체의 sendRedirect() 메서드를 호출하여 Redirect 방식 포워딩
				// => 파라미터 : ActionForward 객체의 포워딩 경로(path)
				response.sendRedirect(forward.getPath());
			} else { // false = Dispatcher 방식
				// request 객체의 getRequestDispatcher() 메서드를 호출하여 포워딩 경로 설정
				// => 파라미터 : ActionForward 객체의 포워딩 경로(path)
				//    리턴타입 : RequestDispatcher
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				// RequestDispatcher 객체의 forward() 메서드를 호출하여 포워딩 작업 수행
				// => 파라미터 : request, response 객체
				dispatcher.forward(request, response);
			}
		}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
