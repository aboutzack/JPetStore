package org.csu.jpetstore.persistence.impl;

import org.csu.jpetstore.domain.Item;
import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.persistence.ItemDAO;
import org.csu.jpetstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDAOImpl implements ItemDAO {
    private static final String getItemListByProductSQL = "select " +
            "i.itemid," +
            "listprice," +
            "unitcost," +
            "supplier as supplierid," +
            "i.productid as \"product.productid\"," +
            "name as \"product.name\"," +
            "descn as \"product.description\"," +
            "category as \"product.categoryid\"," +
            "status," +
            "attr1 as attribute1," +
            "attr2 as attribute2," +
            "attr3 as attribute3," +
            "attr4 as attribute4," +
            "attr5 as attribute5 " +
            "from item i, product p " +
            "where p.productid = i.productid " +
            "and i.productid = ?";
    private static final String getItemSQL = "select " +
            "i.itemid," +
            "listprice," +
            "unitcost," +
            "supplier as supplierid," +
            "i.productid as \"product.productid\"," +
            "name as \"product.name\"," +
            "descn as \"product.description\"," +
            "category as \"product.categoryid\"," +
            "status," +
            "attr1 as attribute1," +
            "attr2 as attribute2," +
            "attr3 as attribute3," +
            "attr4 as attribute4," +
            "attr5 as attribute5," +
            "qty as quantity " +
            "from item i, inventory v, product p " +
            "where p.productid = i.productid " +
            "and i.itemid = v.itemid " +
            "and i.itemid = ?";
    private static final String getInventoryQuantitySQL = "select qty as value " +
            "from inventory " +
            "where itemid = ?";
    private static final String updateInventoryQuantitySQL = "";

    @Override
    public void updateInventoryQuantity(Map<String, Object> param) throws Exception {

    }

    @Override
    public int getInventoryQuantity(String itemId) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getInventoryQuantitySQL);
        pStatement.setString(1, itemId);
        ResultSet resultSet = pStatement.executeQuery();
        int value = 0;
        if (resultSet.next()) {
            value = resultSet.getInt("value");
        }
        DBUtil.closeConnection(connection);
        return value;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getItemListByProductSQL);
        pStatement.setString(1, productId);
        ResultSet resultSet = pStatement.executeQuery();
        List<Item> itemList = new ArrayList<>();
        while (resultSet.next()) {
            Item item = new Item();
            Product product = new Product();
            item.setItemId(resultSet.getString("itemid"));
            item.setListPrice(resultSet.getBigDecimal("listprice"));
            item.setUnitCost(resultSet.getBigDecimal("unitcost"));
            item.setSupplierId(resultSet.getInt("supplierid"));
            product.setProductId(resultSet.getString("product.productid"));
            product.setName(resultSet.getString("product.name"));
            product.setDescription(resultSet.getString("product.description"));
            product.setCategoryId(resultSet.getString("product.categoryid"));
            item.setStatus(resultSet.getString("status"));
            item.setAttribute1(resultSet.getString("attribute1"));
            item.setAttribute1(resultSet.getString("attribute2"));
            item.setAttribute1(resultSet.getString("attribute3"));
            item.setAttribute1(resultSet.getString("attribute4"));
            item.setAttribute1(resultSet.getString("attribute5"));
            item.setProduct(product);
            itemList.add(item);
        }
        DBUtil.closeConnection(connection);
        return itemList;
    }

    @Override
    public Item getItem(String itemId) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getItemSQL);
        pStatement.setString(1, itemId);
        ResultSet resultSet = pStatement.executeQuery();
        Item item = new Item();
        Product product = new Product();
        if (resultSet.next()) {
            item.setItemId(resultSet.getString("itemid"));
            item.setListPrice(resultSet.getBigDecimal("listprice"));
            item.setUnitCost(resultSet.getBigDecimal("unitcost"));
            item.setSupplierId(resultSet.getInt("supplierid"));
            product.setProductId(resultSet.getString("product.productid"));
            product.setName(resultSet.getString("product.name"));
            product.setDescription(resultSet.getString("product.description"));
            product.setCategoryId(resultSet.getString("product.categoryid"));
            item.setStatus(resultSet.getString("status"));
            item.setAttribute1(resultSet.getString("attribute1"));
            item.setAttribute2(resultSet.getString("attribute2"));
            item.setAttribute3(resultSet.getString("attribute3"));
            item.setAttribute4(resultSet.getString("attribute4"));
            item.setAttribute5(resultSet.getString("attribute5"));
            item.setQuantity(resultSet.getInt("quantity"));
            item.setProduct(product);
        }
        DBUtil.closeConnection(connection);
        return item;
    }
}
