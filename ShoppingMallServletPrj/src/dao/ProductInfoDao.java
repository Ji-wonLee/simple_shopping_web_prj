package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ProductInfoDto; // 상품 정보를 담을 DTO
import utils.DBConnect;

import java.sql.Connection;

public class ProductInfoDao {
	// SQL 쿼리: 특정 상품 정보 조회
	public final static String productSql = 
			"SELECT item.ino, iname, pwon FROM price, item"
			+ " WHERE item.ino = price.ino AND id = ?";

	// SQL 쿼리: 모든 상품 정보 조회
	public final static String productListSql =
			"SELECT ino, iname, pwon FROM item, price WHERE item.ino = price.ino";

	
	//이름 검색
	public final static String searchProductByNameSql 
	= "SELECT item.ino, iname, pwon FROM item, price WHERE item.ino = price.ino AND iname LIKE ?";
	
	
	
	/**
	 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
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
				productInfoDto.setProid(rs.getString("ino"));
				productInfoDto.setProname(rs.getString("iname"));
				productInfoDto.setPrice(rs.getDouble("pwon"));
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
	 * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	 * 모든 상품 정보 조회
	 * @return 조회된 모든 상품 정보 목록
	 */
	public ArrayList<ProductInfoDto> selectProductList() {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Connection conn = DBConnect.getConnection();

	    ProductInfoDto productInfoDto = null;
	    ArrayList<ProductInfoDto> productInfoDtos = new ArrayList<ProductInfoDto>();

	    try {
	        pstmt = conn.prepareStatement(productListSql); // 모든 상품 정보 조회 쿼리
	        rs = pstmt.executeQuery();
	        while(rs.next()) {
	            productInfoDto = new ProductInfoDto();
	            productInfoDto.setProid(rs.getString("ino"));
	            productInfoDto.setProname(rs.getString("iname"));
	            productInfoDto.setPrice(rs.getDouble("pwon"));
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
     * 상품 이름을 포함하는 모든 상품 정보 조회
     * @param productName 검색할 상품 이름
     * @return 조회된 상품 정보 목록
     */
	public ArrayList<ProductInfoDto> searchProductsByName(String productName) {
	    ArrayList<ProductInfoDto> productInfoDtos = new ArrayList<>();
	   
	    String searchQuery = "SELECT item.ino, item.iname, price.pwon FROM item, price WHERE item.ino = price.ino AND item.iname LIKE ?";

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBConnect.getConnection();
	        pstmt = conn.prepareStatement(searchQuery);
	        pstmt.setString(1, "%" + productName + "%");
	        rs = pstmt.executeQuery();

	        while(rs.next()) {
	            ProductInfoDto productInfoDto = new ProductInfoDto();
	            productInfoDto.setProid(rs.getString("ino"));
	            productInfoDto.setProname(rs.getString("iname"));
	            productInfoDto.setPrice(rs.getDouble("pwon"));
	            productInfoDtos.add(productInfoDto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return productInfoDtos;
	}

}