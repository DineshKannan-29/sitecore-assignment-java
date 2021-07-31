package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.Utils.getPageTile;
import static utils.Utils.waitUntilElementToBeClickable;


public class AmazonHomePage {
    WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    WebElement homePageSearchBox;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchLink;


    public AmazonHomePage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentPageTitle() {
        return getPageTile(driver);
    }

    public AmazonSearchResultsPage searchForKeyword(String keyWord) {
        waitUntilElementToBeClickable(driver, homePageSearchBox);
        waitUntilElementToBeClickable(driver, searchLink);
        homePageSearchBox.sendKeys(keyWord);
        searchLink.click();
        return new AmazonSearchResultsPage(driver);
    }
}
