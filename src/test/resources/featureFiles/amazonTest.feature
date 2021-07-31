Feature: SiteCore Assignment

  Scenario Outline: : Goto "<URL>" to search "laptop" and check the is the first product is more than 100$ from product details window
    Given Setup "<BrowserName>" browser "<DriverPath>"
    When GoTo URL "<URL>"
    And Search for the keyword "<KeyWord>"
    Then Select product number : "<ProductNumber>"
    And Check if the price is greater than "<Amount>" USD
    And Close the browser

    Examples:
      | BrowserName | DriverPath                                      | URL                     | KeyWord | ProductNumber | Amount |
      | Chrome      | src/test/resources/driverFiles/chromedriver.exe | https://www.amazon.com/ | laptop  | 1             | 100    |


