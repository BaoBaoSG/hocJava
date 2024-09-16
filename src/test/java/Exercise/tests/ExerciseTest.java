package Exercise.tests;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.HomePage;
import utils.Constants;
public class ExerciseTest {
    WebDriver driver;
    HomePage homePage;
    private static final Logger logger = LogManager.getLogger(ExerciseTest.class);
    @Test
    public void TestCase() {
        //TC001
        logger.info("excecuting tcs001");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.HOME_URL);
        HomePage homePage = new HomePage(driver);
        homePage.verifyTitlePage();

        //TC002
        System.out.println();
        logger.info("excecuting tcs002");
        //Click Mobile button
        homePage.clickMobileButton();
        //Verify title screen mobile
        homePage.verifyScreenMobile();

        //TC003
        System.out.println();
        logger.info("excecuting tcs003");
        //Click filter by Name
        homePage.clickSortByName("Name");
        //Verify sortby alphabet
        homePage.verifySortByAlpha();

    }


}
