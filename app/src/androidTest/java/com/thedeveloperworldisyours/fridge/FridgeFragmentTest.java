package com.thedeveloperworldisyours.fridge;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.thedeveloperworldisyours.fridge.customer.CustomerActivity;

import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by javierg on 26/04/2017.
 */
@RunWith(AndroidJUnit4.class)
public class FridgeFragmentTest {

    @Rule
    public ActivityTestRule<CustomerActivity> mCustomerActivityTestRule =
            new ActivityTestRule<CustomerActivity>(CustomerActivity.class) {
                @Override
                protected void beforeActivityLaunched() {
                    super.beforeActivityLaunched();

                    // Doing this in @Before generates a race condition.
                    InstrumentationRegistry.getTargetContext()
                            .getApplicationContext().getCom


//                    ((ToDoApplication) InstrumentationRegistry.getTargetContext()
//                            .getApplicationContext()).getTasksRepositoryComponent()
//                            .getTasksRepository().deleteAllTasks();
            }
}
