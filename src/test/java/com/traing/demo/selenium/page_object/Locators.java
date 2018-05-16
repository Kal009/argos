package com.traing.demo.selenium.page_object;

import com.traing.demo.selenium.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Locators extends DriverFactory {

    public void doSearch(String product) {
        driver.findElement(By.id("searchTerm")).sendKeys(product);
        driver.findElement(By.cssSelector(".argos-header__search-button")).click();
        sleep(3000);
    }

    public void selectFilter(String filterValue) {
        List<WebElement> allFilters = driver.findElements(By.cssSelector(".ac-facet__label"));

        for (WebElement filter : allFilters) {
            //System.out.println(filter.getText());
            if (filter.getText().equalsIgnoreCase(filterValue)) {

                filter.click();
                break;
            }
        }
        sleep(10000);
    }


    public List<Double> getAllReviewRating() {
        List<Double> collectedRatings = new ArrayList<>();
        List<WebElement> ratings = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement rating : ratings) {
            String ratingInString = rating.getAttribute("data-star-rating");
            Double raingInDouble = Double.parseDouble(ratingInString);
            collectedRatings.add(raingInDouble);
        }
        return collectedRatings;
    }
}
