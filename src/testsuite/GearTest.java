package testsuite;

import Utility.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class GearTest extends Utility
{
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
//        //* Mouse Hover on Gear Menu
//        WebElement gearMenu = driver.findElement(By.xpath("//span[contains(text(),'Gear')]"));
//
//       //* Click on Bags
//        WebElement bags = driver.findElement(By.xpath("//span[contains(text(),'Bags')]"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(gearMenu).moveToElement(bags).click().build().perform();
        driver.navigate().to("https://magento.softwaretestingboard.com/gear/bags.html");

        //* Click on Product Name â€˜Overnight Duffleâ€™ * Verify the text â€˜Overnight Duffleâ€™
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        //* Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        sendTextToElement(By.xpath("//input[@id='qty']"),"3");

        //* Click on â€˜Add to Cartâ€™ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //* Verify the text â€˜You added Overnight Duffle to your shopping cart.â€™
        verifyTextElement("You added Overnight Duffle to your shopping cart.",By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        //* Click on â€˜shopping cartâ€™ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //* Verify the product name â€˜Overnight Duffleâ€™
        verifyTextElement("Overnight Duffle",By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));

        //* Verify the Qty is â€˜3â€™
        Thread.sleep(5000);
        verifyTextElement("3",By.xpath("//input[@id='cart-236433-qty']"));

        //* Verify the product price â€˜$135.00â€™
        verifyTextElement("$135.00",By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));

        // * Change Qty to â€˜5â€™
        driver.findElement(By.id("cart-236190-qty")).clear();
        sendTextToElement(By.xpath("//input[@id='cart-236190-qty']"),"5");

        //* Click on â€˜Update Shopping Cartâ€™ button
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //* Verify the product price â€˜$225.00â€™
        verifyTextElement("$225.00",By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"));



    }
    @After
    public void tearDown(){
        // closeBrowser();
    }


}
