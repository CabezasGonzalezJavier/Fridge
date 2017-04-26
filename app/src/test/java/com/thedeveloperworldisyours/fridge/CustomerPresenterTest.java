package com.thedeveloperworldisyours.fridge;

import com.thedeveloperworldisyours.fridge.chat.Chat;
import com.thedeveloperworldisyours.fridge.customer.CustomerContract;
import com.thedeveloperworldisyours.fridge.customer.CustomerPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by javierg on 26/04/2017.
 */

public class CustomerPresenterTest {
    @Mock
    private Chat mChatMock;

    @Mock
    private CustomerContract.View mView;

    private CustomerPresenter mPresenter;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mPresenter = new CustomerPresenter(mChatMock, mView);

    }

    @Test
    public void checkMaximumNumber() {
        mPresenter.openFridge(2);

        assertFalse(mPresenter.getKindersLeft()>10);
    }

    @Test
    public void checkMinimumNumber() {
        mPresenter.openFridge(2);

        assertTrue(mPresenter.getKindersLeft()>2);
    }

    @Test
    public void checkThatCallDelivered() {
        mPresenter.openFridge(10);

        verify(mChatMock, times(1)).sendMessage("Hi Delivery man, The stock is empty!!!");
    }
}
