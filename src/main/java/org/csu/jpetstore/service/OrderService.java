package org.csu.jpetstore.service;

import org.csu.jpetstore.domain.Item;
import org.csu.jpetstore.domain.LineItem;
import org.csu.jpetstore.domain.Order;
import org.csu.jpetstore.persistence.ItemDAO;
import org.csu.jpetstore.persistence.LineItemDAO;
import org.csu.jpetstore.persistence.OrderDAO;
import org.csu.jpetstore.persistence.SequenceDAO;
import org.csu.jpetstore.persistence.impl.ItemDAOImpl;
import org.csu.jpetstore.persistence.impl.LineItemDAOImpl;
import org.csu.jpetstore.persistence.impl.OrderDAOImpl;

import java.util.List;

public class OrderService {

    private ItemDAO itemDAO;
    private OrderDAO orderDAO;
    private SequenceDAO sequenceDAO;
    private LineItemDAO lineItemDAO;

    public void insertOrder(Order order) {
    }

    public Order getOrder(int orderId) {
        orderDAO = new OrderDAOImpl();
        lineItemDAO = new LineItemDAOImpl();
        itemDAO = new ItemDAOImpl();
        Order order;
        try {
            order = orderDAO.getOrder(orderId);
            order.setLineItems(lineItemDAO.getLineItemsByOrderId(orderId));
            for (int i = 0; i < order.getLineItems().size(); i++) {
                LineItem lineItem = (LineItem) order.getLineItems().get(i);
                Item item = itemDAO.getItem(lineItem.getItemId());
                item.setQuantity(itemDAO.getInventoryQuantity(lineItem.getItemId()));
                lineItem.setItem(item);
            }
        }catch (Exception ex){
            return null;
        }
        return order;
    }

    public List<Order> getOrdersByUsername(String username) {
        orderDAO = new OrderDAOImpl();
        try {
            return orderDAO.getOrdersByUsername(username);
        } catch (Exception ex) {
            return null;
        }
    }

    public int getNextId(String name) {
        return 0;
    }
}
