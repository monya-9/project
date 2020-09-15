package member;

public class Member2VO {
	private String member_no;
	private String member_id;
	private String member_pw;
	private String nickname;
	private String member_tel;
	private String member_email;
	private String signup_date;
	private String ticket_date;
	private String last_access_date;
	private String gender;
	private String ticket_code;
	

	public Member2VO() {

	}

	@Override
	public String toString() {
		return "MemberVO [member_no=" + member_no + ", member_id=" + member_id + ", member_pw=" + member_pw
				+ ", nickname=" + nickname + ", member_tel=" + member_tel + ", member_email=" + member_email
				+ ", signup_date=" + signup_date + ", ticket_date=" + ticket_date + ", last_access_date="
				+ last_access_date + ", gender=" + gender + ", ticket_code=" + ticket_code + "]";
	}


	public Member2VO(String member_no, String member_id, String member_pw, String nickname, String member_tel,
			String member_email, String signup_date, String ticket_date, String last_access_date, String gender,
			String ticket_code) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.nickname = nickname;
		this.member_tel = member_tel;
		this.member_email = member_email;
		this.signup_date = signup_date;
		this.ticket_date = ticket_date;
		this.last_access_date = last_access_date;
		this.gender = gender;
		this.ticket_code = ticket_code;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMember_tel() {
		return member_tel;
	}

	public void setMember_tel(String member_tel) {
		this.member_tel = member_tel;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(String signup_date) {
		this.signup_date = signup_date;
	}

	public String getTicket_date() {
		return ticket_date;
	}

	public void setTicket_date(String ticket_date) {
		this.ticket_date = ticket_date;
	}

	public String getLast_access_date() {
		return last_access_date;
	}

	public void setLast_access_date(String last_access_date) {
		this.last_access_date = last_access_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTicket_code() {
		return ticket_code;
	}

	public void setTicket_code(String ticket_code) {
		this.ticket_code = ticket_code;
	}


	
	
}
