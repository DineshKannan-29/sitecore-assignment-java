package stepDefinitions;


import io.cucumber.java8.En;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.AmazonHomePage;
import pages.AmazonProductsDetailsPage;
import pages.AmazonSearchResultsPage;

import java.math.BigDecimal;

import static utils.Asserter.assertIfAmountIsGreater;
import static utils.Utils.*;

public class StepDefinitions implements En {
    WebDriver driver;
    AmazonHomePage amazonHomePage;
    AmazonSearchResultsPage amazonSearchResultPage;
    AmazonProductsDetailsPage amazonProductsDetailsPage;

    private static final Logger logger = LogManager.getLogger(StepDefinitions.class);

    public StepDefinitions() {
        Given("Setup {string} browser {string}", (String browserName, String driverPath) -> {
            driver = setupBrowser(browserName, driverPath);
            logger.info("Browser setup completed");
        });

        When("GoTo URL {string}", (String URL) -> {
            goToLink(driver, URL);
            logger.info("Navigated to URL");
        });

        And("Search for the keyword {string}", (String keyWord) -> {
            amazonHomePage = new AmazonHomePage(driver);
            String homePageTitle = amazonHomePage.getCurrentPageTitle();
            logger.info("Amazon home page loaded successfully, Page Title : " + homePageTitle);
            amazonSearchResultPage = amazonHomePage.searchForKeyword(keyWord);
        });

        Then("Select product number : {string}", (String productNumber) -> {
            String searchResultsPage = amazonSearchResultPage.getCurrentPageTitle();
            logger.info("Amazon search results page loaded successfully, Page Title : " + searchResultsPage);
            amazonProductsDetailsPage = amazonSearchResultPage.selectProduct(productNumber);
        });

        And("Check if the price is greater than {string} USD", (String amount) -> {
            amazonProductsDetailsPage.getCurrentPageTitle();
            String actualAmount = amazonProductsDetailsPage.getActualPrice();
            logger.info("Amount of the product selected: " + actualAmount);
            assertIfAmountIsGreater(BigDecimal.valueOf(Double.parseDouble(actualAmount.replaceAll("[^0-9\\.]", ""))), BigDecimal.valueOf(Double.parseDouble(amount)));
            logger.info("Product amount " + actualAmount + " is greater than $" + amount);
        });

        And("Close the browser", () -> {
            quitBrowser(driver);
            logger.info("Browser closed successfully");
        });
    }

}



