package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrdersByUsername(String username) throws Exception;

    Order getOrder(int orderId) throws Exception;

    void insertOrder(Order order) throws Exception;

    void insertOrderStatus(Order order) throws Exception;
}
