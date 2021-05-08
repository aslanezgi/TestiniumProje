import Page.BasketPage;
import Page.HomePage;
import Page.ProductPage;
import Page.SearchPage;
import org.junit.Test;
    public class MainTest extends InitialTest{


    @Test
    public void TestiniumProje() throws InterruptedException {
    HomePage homePage = new HomePage(driver);
    homePage.Assertion();
    homePage.LoginCase();
    homePage.SearchAnElement();

    SearchPage search = new SearchPage(driver);
    search.SearchPage();

    ProductPage productPage = new ProductPage(driver);
    productPage.AddToBasket();

    BasketPage basketPage = new BasketPage(driver);
    basketPage.ComparePrices();
    basketPage.ChangeQuantity();
    basketPage.DeleteItems();
}
}
