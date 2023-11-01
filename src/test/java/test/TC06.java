package test;

import driver.driverFactory;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


@Test
public class TC06 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/");

            String myAccount = "div[class='footer'] a[title='My Account']";
            String myWishList = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a";
            String btnAddToCartLink = "button[title='Add to Cart']";
            String slcCountryLink = "country";
            String slcProvinceLink = "region_id";
            String postcodeLink = "postcode";
            String btnEstimateLink = "//*[@id=\"shipping-zip-form\"]/div/button/span/span";
            String verifyShippingCostLink = "s_method_flatrate_flatrate";
            String btnUpdateTotalLink = "//*[@id=\"co-shipping-method-form\"]/div/button/span/span";
            String totalPriceLink = "//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span";

            WebElement myAccountLink = driver.findElement(By.cssSelector(myAccount));
            myAccountLink.click();

            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("dung@gmail.com");

            WebElement pass = driver.findElement(By.id("pass"));
            pass.sendKeys("123456");

            WebElement btnLogin = driver.findElement(By.id("send2"));
            btnLogin.click();

            Thread.sleep(3000);

            WebElement myWishListLink = driver.findElement(By.xpath(myWishList));
            myWishListLink.click();

            WebElement btnAddToCart = driver.findElement(By.cssSelector(btnAddToCartLink));
            btnAddToCart.click();

            WebElement totalPrice = driver.findElement(By.xpath(totalPriceLink));
            String price = totalPrice.getText();
            System.out.println(price);

            WebElement slcCountry = driver.findElement(By.id(slcCountryLink));

            Select selectOption1 = new Select(slcCountry);

            selectOption1.selectByValue("US");

            WebElement slcProvince = driver.findElement(By.id(slcProvinceLink));

            Select selectOption2 = new Select(slcProvince);

            selectOption2.selectByValue("1");

            WebElement postcode = driver.findElement(By.id(postcodeLink));
            postcode.sendKeys("12345");

//            7. Click Estimate
            WebElement btnEstimate = driver.findElement(By.xpath(btnEstimateLink));
            btnEstimate.click();

            Thread.sleep(2000);

            WebElement verifyShippingCost = driver.findElement(By.id(verifyShippingCostLink));
            verifyShippingCost.click();

            Thread.sleep(2000);

            WebElement btnUpdateTotal = driver.findElement(By.xpath(btnUpdateTotalLink));
            btnUpdateTotal.click();

            Thread.sleep(2000);

            WebElement totalPriceAfter = driver.findElement(By.xpath(totalPriceLink));
            String priceAfter = totalPriceAfter.getText();
            System.out.println(priceAfter);
//            8. Verify Shipping cost generated
//
//            9. Select Shipping Cost, Update Total
//
//            10. Verify shipping cost is added to total
//
//            11. Click "Proceed to Checkout"
//
//            12a. Enter Billing Information, and click Continue
//
//            12b. Enter Shipping Information, and click Continue
//
//            13. In Shipping Method, Click Continue
//
//            14. In Payment Information select 'Check/Money Order' radio button. Click Continue
//
//            15. Click 'PLACE ORDER' button
//
//            16. Verify Oder is generated. Note the order number

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
