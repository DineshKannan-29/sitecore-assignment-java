package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.getPageTile;
import static utils.Utils.waitUntilVisibilityOfElement;

public class AmazonProductsDetailsPage {
    WebDriver driver;

    @FindBy(id = "price_inside_buybox")
    WebElement actualPriceOfProduct;

    public AmazonProductsDetailsPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public String getActualPrice() {
        waitUntilVisibilityOfElement(driver, actualPriceOfProduct);
        return actualPriceOfProduct.getText();
    }

    public String getCurrentPageTitle() {
        return getPageTile(driver);
    }
}
