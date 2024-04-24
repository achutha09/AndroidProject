package com.example.myapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static androidx.test.uiautomator.Until.*;

@RunWith(AndroidJUnit4.class)
public class ThirdActivityTest {

    private UiDevice device;

    @Before
    public void setUp() {
        device = UiDevice.getInstance(getInstrumentation());
    }

    @Test
    public void testCaptureImageButton() {
        // Start from the home screen
        device.pressHome();

        // Find and click the launcher icon
        device.findObject(By.desc("My Application")).click();

        // Grant camera access permission
        grantCameraPermission();

        // Wait for the app to open
        device.wait(findObject(By.res("com.example.myapplication:id/viewImageActivityButton")), 5000);

        // Click on "View Image Activity" button
        device.findObject(By.res("com.example.myapplication:id/viewImageActivityButton")).click();

        // Check if the captured image view is displayed
        device.wait(findObject(By.res("com.example.myapplication:id/capturedImageView")), 5000);
    }

    private void grantCameraPermission() {
        // Check if the permission dialog is displayed
        if (device.findObject(By.res("com.android.packageinstaller:id/permission_allow_button")) != null) {
            // Click on the allow button
            device.findObject(By.res("com.android.packageinstaller:id/permission_allow_button")).click();
        }
    }
}
