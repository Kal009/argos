package com.traing.demo.selenium;

import com.traing.demo.selenium.drivers.DriverFactory;
import org.junit.After;
import org.junit.Before;

public class Hooks {

    DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() {
        driverFactory.openBrowser();
        driverFactory.navigate("http://www.argos.co.uk");
        driverFactory.maxWindow();
        driverFactory.applyImpWait();

    }

    @After
    public void tearDown() {
        driverFactory.closeBrowser();
    }

}
