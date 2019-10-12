package org.csu.jpetstore.service;

import org.csu.jpetstore.domain.Item;
import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.persistence.CategoryDAO;
import org.csu.jpetstore.persistence.ItemDAO;
import org.csu.jpetstore.persistence.ProductDAO;
import org.csu.jpetstore.persistence.impl.ItemDAOImpl;
import org.csu.jpetstore.persistence.impl.ProductDAOImpl;

import java.util.List;

public class CatalogService {

    private CategoryDAO categoryDAO;
    private ItemDAO itemDAO;
    private ProductDAO productDAO;

//    public List<Category> getCategoryList() {
//        return categoryDAO.getCategoryList();
//    }
//
//    public Category getCategory(String categoryId) {
//        return categoryDAO.getCategory(categoryId);
//    }
//
    public Product getProduct(String productId) {
        productDAO = new ProductDAOImpl();
        try {
            return productDAO.getProduct(productId);
        } catch (Exception ex) {
            return null;
        }

    }

    public List<Product> getProductListByCategory(String categoryId) {
        productDAO = new ProductDAOImpl();
        try {
            return productDAO.getProductListByCategory(categoryId);
        } catch (Exception ex) {
            return null;
        }
    }


    public List<Product> searchProductList(String keyword) {
        productDAO = new ProductDAOImpl();
        try {
            return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
        }catch (Exception ex){
            return null;
        }
    }

    public List<Item> getItemListByProduct(String productId) {
        itemDAO = new ItemDAOImpl();
        try {
            return itemDAO.getItemListByProduct(productId);
        } catch (Exception ex) {
            return null;
        }
    }

    public Item getItem(String itemId) {
        itemDAO = new ItemDAOImpl();
        try {
            return itemDAO.getItem(itemId);
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean isItemInStock(String itemId) {
        itemDAO = new ItemDAOImpl();
        try {
            return itemDAO.getInventoryQuantity(itemId) > 0;
        }catch (Exception ex){
            return false;
        }
    }
}
