package service;

import dao.ProductInfoDao;
import dto.ProductInfoDto;
import java.util.ArrayList;

public class ProductInfoSvc {
    private ProductInfoDao productInfoDao;

    public ProductInfoSvc() {
        this.productInfoDao = new ProductInfoDao();
    }

    /**
     * 특정 상품 ID를 기반으로 상품 정보를 조회합니다.
     * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
     * @param Proid 상품 ID
     * @return 조회된 상품 정보 객체. 해당 상품이 없을 경우 null을 반환할 수 있습니다.
     */
    public ProductInfoDto selectProductById(String Proid) {
        ArrayList<ProductInfoDto> products = productInfoDao.selectProduct(Proid);
        if (!products.isEmpty()) {
            return products.get(0); // ID로 조회하기 때문에, 항상 첫 번째 요소 반환
        }
        return null; // 상품을 찾지 못했을 경우
    }

    /**
     * 모든 상품 정보를 조회합니다.
     * xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
     * @return 조회된 모든 상품 정보 목록
     */
    public ArrayList<ProductInfoDto> selectAllProducts() {
        return productInfoDao.selectProductList();
    }
    
    /**
     * 상품 이름으로 상품 정보를 검색합니다.
     * @param productName 검색할 상품 이름
     * @return 검색된 상품 정보 목록
     */
    public ArrayList<ProductInfoDto> searchProductsByName(String productName) {
        productInfoDao = new ProductInfoDao();
        ArrayList<ProductInfoDto> productInfoDto = productInfoDao.searchProductsByName(productName);
        
    	return productInfoDto;
    }
}
