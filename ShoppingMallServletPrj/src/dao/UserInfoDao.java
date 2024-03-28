package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.UserInfoDto;
import utils.DBConnect;

import java.sql.Connection;

public class UserInfoDao {

	// SQL 쿼리: 특정 고객 정보 조회
	public final static String customerSql = 
			"SELECT id, name, addr FROM customer WHERE id = ?";

	// SQL 쿼리: 모든 고객 정보 조회
	public final static String customerListSql =
			"SELECT id, name, addr FROM customer";


	/**
	 * 특정 고객 ID를 기반으로 고객 정보 조회
	 * xxxxxxxxxxxxxxxxxxxxxx
	 * @param id
	 * @return
	 */
	public ArrayList<UserInfoDto> selectCustomer(String id) {

		PreparedStatement pstmt =  null;	//SQL문을 데이터베이스에 전송하기 위한 객체
		ResultSet rs = null;				//SQL 쿼리 실행 결과 객체
		Connection conn = DBConnect.getConnection();

		UserInfoDto customerInfoDto = null;
		ArrayList<UserInfoDto> customerInfoDtos = new ArrayList<UserInfoDto>();

		try {
			pstmt = conn.prepareStatement(customerSql); 
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				customerInfoDto = new UserInfoDto(); 		 
				customerInfoDto.setId(rs.getString("id"));
				customerInfoDto.setName(rs.getString("name"));
				customerInfoDto.setAddr(rs.getString("addr"));
				customerInfoDtos.add(customerInfoDto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.closeConnection(conn);
		}
		return customerInfoDtos;
	}

    /**
     * 사용자의 아이디와 비밀번호를 기반으로 로그인 검증
     * @param id 사용자 아이디
     * @param password 사용자 비밀번호
     * @return 로그인이 성공한 사용자의 정보 또는 null
     */
	public UserInfoDto validateUser(String id, String password) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Connection conn = DBConnect.getConnection();

	    try {
	        
	        String validateSql = "SELECT id, pw, cname, caddr FROM customer WHERE id = ? AND pw = ?";
	        pstmt = conn.prepareStatement(validateSql);
	        pstmt.setString(1, id);
	        pstmt.setString(2, password); 
	        rs = pstmt.executeQuery();

	        if(rs.next()) {
	            UserInfoDto userInfoDto = new UserInfoDto();
	            userInfoDto.setId(rs.getString("id"));
	            userInfoDto.setPasswd(rs.getString("pw")); 
	            userInfoDto.setName(rs.getString("cname"));
	            userInfoDto.setAddr(rs.getString("caddr"));
	            return userInfoDto; // 로그인 성공, 사용자 정보 반환
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBConnect.closeConnection(conn);
	    }
	    return null; // 로그인 실패 시 null 반환
	}




	/**
	 * 모든 고객 정보 조회 
	 * @return
	 */
	public ArrayList<UserInfoDto> selectCustomerList() {

		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		Connection conn = DBConnect.getConnection();

		UserInfoDto customerInfoDto = null;
		ArrayList<UserInfoDto> customerInfoDtos 
		= new ArrayList<UserInfoDto>();

		try {
			pstmt = conn.prepareStatement(customerSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				customerInfoDto = new UserInfoDto();
				customerInfoDto.setId(rs.getString("id"));
				customerInfoDto.setName(rs.getString("name"));
				customerInfoDto.setAddr(rs.getString("addr"));
				customerInfoDtos.add(customerInfoDto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			DBConnect.closeConnection(conn);
		}

		return customerInfoDtos;
	}
}
