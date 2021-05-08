package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static Page.ProductPage.productPrice;

public class BasketPage<WebDriver> {
    private WebDriver driver;
    private WebDriverWait wait;


    public BasketPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait((org.openqa.selenium.WebDriver) driver, 30);
    }
    public void ComparePrices(){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(productPrice)));
        String productPriceBasket = driver.getClass(By.id(".real-discounted-price")).getText();
        Assert.assertEquals(productPriceBasket, productPrice);
        System.out.println("Ürün fiyatının doğruluğu karşılaştırıldı");
    }
    public void ChangeQuantity(){
        WebElement selectAmount;
        wait.until(ExpectedConditions.presenceOfElementLocated(selectAmount));
        WebElement selectAmount = driver.getClass(By.xpath("/html//div[@id='cart-items-container']/div//select[@class='amount']"));
        selectAmount.click();

        WebElement selectQuantity;
        wait.until(ExpectedConditions.presenceOfElementLocated(selectQuantity));
        WebElement selectQuantity = driver.getClass(By.xpath("//div[@class='products-container']/div/div//select[@class='amount']/option[@value='2']"));
        selectQuantity.click();
        driver.getClass(By.xpath("//div[@id='cart-items-container']//div[@class='product-group-box']/div[1]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("2")));
        String selectQuantity = driver.getClass(By.xpath("//div[@class='products-container']/div/div//select[@class='amount']/option[@value='2']")).getText();
        Assert.assertEquals(selectQuantity,"2");
        System.out.println("Adet arttırıldı ve 2 adet olduğu doğrulandı");
    }
    public void DeleteItems() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(3000));
        WebElement deleteButton = driver.getClass(By.xpath("//div[@class='row']/a[@title='Sil']/i[@class='gg-icon gg-icon-bin-medium']"));
        deleteButton.click();
        Thread.sleep(3000);
        String nullBasket = driver.getClass(By.cssSelector(".gg-w-22>h2")).getText();
        String text = "Sepetinizde ürün bulunmamaktadır.";
        Assert.assertEquals(nullBasket, text);
        System.out.println("Ürün sepetten silindi ve sepetin boş olduğu kontrol edildi");
    }
}