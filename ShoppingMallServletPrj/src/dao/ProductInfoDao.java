package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ProductInfoDto; // 상품 정보를 담을 DTO
import utils.DBConnect;

import java.sql.Connection;

public class ProductInfoDao {
	// SQL 쿼리 상수: 특정 상품 정보 조회
	public final static String productSql = 
			"SELECT id, name, price FROM product WHERE id = ?";

	// SQL 쿼리 상수: 모든 상품 정보 조회
	public final static String productListSql =
			"SELECT id, name, price FROM item";

	/**
	 * 특정 상품 ID를 기반으로 상품 정보 조회
	 * @param id 상품 ID
	 * @return 조회된 상품 정보 목록
	 */
	public ArrayList<ProductInfoDto> selectProduct(String Proid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = DBConnect.getConnection();

		ProductInfoDto productInfoDto = null;
		ArrayList<ProductInfoDto> productInfoDtos = new ArrayList<ProductInfoDto>();

		try {
			pstmt = conn.prepareStatement(productSql);
			pstmt.setString(1, Proid);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				productInfoDto = new ProductInfoDto();
				productInfoDto.setProid(rs.getString("id"));
				productInfoDto.setProname(rs.getString("name"));
				productInfoDto.setPrice(rs.getDouble("price"));
				productInfoDtos.add(productInfoDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeConnection(conn);
		}
		return productInfoDtos;
	}

	/**
	 * 모든 상품 정보 조회
	 * @return 조회된 모든 상품 정보 목록
	 */
	public ArrayList<ProductInfoDto> selectProductList(String Proid) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = DBConnect.getConnection();

		ProductInfoDto productInfoDto = null;
		ArrayList<ProductInfoDto> productInfoDtos = new ArrayList<ProductInfoDto>();

		try {
			pstmt = conn.prepareStatement(productListSql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productInfoDto = new ProductInfoDto();
				productInfoDto.setProid(rs.getString("id"));
				productInfoDto.setProname(rs.getString("name"));
				productInfoDto.setPrice(rs.getDouble("price"));
				productInfoDtos.add(productInfoDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnect.closeConnection(conn);
		}

		return productInfoDtos;
	}


}