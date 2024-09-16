package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import locators.HomePageLocator;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomePage {
    WebDriver driver;
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //TC001
    public void verifyTitlePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement titlePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePageLocator.PAGE_TITLE_XPATH)));
        String pageTitleText = titlePage.getText();
        String expectedTitle = "THIS IS DEMO SITE";
        if (pageTitleText.contains(expectedTitle)) {
            logger.info("PASS, Page title contain String 'THIS IS DEMO SITE'");
        }
        else {
            logger.info("FAIL, Page title do not contain String 'THIS IS DEMO SITE'");
        }
    }

    //TC002
    public void clickMobileButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement mobileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePageLocator.MOBILE_BUTTON)));
        mobileButton.click();
    }
    public void verifyScreenMobile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement titlePageMobile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePageLocator.MOBILE_POPUP)));
        String expectedTitle = "MOBILE";
        String actualTitle = titlePageMobile.getText();
        if (actualTitle.contains(expectedTitle)) {
            logger.info("PASS, title screen is 'MOBILE'");
        }
        else {
            logger.info("FAIL, title screen isn't 'MOBILE'");
        }
    }

    //TC003
    public void clickSortByName(String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement sortButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePageLocator.SORT_BY_BUTTON)));
        Select select = new Select(sortButton);
        select.selectByVisibleText(option.trim());
        logger.info("Sort By: " + option.trim());
    }
    public void verifySortByAlpha() {
        //Create webdriverwait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //wait all elements to visible
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(HomePageLocator.LIST_PRODUCT)));

        //create list original
        List<String> originalList = new ArrayList<>();
        for (WebElement element:elements) {
            originalList.add(element.getText().trim()); //save string elements
        }
        logger.info("original List : " + originalList);
        //create copy list with sorted
        List<String> sortedList = new ArrayList<>(originalList);
        logger.info("sorted list: " + sortedList);
        Collections.sort(sortedList);

        //compare 2 list
        if (originalList.equals(sortedList)) {
            logger.info("PASS, Sorted by alphabet");
        }
        else {
            logger.info("FAIL, Don't sorted by alphabet");
        }
    }
}
