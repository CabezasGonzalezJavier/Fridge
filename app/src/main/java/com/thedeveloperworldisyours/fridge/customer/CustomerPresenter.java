package com.thedeveloperworldisyours.fridge.customer;

import android.support.annotation.NonNull;

import com.thedeveloperworldisyours.fridge.chat.Chat;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by javierg on 25/04/2017.
 */

public class CustomerPresenter implements CustomerContract.Presenter {
    private final Chat chat;

    @NonNull
    private int kindersLeft;

    @NonNull
    private CustomerContract.View mView;

    @Inject
    public CustomerPresenter(Chat chat, CustomerContract.View view) {
        this.chat = chat;
        this.mView = view;
        this.kindersLeft = 10;
        view.setPresenter(this);
    }

//    @Inject
//    void setupListeners() {
//        mView.setPresenter(this);
//    }

    @Override
    public void openFridge(int numberGrab) {

        grabKinders(numberGrab);
        if (shouldCallMoreKinders()) {
            notifyStockEmpty();
            delivered();
        }
        mView.showKinder(kindersLeft);
    }

    @Override
    public void grabKinders(int numberGrab) {

        kindersLeft -= numberGrab;
        if (kindersLeft < 2) {
            kindersLeft = 0;
        }
    }

    private boolean shouldCallMoreKinders() {
        return kindersLeft <= 2;
    }

    private void notifyStockEmpty() {
        chat.sendMessage("Hi Delivery man, The stock is empty!!!");

    }

    private void delivered() {
        kindersLeft += 10;
    }

    @Override
    public int getKindersLeft() {
        return kindersLeft;
    }


    @Override
    public void start() {

    }
}
