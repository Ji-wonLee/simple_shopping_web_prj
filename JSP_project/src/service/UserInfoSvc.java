package service;

import java.util.ArrayList;

import dao.UserInfoDao;
import dto.UserInfoDto;

public class UserInfoSvc {

	private UserInfoDao userInfoDao = null;
	private UserInfoDto userInfoDto = null;
	private ArrayList<UserInfoDto> userInfoDtos = null;

	public UserInfoSvc() {
        this.userInfoDao = new UserInfoDao();
    }
	
	/**
	 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	 * @param id
	 * @return
	 */
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
     * @return 로그인 성공 시 사용자의 정보, 실패 시 null 반환
     */
    public UserInfoDto loginUser(String id, String password) {
        // UserInfoDao의 validateUser 메서드를 호출하여 사용자 인증 수행
        UserInfoDto userInfoDto = userInfoDao.validateUser(id, password);
        return userInfoDto; // 로그인 성공한 사용자 정보 또는 null 반환
    }

}


