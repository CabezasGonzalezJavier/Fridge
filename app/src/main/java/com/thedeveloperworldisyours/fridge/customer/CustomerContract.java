package com.thedeveloperworldisyours.fridge.customer;

import com.thedeveloperworldisyours.fridge.BasePresenter;
import com.thedeveloperworldisyours.fridge.BaseView;

/**
 * Created by javierg on 25/04/2017.
 */

public interface CustomerContract {

    interface View extends BaseView<Presenter> {
        void showKinder(int numberKinder);
    }

    interface Presenter extends BasePresenter {
        void openFridge(int numberGrab);
        void grabKinders(int numberGrab);

        int getKindersLeft();
    }
}
