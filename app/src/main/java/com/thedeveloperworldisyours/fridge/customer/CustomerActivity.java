package com.thedeveloperworldisyours.fridge.customer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.thedeveloperworldisyours.fridge.FridgeApplication;
import com.thedeveloperworldisyours.fridge.R;
import com.thedeveloperworldisyours.fridge.chat.Chat;
import com.thedeveloperworldisyours.fridge.utils.Utils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

public class CustomerActivity extends AppCompatActivity {

    @Inject
    Chat mChat;

    @BindView(R.id.main_activity_toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_activity);

        ButterKnife.bind(this);

        navigation();
        initFragment();

    }

    private void navigation() {
        // Set up the mToolbar.
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        checkNotNull(actionBar);
        actionBar.setDisplayShowTitleEnabled(false);
    }

    public void initFragment() {

        CustomerFragment customerFragment = (CustomerFragment) getSupportFragmentManager().findFragmentById(R.id.main_activity_contentFrame);
        customerFragment = customerFragment.newInstance();

        if (customerFragment != null) {
            Utils.addFragmentToActivity(getSupportFragmentManager(),
                    customerFragment, R.id.main_activity_contentFrame);
        }
        initializeDagger();
        new CustomerPresenter(mChat, customerFragment);
    }

    private void initializeDagger() {
        FridgeApplication fridgeApplication = (FridgeApplication) getApplication();
        fridgeApplication.getFridgeComponent().inject(this);

    }
}
