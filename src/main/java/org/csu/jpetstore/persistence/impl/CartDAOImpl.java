package org.csu.jpetstore.persistence.impl;

import org.csu.jpetstore.domain.*;
import org.csu.jpetstore.persistence.CartDAO;
import org.csu.jpetstore.util.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

public class CartDAOImpl implements CartDAO {
    private static final String insertOrUpdateCartSQL = "insert into `cart`(`username`, `itemid`, `quantity`, `totalprice`) values(?, ?, ?, ?) " +
            "on duplicate key " +
            "update `quantity`=?, `totalprice`=?";
    private static final String getOrderByUsernameSQL = "select " +
            "c.itemid," +
            "c.quantity," +
            "c.totalprice," +
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
            "qty as \"inventory.quantity\" " +
            "from cart c, item i, inventory v, product p " +
            "where p.productid = i.productid " +
            "and c.username = ? " +
            "and i.itemid = v.itemid " +
            "and i.itemid = c.itemid ";
    private static final String deleteByUsernameAndItemIdSQL = "delete " +
            "from cart where username = ? and itemid = ?";
    private static final String deleteByUsernameSQL = "delete " +
            "from cart where username = ?";

    @Override
    public void insertOrUpdateCart(Account account, Cart cart) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(insertOrUpdateCartSQL);
        String username = account.getUsername();
        Iterator<CartItem> i = cart.getAllCartItems();
        while (i.hasNext()) {
            CartItem cartItem = i.next();
            String itemId = cartItem.getItem().getItemId();
            int quantity = cartItem.getQuantity();
            BigDecimal totalPrice = cartItem.getTotal();
            pStatement.setString(1, username);
            pStatement.setString(2, itemId);
            pStatement.setInt(3, quantity);
            pStatement.setBigDecimal(4, totalPrice);
            pStatement.setInt(5, quantity);
            pStatement.setBigDecimal(6, totalPrice);
            pStatement.execute();
        }
    }

    @Override
    public Cart getCartByUsername(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getOrderByUsernameSQL);
        String username = account.getUsername();
        pStatement.setString(1, username);
        ResultSet resultSet = pStatement.executeQuery();
        Cart cart = new Cart();
        while (resultSet.next()) {
            Item item = new Item();
            CartItem cartItem = new CartItem();
            Product product = new Product();
            cartItem.setQuantity(resultSet.getInt("quantity"));
            cartItem.setInStock(resultSet.getInt("inventory.quantity") > 0);
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
            for (int i = 0; i < cartItem.getQuantity(); i++) {
                cart.addItem(item, cartItem.isInStock());
            }
        }
        return cart;
    }

    @Override
    public void deleteByUsernameAndItemId(Account account, String itemId) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(deleteByUsernameAndItemIdSQL);
        String username = account.getUsername();
        pStatement.setString(1, username);
        pStatement.setString(2, itemId);
        pStatement.execute();
    }

    @Override
    public void deleteByUsername(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(deleteByUsernameSQL);
        String username = account.getUsername();
        pStatement.setString(1, username);
        pStatement.execute();
    }
}
