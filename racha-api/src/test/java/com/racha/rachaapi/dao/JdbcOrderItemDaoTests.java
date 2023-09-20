package com.racha.rachaapi.dao;

import com.racha.rachaapi.dto.OrderItem;
import com.racha.rachaapi.dto.SelectedItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcOrderItemDaoTests extends BaseDaoTests{

    private JdbcOrderItemDao dao;

    @Before
    public void setup() {
        dao = new JdbcOrderItemDao(dataSource);
    }

    @Test
    public void getOrderList_returns_correct_number_of_items_for_list(){
        List<SelectedItem> selectedItemList = dao.getAll();
        Assert.assertEquals(3, selectedItemList.size());
    }

    @Test
    public void getOrderList_returns_incorrect_number_of_items_for_list(){
        List<SelectedItem> selectedItemList = dao.getAll();
        Assert.assertNotEquals(2, selectedItemList.size());
        Assert.assertNotEquals(4, selectedItemList.size());
    }

    @Test
    public void getOrderItemById_returns_correct_item(){
        OrderItem expected = new OrderItem();
        expected.setOrderItemId(2);
        expected.setMenuItemId(2);
        expected.setQuantity(2);

        OrderItem actual = dao.getOrderItemById(2);
        assertOrderItemsMatch(expected, actual);
    }

    @Test
    public void getOrderItemByMenuId_returns_correct_item(){
        OrderItem expected = new OrderItem();
        expected.setOrderItemId(3);
        expected.setMenuItemId(20);
        expected.setQuantity(1);

        OrderItem actual = dao.getOrderItemByMenuId(20);
        assertOrderItemsMatch(expected, actual);
    }

    private void assertOrderItemsMatch(OrderItem expected, OrderItem actual) {
        Assert.assertEquals(expected.getOrderItemId(), actual.getOrderItemId());
        Assert.assertEquals(expected.getMenuItemId(), actual.getMenuItemId());
        Assert.assertEquals(expected.getQuantity(), actual.getQuantity());
    }


}
