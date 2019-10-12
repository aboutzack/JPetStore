package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Item;

import java.util.List;
import java.util.Map;

public interface ItemDAO {

    void updateInventoryQuantity(Map<String, Object> param) throws Exception;

    int getInventoryQuantity(String itemId) throws Exception;

    List<Item> getItemListByProduct(String productId) throws Exception;

    Item getItem(String itemId) throws Exception;
}
