package test;

import driver.driverFactory;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Random;


@Test
public class TC06 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/");

            String emailAddress = "dung130903@gmail.com";
            String password = "123456";
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
            String shippingLink = "//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span";
            String btnProceedCheckoutLink = "//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span/span";
            String firstNameLink = "billing:firstname";
            String lastNameLink = "billing:lastname";
            String addressLink = "billing:street1";
            String cityLink = "billing:city";
            String regionLink = "billing:region_id";
            String zipLink = "billing:postcode";
            String countryLink = "billing:country_id";
            String phoneLink = "billing:telephone";
            String btnCountinue = "//*[@id=\"billing-buttons-container\"]/button/span/span";
            String btnCountinueShipping = "//*[@id=\"shipping-method-buttons-container\"]/button/span/span";
            String checkMoneyOrderLink = "//*[@id=\"dt_method_checkmo\"]/label";
            String btnCountinuePaymentLink = "//*[@id=\"payment-buttons-container\"]/button/span/span";
            String btnPlaceOrderLink = "//*[@id=\"review-buttons-container\"]/button/span/span";
            String verifyOrderLink = "//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a";

            WebElement myAccountLink = driver.findElement(By.cssSelector(myAccount));
            myAccountLink.click();

            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys(emailAddress);

            WebElement pass = driver.findElement(By.id("pass"));
            pass.sendKeys(password);

            WebElement btnLogin = driver.findElement(By.id("send2"));
            btnLogin.click();

            Thread.sleep(3000);

            WebElement myWishListLink = driver.findElement(By.xpath(myWishList));
            myWishListLink.click();

            WebElement btnAddToCart = driver.findElement(By.cssSelector(btnAddToCartLink));
            btnAddToCart.click();

            float totalPriceBefore = Float.parseFloat(driver.findElement(By.xpath(totalPriceLink)).getText().substring(1));

            WebElement slcCountry = driver.findElement(By.id(slcCountryLink));
            Select selectOption1 = new Select(slcCountry);
            selectOption1.selectByValue("US");

            WebElement slcProvince = driver.findElement(By.id(slcProvinceLink));
            Select selectOption2 = new Select(slcProvince);
            selectOption2.selectByValue("1");

            WebElement postcode = driver.findElement(By.id(postcodeLink));
            postcode.sendKeys("12345");

            WebElement btnEstimate = driver.findElement(By.xpath(btnEstimateLink));
            btnEstimate.click();

            Thread.sleep(2000);

            WebElement verifyShippingCost = driver.findElement(By.id(verifyShippingCostLink));
            verifyShippingCost.click();

            Thread.sleep(2000);

            WebElement btnUpdateTotal = driver.findElement(By.xpath(btnUpdateTotalLink));
            btnUpdateTotal.click();

            Thread.sleep(2000);

            WebElement shippingCostElement = driver.findElement(By.xpath(shippingLink));

            assert shippingCostElement.isDisplayed() : "Not generated shippingCostElement";

            float shippingCost = Float.parseFloat(shippingCostElement.getText().substring(1));

            float totalPriceAfter = Float.parseFloat(driver.findElement(By.xpath(totalPriceLink)).getText().substring(1));

            assert totalPriceBefore + shippingCost == totalPriceAfter : "Not equal";

            WebElement btnProceedCheckout = driver.findElement(By.xpath(btnProceedCheckoutLink));
            btnProceedCheckout.click();

            driver.findElement(By.id(firstNameLink)).sendKeys(new RandomString(10).nextString());
            driver.findElement(By.id(lastNameLink)).sendKeys(new RandomString(10).nextString());
            driver.findElement(By.id(addressLink)).sendKeys(new RandomString(10).nextString());
            driver.findElement(By.id(cityLink)).sendKeys(new RandomString(10).nextString());

            WebElement sltState = driver.findElement(By.id(regionLink));
            Select selectOption3 = new Select(sltState);
            selectOption3.selectByValue("1");

            driver.findElement(By.id(zipLink)).sendKeys("12345");

            WebElement sltCountry = driver.findElement(By.id(countryLink));
            Select selectOption4 = new Select(sltCountry);
            selectOption4.selectByValue("US");

            driver.findElement(By.id(phoneLink)).sendKeys("0123456789");

            driver.findElement(By.xpath(btnCountinue)).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath(btnCountinueShipping)).click();

            Thread.sleep(2000);


            driver.findElement(By.xpath(checkMoneyOrderLink)).click();

            Thread.sleep(2000);


            driver.findElement(By.xpath(btnCountinuePaymentLink)).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath(btnPlaceOrderLink)).click();

            Thread.sleep(2000);

            WebElement verifyOrder = driver.findElement(By.xpath(verifyOrderLink));
            System.out.println(verifyOrder.getText());
            assert verifyOrder.isDisplayed() : "Generated order fail";

//            new RandomString(10).nextString()

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
