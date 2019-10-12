package org.csu.jpetstore.persistence.impl;

import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.persistence.ProductDAO;
import org.csu.jpetstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static final String getProductSQL = "select " +
            "productid," +
            "name," +
            "descn as description," +
            "category as categoryid " +
            "from product " +
            "where productid = ?";
    private static final String getProductListByCategorySQL = "select " +
            "productid," +
            "name," +
            "descn as description," +
            "category as categoryid " +
            "from product " +
            "where category = ?";
    private static final String searchProductListSQL = "select " +
            "productid," +
            "name," +
            "descn as description," +
            "category as categoryid " +
            "from product " +
            "where lower(name) like ?";

    @Override
    public List<Product> getProductListByCategory(String categoryId) throws Exception{
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getProductListByCategorySQL);
        pStatement.setString(1, categoryId);
        ResultSet resultSet = pStatement.executeQuery();
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductId(resultSet.getString("productid"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setCategoryId(resultSet.getString("categoryid"));
            productList.add(product);
        }
        DBUtil.closeConnection(connection);
        return productList;
    }

    @Override
    public Product getProduct(String productId) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getProductSQL);
        pStatement.setString(1, productId);
        ResultSet resultSet = pStatement.executeQuery();
        Product product = new Product();
        if (resultSet.next()) {
            product.setProductId(resultSet.getString("productid"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setCategoryId(resultSet.getString("categoryid"));
        }
        DBUtil.closeConnection(connection);
        return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(searchProductListSQL);
        pStatement.setString(1, keywords);
        ResultSet resultSet = pStatement.executeQuery();
        List<Product> productList = new ArrayList<>();
        while (resultSet.next()){
            Product product = new Product();
            product.setProductId(resultSet.getString("productid"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setCategoryId(resultSet.getString("categoryid"));
            productList.add(product);
        }
        DBUtil.closeConnection(connection);
        return productList;
    }
}
