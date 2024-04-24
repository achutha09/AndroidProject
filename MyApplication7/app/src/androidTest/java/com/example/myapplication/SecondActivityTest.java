package com.example.myapplication;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static androidx.test.uiautomator.Until.*;

@RunWith(AndroidJUnit4.class)
public class SecondActivityTest {

    private UiDevice device;

    @Before
    public void setUp() {
        device = UiDevice.getInstance(getInstrumentation());
    }

    @Test
    public void testChallengesDisplayed() {
        // Start from the home screen
        device.pressHome();

        // Find and click the launcher icon
        device.findObject(By.desc("My Application")).click();

        // Wait for the app to open
        device.wait(findObject(By.res("com.example.myapplication:id/startExplicitlyButton")), 5000);

        // Click on "Start Activity Explicitly" button
        device.findObject(By.res("com.example.myapplication:id/startExplicitlyButton")).click();

        // Check if the SecondActivity is displayed
        device.wait(findObject(By.res("com.example.myapplication:id/second_activity_layout")), 5000);

        // Check if challenges are displayed
        device.wait(findObject(By.text("Mobile Software Engineering Challenges")), 5000);
    }
}
