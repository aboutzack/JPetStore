package org.csu.jpetstore.persistence.impl;

import org.csu.jpetstore.domain.LineItem;
import org.csu.jpetstore.persistence.LineItemDAO;
import org.csu.jpetstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LineItemDAOImpl implements LineItemDAO {
    private static final String getLineItemsByOrderIdSQL = "select " +
            "orderid," +
            "linenum as linenumber," +
            "itemid," +
            "quantity," +
            "unitprice " +
            "from lineitem " +
            "where orderid = ?";
    private static final String insertLineItemSQL = "";

    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) throws Exception {
        List<LineItem> lineItemList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getLineItemsByOrderIdSQL);
        pStatement.setInt(1, orderId);
        ResultSet resultSet = pStatement.executeQuery();
        while (resultSet.next()){
            LineItem lineItem = new LineItem();
            lineItem.setOrderId(resultSet.getInt("orderid"));
            lineItem.setLineNumber(resultSet.getInt("linenumber"));
            lineItem.setItemId(resultSet.getString("itemid"));
            lineItem.setQuantity(resultSet.getInt("quantity"));
            lineItem.setUnitPrice(resultSet.getBigDecimal("unitprice"));
            lineItemList.add(lineItem);
        }
        DBUtil.closeConnection(connection);
        return lineItemList;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {

    }
}
