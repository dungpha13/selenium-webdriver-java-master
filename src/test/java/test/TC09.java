package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Random;


@Test
public class TC09 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/");

            String btnMobileLink = "MOBILE";
            String btnAddToCartLink = "(//button[@title='Add to Cart'])[1]";
            String inputCouponLink = "coupon_code";
            String btnApplyLink = "button[title='Apply'] span span";
            String discountLink = "td[class='product-cart-price'] span[class='price']";
            String totalLink = "strong span[class='price']";

            WebElement btnMobile = driver.findElement(By.linkText(btnMobileLink));
            btnMobile.click();

            WebElement btnAddToCart = driver.findElement(By.xpath(btnAddToCartLink));
            btnAddToCart.click();

            Thread.sleep(2000);

            WebElement totalBefore = driver.findElement(By.cssSelector(totalLink));
            String totalBeforeValue = totalBefore.getText();

            WebElement inputCoupon = driver.findElement(By.id(inputCouponLink));
            inputCoupon.sendKeys("GURU50");

            Thread.sleep(2000);

            WebElement btnApply = driver.findElement(By.cssSelector(btnApplyLink));
            btnApply.click();

            Thread.sleep(2000);

            WebElement discount = driver.findElement(By.cssSelector(discountLink));

            assert discount.isDisplayed() : "Discount didn't generated";

            Thread.sleep(2000);

            WebElement totalAfter = driver.findElement(By.cssSelector(totalLink));
            String totalAfterValue = totalAfter.getText();

            assert !totalBeforeValue.equalsIgnoreCase(totalAfterValue) : "Price isn't discounted by 5%";

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
