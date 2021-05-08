import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Page.HomePage;
public class InitialTest {
    public WebDriver driver;
    protected static HomePage homePage;
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver.manage().window().maximize();
        options.addArguments("--disable-notifications");
        driver.get("https://www.gittigidiyor.com/");
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
