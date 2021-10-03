<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 전용 회원가입</title>
<script type="text/javascript"> 
	// 패스워드 규칙을 통과하는지 여부를 체크할 전역변수 선언
	var checkIdResult = false, checkPasswdResult = false;
	
	function checkId(id) {
		// 4-16자리 영문자,숫자 조합 유효성 검사
		var regex = /^[A-Za-z0-9_]{4,16}$/g;
		
		// 아이디 항목 우측의 DIV 태그에 대한 id 값을 지정하여 해당 태그 Element 가져오기
		var element = document.getElementById('checkIdResult'); // 태그 중 checkIdResult 에 해당하는 id 찾기
		
		if(regex.exec(id.value)) { // 입력받은 id 가져와서 정규표현식을 통해 유효성 검사 수행
			element.innerHTML = "사용 가능한 아이디";
			checkIdResult = true;
		} else {
			element.innerHTML = "사용 불가능한 아이디";
			checkIdResult = false;
		}
		
	}
	
	// 패스워드 입력값 검증
	function checkPasswd(passwd) {
		// 8 ~ 20자리 영문자, 숫자, 특수문자(!@#$%) 사용 가능
		var lengthRegex = /^[A-Za-z0-9!@#$%]{8,20}$/;
		var engUpperCaseRegex = /[A-Z]/;
		var engLowerCaseRegex = /[a-z]/; 
		var digitRegex = /[0-9]/;
		var specRegex = /[!@#$%]/;
		
		// 패스워드 검증 결과 출력할 요소의 id 가져오기
		var element = document.getElementById('checkPasswdResult');
		
		// 패스워드 구성요소에 대한 길이 및 종류 전체 규칙 체크
		if(lengthRegex.exec(passwd.value)) {
			var safetyCount = 0; // 정수값을 저장하여 요소별 체크마다 1씩 증가시킴
			
			if(engUpperCaseRegex.exec(passwd.value)) safetyCount++;
			if(engLowerCaseRegex.exec(passwd.value)) safetyCount++;
			if(digitRegex.exec(passwd.value)) safetyCount++;
			if(specRegex.exec(passwd.value)) safetyCount++;
			
			switch(safetyCount) {
				case 4 : 
					element.innerHTML = '안전';
					element.style.color = 'green';
					checkPasswdResult = true;
					break;
				case 3 : 
					element.innerHTML = '보통';
					element.style.color = 'blue';
					checkPasswdResult = true;
					break;
				case 2 : 
					element.innerHTML = '위험';
					element.style.color = 'orange';
					checkPasswdResult = true;
					break;
				default :
					element.innerHTML = '사용불가';
					element.style.color = 'red';
					checkPasswdResult = false;
			}
			
		} else {
			element.innerHTML = '8~16자리 영문자,숫자,특수문자 조합 필수!';
			element.style.color = 'red';
			checkPasswdResult = false;
		}
		
	}
	
	// 회원가입 폼 체크
	function checkSubmit() {
		// 아이디와 패스워드 유효성 검사가 완료되었을 경우에만 회원가입(submit) 수행
		// => 아이디, 패스워드를 별도로 검사 수행이 된 상태이므로
		//    검사 결과가 저장된 전역변수를 사용하여 결과 확인
		if(checkIdResult == false) { // 아이디 유효성 검사 실패 시
				alert('아이디 규칙 확인 필요');
				document.joinForm.id.focus();
				return false;
		} else if(checkPasswdResult == false) { // 패스워드 유효성 검사 실패 시
				alert('패스워드 규칙 확인 필요');
				document.joinForm.passwd.focus();
				return false;
		}
		return true;
	}
	
	function changeDomain(domain) {
		document.joinForm.email2.value = domain.value;
	}
</script>
<style type="text/css">
	body {
		width: 600px;
		margin: auto;
	}
	
	h1 {
		width: 400px;
		text-align: center;
	}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<form action="" method="post" name="joinForm" onsubmit="return checkSubmit()">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="id" required="required" size="20" 
						placeholder="4-16자리 영문자,숫자 조합" onkeyup="checkId(this)">
					<span id="checkIdResult"><!-- 자바스크립트에 의해 메세지가 표시될 공간 --></span>
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<input type="password" name="passwd" required="required" size="20" 
						placeholder="8-20자리 영문자,숫자,특수문자 조합" onkeyup="checkPasswd(this)">
					<span id="checkPasswdResult"><!-- 자바스크립트에 의해 메세지가 표시될 공간 --></span>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required" size="20"></td>
			</tr>
			
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" required="required" size="10" inputmode="numeric"></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td>
					<input type="text" name="email1" required="required" size="10">@
					<input type="text" name="email2" required="required" size="10">
					<select name="selectDomain" onchange="changeDomain(this)">
						<option value="">직접입력</option>	
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="회원가입">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>