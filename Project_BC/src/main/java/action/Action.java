package action;

import javax.servlet.http.*;

import vo.*;

/*
 * XXXAction 클래스의 작업을 수행할 메서드 형식을 강제(통일)하기 위해 
 * 부모에 해당하는 Action 인터페이스를 정의하고
 * XXXAction 클래스에서 상속받아 구현할 메서드를 추상메서드형태로 제공.
 * 
 * 
 * =>메서드명: execute
 * =>파라미터 HTTPSERVELT
 * =>리턴 타입 ActionForward
 * =>예외발생시 모든 예외를 ㅁ외부로 던지기
 */

public interface Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	

}
