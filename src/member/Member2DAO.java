package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.ConnectionManager;

public class Member2DAO {
	// 전역변수. 모든 메서드에 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;

	// 싱글톤(하나 만들어두면 불러와서 계속씀)
	static Member2DAO instance;

	public static Member2DAO getinstance() {
		if (instance == null)
			instance = new Member2DAO();
		return instance;
	}

	// 전체조회
	public ArrayList<Member2VO> selectAll(Member2VO memberVO) {
		Member2VO resultVo = null;
		ResultSet rs = null;
		ArrayList<Member2VO> list = new ArrayList<Member2VO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT MEMBER_NO, MEMBER_ID, MEMBER_PW, NICKNAME, MEMBER_TEL"
					+ " MEMBER_EMAIL, SIGNUP_DATE, TICKET_DATE, LAST_ACCESS_DATE, GENDER, TICKET_CODE"
					+ " FROM MEMBER2"
					+ " ORDER BY MEMBER_NO";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultVo = new Member2VO();
				resultVo.setMember_no(rs.getString("MEMBER_NO"));
				resultVo.setMember_id(rs.getString("MEMBER_ID"));
				resultVo.setMember_pw(rs.getString("MEMBER_PW"));
				resultVo.setNickname(rs.getString("NICKNAME"));
				resultVo.setMember_tel(rs.getString("MEMBER_TEL"));
				resultVo.setMember_email(rs.getString("MEMBER_EMAIL"));
				resultVo.setSignup_date(rs.getString("SIGNUP_DATE"));
				resultVo.setTicket_date(rs.getString("TICKET_DATE"));
				resultVo.setLast_access_date(rs.getString("LAST_ACCESS_DATE"));
				resultVo.setGender(rs.getString("GENDER"));
				resultVo.setTicket_code(rs.getString("TICKET_CODE"));
				list.add(resultVo);
				System.out.println(rs.getString("MEMBER_NO"));
				System.out.println(rs.getString("NICKNAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
	}

	// 단건조회
	public Member2VO selectOne(Member2VO memberVO) {
		Member2VO resultVo = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT MEMBER_NO, MEMBER_ID, MEMBER_PW, NICKNAME, MEMBER_TEL"
					+ "  MEMBER_EMAIL, SIGNUP_DATE, TICKET_DATE, LAST_ACCESS_DATE, GENDER, TICKET_CODE"
					+ " FROM MEMBER2"
					+ " WHERE NICKNAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getNickname());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resultVo.setMember_no(rs.getString("MEMBER_NO"));
				resultVo.setMember_id(rs.getString("MEMBER_ID"));
				resultVo.setMember_pw(rs.getString("MEMBER_PW"));
				resultVo.setNickname(rs.getString("NICKNAME"));
				resultVo.setMember_tel(rs.getString("MEMBER_TEL"));
				resultVo.setMember_email(rs.getString("MEMBER_EMAIL"));
				resultVo.setSignup_date(rs.getString("SIGNUP_DATE"));
				resultVo.setTicket_date(rs.getString("TICKET_DATE"));
				resultVo.setLast_access_date(rs.getString("LAST_ACCESS_DATE"));
				resultVo.setGender(rs.getString("GENDER"));
				resultVo.setTicket_code(rs.getString("TICKET_CODE"));
			} else {
				System.out.println("no data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVo;
	}

	public void delete(Member2VO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete member2 where nickname= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getNickname());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void update(Member2VO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update nickname = ? where member_id= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getMember_pw());
			pstmt.setString(2, memberVO.getMember_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 수정됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}

	public void insert(Member2VO memberVO) {
		Member2VO resultVo = null;
		ResultSet rs = null;
		try {

			// 1.DB연결
			conn = ConnectionManager.getConnnect();
			// 2.sql 구문실행
			String sql = "insert into member2 (member_no, member_id, member_pw, nickname, member_tel, member_email,signup_date, ticket_date, last_access_date, gender, ticket_code)"
					+ "values(no_seq, ?,?,?,?,?,sysdate,?,?,?,?)";
			resultVo = new Member2VO();
			resultVo = new Member2VO();
			resultVo.setMember_no(rs.getString("MEMBER_NO"));
			resultVo.setMember_id(rs.getString("MEMBER_ID"));
			resultVo.setMember_pw(rs.getString("MEMBER_PW"));
			resultVo.setNickname(rs.getString("NICKNAME"));
			resultVo.setMember_tel(rs.getString("MEMBER_TEL"));
			resultVo.setMember_email(rs.getString("MEMBER_EMAIL"));
			resultVo.setSignup_date(rs.getString("SIGNUP_DATE"));
			resultVo.setTicket_date(rs.getString("TICKET_DATE"));
			resultVo.setLast_access_date(rs.getString("LAST_ACCESS_DATE"));
			resultVo.setGender(rs.getString("GENDER"));
			resultVo.setTicket_code(rs.getString("TICKET_CODE"));
			int r = pstmt.executeUpdate();

			// 3.결과처리
			System.out.println(r + " 건이 처리됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 4.연결해제
			ConnectionManager.close(conn);
		}
	}

	//
	// 메일수신회원수 : select count(id) from member where mailyn='y'
	public int getMailynCnt() {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select count(member_id) from member2 where member_email='y'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return cnt;
	}

	// 성별인원수 : select gender, count(id) cnt from member group by gender
	public List<HashMap<String, Object>> getGenderCnt() {
		int cnt = 0;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select gender, count(member_id) cnt from member2 group by gender";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("gender", rs.getString("gender"));
				map.put("cnt", rs.getInt("cnt"));
			}
			cnt = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return list;
	}

}
