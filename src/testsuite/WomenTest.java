package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //  mouseHoverToElementAndClick(By.linkText("Women"));
        // mouseHoverToElementAndClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        mouseHoverToElement(By.linkText("Tops"));

        clickOnElement(By.linkText("Jackets"));

        selectByValueFromDropDown(By.xpath("//select[@id='sorter']"), "price");

    }

    @Test
    public void verifyTheSortByPriceFilter() {
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[contains(text(),'Women')]"));
        mouseHoverToElement(By.linkText("Tops"));

        clickOnElement(By.linkText("Jackets"));
        selectByValueFromDropDown(By.xpath("//select[@id='sorter']"), "price");

       //Verify the products price display in Low to High
        List<WebElement> multiElement = driver.findElements(By.xpath("//span[@class='price-wrapper ']"));
        System.out.println("Total Items are: " + multiElement.size());
        double tmpValue = 0;
        for (WebElement list : multiElement) {
            String name1 = list.getText().replaceAll("[$]", "");
            System.out.println(name1);
            double itemValue = Double.valueOf(name1);
            Assert.assertTrue("products price display not in Low to High.", itemValue >= tmpValue);
            tmpValue = itemValue;
        }

    }
}