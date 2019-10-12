package org.csu.jpetstore.persistence.impl;

import org.csu.jpetstore.domain.Order;
import org.csu.jpetstore.persistence.OrderDAO;
import org.csu.jpetstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static final String getOrderSQL = "select " +
            "billaddr1 as billaddress1," +
            "billaddr2 as billaddress2," +
            "billcity," +
            "billcountry," +
            "billstate," +
            "billtofirstname," +
            "billtolastname," +
            "billzip," +
            "shipaddr1 as shipaddress1," +
            "shipaddr2 as shipaddress2," +
            "shipcity," +
            "shipcountry," +
            "shipstate," +
            "shiptofirstname," +
            "shiptolastname," +
            "shipzip," +
            "cardtype," +
            "courier," +
            "creditcard," +
            "exprdate as expirydate," +
            "locale," +
            "orderdate," +
            "orders.orderid," +
            "totalprice," +
            "userid as username," +
            "status " +
            "from orders, orderstatus " +
            "where orders.orderid = ? " +
            "and orders.orderid = orderstatus.orderid";
    private static final String getOrdersByUsernameSQL = "select " +
            "billaddr1 as billaddress1," +
            "billaddr2 as billaddress2," +
            "billcity," +
            "billcountry," +
            "billstate," +
            "billtofirstname," +
            "billtolastname," +
            "billzip," +
            "shipaddr1 as shipaddress1," +
            "shipaddr2 as shipaddress2," +
            "shipcity," +
            "shipcountry," +
            "shipstate," +
            "shiptofirstname," +
            "shiptolastname," +
            "shipzip," +
            "cardtype," +
            "courier," +
            "creditcard," +
            "exprdate as expirydate," +
            "locale," +
            "orderdate," +
            "orders.orderid," +
            "totalprice," +
            "userid as username," +
            "status " +
            "from orders, orderstatus " +
            "where orders.userid = ? " +
            "and orders.orderid = orderstatus.orderid " +
            "order by orderdate";
    private static final String insertOrderSQL = "";
    private static final String insertOrderStatusSQL = "";

    public List<Order> getOrdersByUsername(String username) throws Exception{
        List<Order> orderList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getOrdersByUsernameSQL);
        pStatement.setString(1, username);
        ResultSet resultSet = pStatement.executeQuery();
        while (resultSet.next()){
            Order order = new Order();
            order.setBillAddress1(resultSet.getString("billAddress1"));
            order.setBillAddress2(resultSet.getString("billAddress2"));
            order.setBillCity(resultSet.getString("billcity"));
            order.setBillCountry(resultSet.getString("billcountry"));
            order.setBillState(resultSet.getString("billstate"));
            order.setBillToFirstName(resultSet.getString("billtofirstname"));
            order.setBillToLastName(resultSet.getString("billtolastname"));
            order.setBillZip(resultSet.getString("billzip"));
            order.setShipAddress1(resultSet.getString("shipaddress1"));
            order.setShipAddress2(resultSet.getString("shipaddress2"));
            order.setShipCity(resultSet.getString("shipcity"));
            order.setShipCountry(resultSet.getString("shipcountry"));
            order.setShipState(resultSet.getString("shipstate"));
            order.setShipToFirstName(resultSet.getString("shiptofirstname"));
            order.setShipToLastName(resultSet.getString("shiptolastname"));
            order.setShipZip(resultSet.getString("shipzip"));
            order.setCourier(resultSet.getString("courier"));
            order.setCreditCard(resultSet.getString("creditcard"));
            order.setExpiryDate(resultSet.getString("expirydate"));
            order.setLocale(resultSet.getString("locale"));
            order.setOrderDate(resultSet.getDate("orderdate"));
            order.setOrderId(resultSet.getInt("orderid"));
            order.setTotalPrice(resultSet.getBigDecimal("totalprice"));
            order.setUsername(resultSet.getString("username"));
            order.setStatus(resultSet.getString("status"));
            orderList.add(order);
        }
        DBUtil.closeConnection(connection);
        return orderList;
    };

    public Order getOrder(int orderId) throws Exception{
        Order order = new Order();
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getOrderSQL);
        pStatement.setInt(1, orderId);
        ResultSet resultSet = pStatement.executeQuery();
        if (resultSet.next()) {
            order.setBillAddress1(resultSet.getString("billAddress1"));
            order.setBillAddress2(resultSet.getString("billAddress2"));
            order.setBillCity(resultSet.getString("billcity"));
            order.setBillCountry(resultSet.getString("billcountry"));
            order.setBillState(resultSet.getString("billstate"));
            order.setBillToFirstName(resultSet.getString("billtofirstname"));
            order.setBillToLastName(resultSet.getString("billtolastname"));
            order.setBillZip(resultSet.getString("billzip"));
            order.setShipAddress1(resultSet.getString("shipaddress1"));
            order.setShipAddress2(resultSet.getString("shipaddress2"));
            order.setShipCity(resultSet.getString("shipcity"));
            order.setShipCountry(resultSet.getString("shipcountry"));
            order.setShipState(resultSet.getString("shipstate"));
            order.setShipToFirstName(resultSet.getString("shiptofirstname"));
            order.setShipToLastName(resultSet.getString("shiptolastname"));
            order.setShipZip(resultSet.getString("shipzip"));
            order.setCourier(resultSet.getString("courier"));
            order.setCreditCard(resultSet.getString("creditcard"));
            order.setExpiryDate(resultSet.getString("expirydate"));
            order.setLocale(resultSet.getString("locale"));
            order.setOrderDate(resultSet.getDate("orderdate"));
            order.setOrderId(resultSet.getInt("orderid"));
            order.setTotalPrice(resultSet.getBigDecimal("totalprice"));
            order.setUsername(resultSet.getString("username"));
            order.setStatus(resultSet.getString("status"));
        }
        DBUtil.closeConnection(connection);
        return order;
        }

    public void insertOrder(Order order) throws Exception{
    }

    public void insertOrderStatus(Order order) throws Exception{
    }
}
