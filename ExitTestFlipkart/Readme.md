# Flipkart Website Automation Suite Information:

#### Testng files description
* testng.xml: define the tests related to different pages across the site

#### Packages description
* com.ExitTestFlipkart.Pages- Defining all the pages actions and the respective object repository.
* com.ExitTestFlipkart.utils- Defining all the utilities needed for the tests.
* com.ExitTestFlipkart.tests- Defining all the pages tests and assertions.

#### Tests.java files description
**BaseTest** : The main class which defines-
* @BeforeMethod- to open the browser, to open url and get the name of the test
* @AfterMethd- to attach screenshot and to quit the browser
* @BeforeSuite- to set Extent
* @AfterSuite- to end the report

**FirstLoginThenOtherOperation** : logout , visit profile , super coin zone and clicking my cupons 
 
**HomePageTests** : top offers, mobiles, flipkart logo, flipkart stories, facebook, become a seller, hover over electronics and click gaming

**loginTest** : check with valid and invalid number and password

**MoreOptionTest** : hover over more option and clicking notification preference and customer service

**ProductPageTest**: searching an item, applying filter and adding an item to cart

**travelTest** : enter valid and invalid fromlocation and to location

## Important Note

- To change browser - change the browser in config.properties
 available drivers - chrome, firefox, microsoftedge, internet explorer
- To change mode - change the driver mode in config.properties
mode -  headless, non-headless

## Important Directory

- Drivers : ./Drivers/
- Report File : ./Reports/ExtentReports.html
- Log File : ./output/logs/
- Configuration File: ./Resources/config.properties
- Screenshots Folder: ./FailedTestsScreenshots/
- Test Data File : ./TestDataSheet/TestData.xlsx
