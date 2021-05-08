package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    WebDriver driver;

    public static String productPrice;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
    }
    public void AddToBasket(){


    productPrice = driver.findElement(By.xpath("//*[@id=\"sp-price-discountPrice\"]")).getText();
    JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, 600)");
    WebElement basket = driver.findElement(By.xpath("/html//button[@id='add-to-basket']"));
        basket.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    WebElement basketButton = driver.findElement(By.xpath("/html//div//a[@href='https://www.gittigidiyor.com/sepetim']"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        basketButton.click();
    }
}