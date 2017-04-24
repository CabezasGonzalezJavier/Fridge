package com.thedeveloperworldisyours.fridge;

import java.util.List;

/**
 * Created by javierg on 24/04/2017.
 */

public class VIPCustomersHQs {
    private final Chat chat;

    private int kindersLeft;

    public VIPCustomersHQs(Chat chat) {
        this.chat = chat;
        this.kindersLeft = 10;
    }

    public void openFridge(List<Customer> customers) {
        for (Customer customer : customers) {
            grabKinders(customer);
            if (shouldCallMoreKinders()){
                notifyStockEmpty();
                delivered();
            }
        }
    }

    private void grabKinders(Customer customer) {
        kindersLeft -= customer.getNumberOfKindersToGrab();
        if (kindersLeft < 0) {
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

    public int getKindersLeft() {
        return kindersLeft;
    }


}
