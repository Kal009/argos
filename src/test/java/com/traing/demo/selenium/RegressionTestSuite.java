package com.traing.demo.selenium;

import com.traing.demo.selenium.page_object.Locators;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;

public class RegressionTestSuite extends Hooks {

    Locators locators = new Locators();

    @Test
    public void filterByReviewTest() {
        locators.doSearch("nike");
        locators.selectFilter("5only");
        List<Double> actualList = locators.getAllReviewRating();
        assertThat(actualList, everyItem(greaterThan(5.0)));

    }
}
