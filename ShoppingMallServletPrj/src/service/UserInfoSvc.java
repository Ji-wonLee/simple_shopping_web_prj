package service;

import java.util.ArrayList;

import dao.UserInfoDao;
import dto.UserInfoDto;

public class UserInfoSvc {

	private UserInfoDao userInfoDao = null;
	private UserInfoDto userInfoDto = null;
	private ArrayList<UserInfoDto> userInfoDtos = null;

	public UserInfoDto selectCustomer(String id) {
		userInfoDao = new UserInfoDao();
		userInfoDtos = userInfoDao.selectCustomer(id);
		userInfoDto = userInfoDtos.get(0);
		return userInfoDto;
	}

	public ArrayList<UserInfoDto> selectCustomerList() {
		userInfoDao = new UserInfoDao();
		userInfoDtos = userInfoDao.selectCustomerList();
		return userInfoDtos;
	}

	/**
	 * 사용자 로그인을 처리
	 * @param id 사용자 아이디
	 * @param password 사용자 비밀번호
	 * @return 로그인 성공 시 true, 실패 시 false 반환
	 */
	public boolean loginUser(String id, String password) {
		userInfoDao = new UserInfoDao();
		UserInfoDto userInfoDto = userInfoDao.validateUser(id, password);

		// userInfoDto가 null이 아니라면 로그인 성공
		return userInfoDto != null;
	}

}


