package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.List;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        // Mouse Hover on Gear Menu

        mouseHoverToElement(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[7]"));
        // Click on Bags
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));

        clickOnElement(By.xpath("//strong[@class='product name product-item-name']//a[contains(text(),'Overnight Duffle ')]"));

        // Change Qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextToElement(By.id("qty"),"3");

        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyFromElement(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]" ),"You added Overnight Duffle to your shopping cart.");

        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Verify the product name ‘Overnight Duffle’
        verifyFromElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]"),"Overnight Duffle");

        // Verify the Qty is ‘3’
        WebElement element = driver.findElement(By.xpath("//div[@class='control qty']//input"));
        Assert.assertEquals("3", element.getAttribute("value"));

        //Verify the product price ‘$135.00
        element = driver.findElement(By.xpath("//td[@class='col subtotal']//span[@class='price']"));
        Assert.assertEquals("$135.00", element.getText());

        // Change Qty to ‘5’
        driver.findElement(By.xpath("//div[@class='control qty']//input")).clear();
        sendTextToElement(By.xpath("//div[@class='control qty']//input"),"5");

        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //Verify the product price ‘$225.00
        element = driver.findElement(By.xpath("//td[@class='col subtotal']//span[@class='price']"));
        Assert.assertEquals("$225.00", element.getText());

    }
}












