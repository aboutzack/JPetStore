package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getProductListByCategory(String categoryId) throws Exception;

    Product getProduct(String productId) throws Exception;

    List<Product> searchProductList(String keywords) throws Exception;
}
