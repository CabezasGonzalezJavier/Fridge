package com.thedeveloperworldisyours.fridge;

import com.thedeveloperworldisyours.fridge.chat.Chat;
import com.thedeveloperworldisyours.fridge.customer.Customer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by javierg on 24/04/2017.
 */

public class VIPCustomersHQsTest {

    public VIPCustomersHQs mVipCustomersHQs;

    @Mock
    public Chat chatMock;

    private List<Customer> mCustomersHungry;
    private List<Customer> mCustomers;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mVipCustomersHQs = new VIPCustomersHQs(chatMock);

        mCustomersHungry = new ArrayList<>();
        mCustomersHungry.add(0, new Customer("customer1", 3));
        mCustomersHungry.add(1, new Customer("customer2", 2));
        mCustomersHungry.add(2, new Customer("customer3", 3));

        mCustomersHungry.add(3, new Customer("customer4", 3));
        mCustomersHungry.add(4, new Customer("customer5", 3));
        mCustomersHungry.add(5, new Customer("customer6", 1));


        mCustomers = new ArrayList<>();
        mCustomersHungry.add(0, new Customer("customer1", 1));
        mCustomersHungry.add(1, new Customer("customer2", 2));
        mCustomersHungry.add(2, new Customer("customer3", 1));

        mCustomersHungry.add(3, new Customer("customer4", 1));
        mCustomersHungry.add(4, new Customer("customer5", 1));
        mCustomersHungry.add(5, new Customer("customer6", 1));
    }
    
    @Test
    public void checkMaximumNumber() {
        mVipCustomersHQs.openFridge(mCustomersHungry);

        assertFalse(mVipCustomersHQs.getKindersLeft()>10);
    }

    @Test
    public void checkMinimumNumber() {
        mVipCustomersHQs.openFridge(mCustomersHungry);

        assertTrue(mVipCustomersHQs.getKindersLeft()>2);
    }

    @Test
    public void checkThatCallDelivered() {
        mVipCustomersHQs.openFridge(mCustomersHungry);

        verify(chatMock, times(2)).sendMessage("Hi Delivery man, The stock is empty!!!");
    }

    @Test
    public void shouldCallDeliveryMan() {
        mVipCustomersHQs.openFridge(mCustomers);

        verify(chatMock, never()).sendMessage("Hi Delivery man, The stock is empty!!!");
    }

}
