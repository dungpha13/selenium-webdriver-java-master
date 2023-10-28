package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class TC03 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/");

            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/button"));
            addToCartButton.click();

            WebElement qtyInput = driver.findElement(By.xpath("//input[@class='input-text qty']"));
            qtyInput.clear();
            qtyInput.sendKeys("1000");

            WebElement updateButton = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span"));
            updateButton.click();

            Thread.sleep(3000);

            WebElement errorMessage = driver.findElement(By.xpath("//p[@class='item-msg error']"));
            String expectedErrorMessage = "The requested quantity for \"Sony Xperia\" is not available.";
            assert errorMessage.getText().equalsIgnoreCase(expectedErrorMessage):"Not equals error quantity";

            WebElement emptyCartLink = driver.findElement(By.xpath("//*[@id=\"empty_cart_button\"]/span/span"));
            emptyCartLink.click();

            Thread.sleep(3000);

            WebElement emptyCartMessage = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1"));

            assert emptyCartMessage.getText().equalsIgnoreCase("SHOPPING CART IS EMPTY") : "Not equals empty cart";


        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
