package vo;
/*
   CREATE TABLE member_BC (
         member_id VARCHAR(16) NOT NULL PRIMARY_KEY,
         member_pass VARCHAR(20) NOT NULL
         member_name VARCHAR(12) NOT NULL,
         member_phone VARCHAR(13) NOT NULL,
         member_email VARCHAR(50) NOT NULL UNIQUE,
         member_recommendID INT(20) NOT NULL UNIQUE,
         member_personalData VARCHAR(1) NOT NULL,
         member_grand INT(4) NOT NULL
   );
 */
public class MemberBean {
	private String member_id;
	private String member_pass;
	private String member_name;
	private String member_phone;
	private String member_email;
	private int member_recommendID;
	private String member_personalData;
	private int member_grand;
	
	
	public MemberBean() {}


	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getMember_pass() {
		return member_pass;
	}


	public void setMember_pass(String member_pass) {
		this.member_pass = member_pass;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public String getMember_phone() {
		return member_phone;
	}


	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}


	public String getMember_email() {
		return member_email;
	}


	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}


	public int getMember_recommendID() {
		return member_recommendID;
	}


	public void setMember_recommendID(int member_recommendID) {
		this.member_recommendID = member_recommendID;
	}


	public String getMember_personalData() {
		return member_personalData;
	}


	public void setMember_personalData(String member_personalData) {
		this.member_personalData = member_personalData;
	}


	public int getMember_grand() {
		return member_grand;
	}


	public void setMember_grand(int member_grand) {
		this.member_grand = member_grand;
	}


	@Override
	public String toString() {
		return "MemberBean [member_id=" + member_id + ", member_pass=" + member_pass + ", member_name=" + member_name
				+ ", member_phone=" + member_phone + ", member_email=" + member_email + ", member_recommendID="
				+ member_recommendID + ", member_personalData=" + member_personalData + ", member_grand=" + member_grand + "]";
	}
	
	
}
















