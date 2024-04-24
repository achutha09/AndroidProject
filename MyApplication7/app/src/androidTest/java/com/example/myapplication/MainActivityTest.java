package com.example.myapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private UiDevice device;

    @Before
    public void setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testStartActivityExplicitly() {
        // Start from the home screen
        device.pressHome();

        // Wait for launcher to load
        device.waitForIdle(2000);

        // Find and click the launcher icon
        UiObject2 appIcon = device.findObject(By.desc("My Application"));
        if (appIcon != null) {
            appIcon.click();

            // Wait for the app to open
            device.wait(Until.hasObject(By.res("com.example.myapplication:id/startExplicitlyButton")), 5000);

            // Click on "Start Activity Explicitly" button
            UiObject2 startButton = device.findObject(By.res("com.example.myapplication:id/startExplicitlyButton"));
            if (startButton != null) {
                startButton.click();

                // Wait for the SecondActivity to be displayed
                device.wait(Until.hasObject(By.res("com.example.myapplication:id/second_activity_layout")), 5000);

                // Check if challenges are displayed
                UiObject2 challengesText = device.findObject(By.text("Mobile Software Engineering"));
                assert (challengesText != null);
            } else {
                throw new AssertionError("Start button not found");
            }
        } else {
            throw new AssertionError("App icon not found");
        }
    }
}
