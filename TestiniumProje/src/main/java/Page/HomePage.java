package Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver) { //constructor

        this.driver = driver;
    }
    public void Assertion(){
        Assert.assertEquals(driver.getTitle(), "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi");
    }
    public void LoginCase(){
        //Giriş sayfasına direk geçildi.
        driver.navigate().to("https://www.gittigidiyor.com/uye-girisi");

        // Kullanıcı adı girildi.
        WebElement username;
        username = driver.findElement(By.xpath("//*[@id='L-UserNameField']"));
        username.sendKeys("testezgideneme@gmail.com");
        // Kullanıcı şifresi girildi.
        WebElement password;
        password = driver.findElement(By.xpath("//*[@id='L-PasswordField']"));
        password.sendKeys("123456789");

        WebElement clicklogin = driver.findElement(By.xpath("//*[@id='gg-login-enter']"));
        clicklogin.click();

        WebElement logincontrol = driver.findElement(By.xpath("/html//header[@id='main-header']/div[3]/div/div/div/div[3]/div/div[1]/div[@title='Hesabım']/div[2]"));

        Assert.assertEquals(logincontrol.getText(),"Hesabım\n" +
                "testezgideneme");
    }
    public void SearchAnElement(){
        WebElement searchWord = driver.findElement(By.xpath("/html//header[@id='main-header']/div[3]/div/div/div//form[@action='https://www.gittigidiyor.com/arama']//input[@name='k']"));
        searchWord.sendKeys("Bilgisayar");

        WebElement searchbutton = driver.findElement(By.xpath("/html//header[@id='main-header']/div[3]/div/div/div//form[@action='https://www.gittigidiyor.com/arama']//button[@type='submit']"));
        searchbutton.click();
    }
    }