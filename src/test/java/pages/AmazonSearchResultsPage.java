package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.StepDefinitions;

import java.util.List;

import static utils.Utils.getPageTile;
import static utils.Utils.waitUntilElementToBeClickable;

public class AmazonSearchResultsPage {

    WebDriver driver;

    WebElement productLinkInSearchList;

    private static final Logger logger = LogManager.getLogger(AmazonSearchResultsPage.class);

    public AmazonSearchResultsPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public AmazonProductsDetailsPage selectProduct(String productNumber) {
        List<WebElement> searchList = driver.findElements(By.xpath("//a[@class=\"a-link-normal a-text-normal\"]"));
        logger.info("Total products retrieved in search : "+searchList.size());
        if (Integer.parseInt(productNumber) <= (searchList.size())){
            productLinkInSearchList = driver.findElement(By.xpath("(//a[@class=\"a-link-normal a-text-normal\"])[" + productNumber + "]"));
            waitUntilElementToBeClickable(driver, productLinkInSearchList);
            productLinkInSearchList.click();
        } else {
            throw new RuntimeException("Could not find the product number : "+productNumber+" from the search list since search result contains only "+ (searchList.size()) +" products");
        }

        return new AmazonProductsDetailsPage(driver);
    }

    public String getCurrentPageTitle() {
        return getPageTile(driver);
    }
}