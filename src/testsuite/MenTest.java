package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));

       // Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));

       // Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //Mouse Hover on product name , ‘Cronus Yoga Pant’ and click on size 32.
       // selectByValueFromDropDown(By.xpath("//select[@id='sorter']"),"product name");

        selectByValueFromDropDown(By.xpath("//select[@id='sorter']"), "name");

        // Mouse Hover on product name
        //‘Cronus Yoga Pant’ and click on size
        //32.
        mouseHoverToElement(By.xpath("//strong[@class='product name product-item-name']//a[@class='product-item-link']"));

        // Click on Pants
        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

        clickOnElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        mouseHoverToElement(By.xpath("//div[@data-product-id='880']"));

        //clickOnElement(By.xpath("//div[@class='product actions product-item-actions']//button[@class='action tocart primary']"));
        clickOnElement(By.xpath("//form[@action='https://magento.softwaretestingboard.com/checkout/cart/add/uenc/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9tZW4vYm90dG9tcy1tZW4vcGFudHMtbWVuLmh0bWw_cHJvZHVjdF9saXN0X29yZGVyPW5hbWU%2C/product/880/']//button[@class='action tocart primary']"));

        List<WebElement> multiElement = driver.findElements(By.xpath("//div[@class='message-success success message']"));

        System.out.println("Total Items are: " + multiElement.size());
        for (WebElement list : multiElement) {
            String name1 = list.getText();
            System.out.println(name1);
            Assert.assertEquals("You added Cronus Yoga Pant to your shopping cart.", name1);
        }

        clickOnElement(By.xpath("//div[@class='page messages']//a[contains(text(),'shopping cart')]"));

        verifyFromElement(By.xpath("//main[@id='maincontent']//h1"), "Shopping Cart");

//        List<WebElement> mElement = driver.findElements(By.xpath("//main[@id='maincontent']//h1"));
//        for (WebElement list : mElement) {
//            String name1 = list.getText();
//            System.out.println(name1);
//            Assert.assertEquals("Shopping Cart", name1);
//        }

        verifyFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");
        verifyFromElement(By.xpath("//dd[contains(text(),'32')]"), "32");
        verifyFromElement(By.xpath("//dd[contains(text(),'Black')]"), "Black");

    }



}
