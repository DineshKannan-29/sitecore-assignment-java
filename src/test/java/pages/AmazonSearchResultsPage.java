package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.getPageTile;
import static utils.Utils.waitUntilElementToBeClickable;

public class AmazonSearchResultsPage {

    WebDriver driver;

    WebElement productLinkInSearchList;

    public AmazonSearchResultsPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public AmazonProductsDetailsPage selectFirstProduct(String productNumber) {
        productLinkInSearchList = driver.findElement(By.xpath("(//a[@class=\"a-link-normal a-text-normal\"])[" + productNumber + "]"));
        waitUntilElementToBeClickable(driver, productLinkInSearchList);
        productLinkInSearchList.click();
        return new AmazonProductsDetailsPage(driver);
    }

    public String getCurrentPageTitle() {
        return getPageTile(driver);
    }
}