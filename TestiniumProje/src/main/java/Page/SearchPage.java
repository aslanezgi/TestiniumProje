package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {

        this.driver = driver;
    }

    public void SearchPage(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, 7000)");


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        WebElement secondPageButton  = driver.findElement(By.xpath("//div[@id='best-match-right']/div[5]/ul/li[2]/a"));
        secondPageButton.click();

        String secondPageUrl = "https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2";
        String urlControl = driver.getCurrentUrl();

        Assert.assertEquals(secondPageUrl , urlControl);
        System.out.println("2.sayfanın açıldığını kontrol ettim.");

        WebElement products = driver.findElement(By.xpath("//div[@id='best-match-right']/div[3]/div[2]/ul/li[1]/a"));
        products.click();
    }
}
