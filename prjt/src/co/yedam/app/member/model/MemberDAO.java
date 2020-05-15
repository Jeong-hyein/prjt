package co.yedam.app.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import co.yedam.app.common.ConnectionManager;

public class MemberDAO {
	int r = 0;
	Connection conn = null;
	PreparedStatement psmt = null;
	
	public int memberInsert(MemberVO member) {

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into member (id, pwd, name, hobby, gender, religion, introduction, regdt)"
					+ " values ( ?, ?, ?, ?, ?, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getHobby());
			psmt.setString(5, member.getGender());
			psmt.setString(6, member.getReligion());
			psmt.setString(7, member.getIntroduction());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}

	//단건조회
	public MemberVO getMember(String id) {
		MemberVO vo = new MemberVO();
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			//1. DB 연결
			conn = ConnectionManager.getConnnect();
			//2. 쿼리 준비
			String sql = "select * from member where id = ?" ;
			psmt = conn.prepareStatement(sql);
			//3. statment 실행, 내가 넘겨주는 id값으로 찾을거임
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery(); //rs: 결과 집합.
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setHobby(rs.getString("hobby"));
				vo.setGender(rs.getString("gender"));
				vo.setReligion(rs.getString("religion"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setRegdt(rs.getString("regdt"));
			}
			//4. 결과 저정
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5.연결 해제
			ConnectionManager.close(conn);
		}	
		return vo;
	}
	
	//전체조회
	public ArrayList<MemberVO> getMemberList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			//1. DB 연결
			conn = ConnectionManager.getConnnect();
			//2. 쿼리 준비
			String sql = "select * from member order by id";
			psmt = conn.prepareStatement(sql);
			//3. statment 실행
			ResultSet rs = psmt.executeQuery(); //rs: 결과 집합.
			while(rs.next()) { //조회된 건수만큼 while 돈다.
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setHobby(rs.getString("hobby"));
				vo.setGender(rs.getString("gender"));
				vo.setReligion(rs.getString("religion"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setRegdt(rs.getString("regdt"));
				list.add(vo);
			}
			//4. 결과 저정
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//5.연결 해제
			ConnectionManager.close(conn);
		}		
		return list;
	}

	//수정
	public int memberUpdate(MemberVO member) {

		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update member set pwd=?, name =?"
							+ "hobby=?, gender=?, religion=?, "
							+ "introduction=?"
							+ "where id =? ";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getHobby());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getReligion());
			psmt.setString(6, member.getIntroduction());
			psmt.setString(7, member.getId());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}
	
	// 삭제
		public int memberDelete(MemberVO member) {
			int r = 0;
			try {
				// 1. DB 연결
				conn = ConnectionManager.getConnnect();
				// 2. sql구문 준비
				String sql = "delete member where id = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, member.getId());
				// 3. 실행
				r = psmt.executeUpdate();
				// 4. 결과처리
				System.out.println(r + " 건이 삭제됨.");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 5. 연결해제
				ConnectionManager.close(conn);
			}
			return r;
		}
}
