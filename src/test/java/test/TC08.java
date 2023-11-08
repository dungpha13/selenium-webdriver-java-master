package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Random;


@Test
public class TC08 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/");

            String emailAddress = "dung130903@gmail.com";
            String password = "123456";
            String myAccountLink = "div[class='footer'] a[title='My Account']";
            String reOrderLink = ".link-reorder";
            String qtyInputLink = "input[title='Qty']";
            String grandTotalLink = "strong span[class='price']";
            String btnUpdateLink = "button[title='Update'] span span";
            String btnCheckoutLink = "li[class='method-checkout-cart-methods-onepage-bottom'] button[title='Proceed to Checkout'] span span";
            String btnContinueBillingLink = "button[onclick='billing.save()'] span span";
            String btnContinueShippingLink = "button[onclick='shippingMethod.save()'] span span";
            String radioPaymentLink = "label[for='p_method_checkmo']";
            String btnContinuePaymentLink = "button[onclick='payment.save()'] span span";
            String btnPlaceOrderLink = "button[title='Place Order'] span span";
            String orderIdLink = "//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a";

            WebElement myAccount = driver.findElement(By.cssSelector(myAccountLink));
            myAccount.click();

            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys(emailAddress);

            WebElement pass = driver.findElement(By.id("pass"));
            pass.sendKeys(password);

            WebElement btnLogin = driver.findElement(By.id("send2"));
            btnLogin.click();

            Thread.sleep(2000);

            WebElement reOrder = driver.findElement(By.cssSelector(reOrderLink));
            reOrder.click();

            Thread.sleep(2000);

            WebElement grandTotalBefore = driver.findElement(By.cssSelector(grandTotalLink));
            String grandTotalBeforeValue = grandTotalBefore.getText();
//            System.out.println(grandTotalBefore.getText());

            Thread.sleep(2000);

//            String.valueOf(new Random(5).nextInt() + 1)
            WebElement qtyInput = driver.findElement(By.cssSelector(qtyInputLink));
            qtyInput.click();
            qtyInput.clear();
            qtyInput.sendKeys("6");

            Thread.sleep(2000);

            WebElement btnUpdate = driver.findElement(By.cssSelector(btnUpdateLink));
            btnUpdate.click();

            Thread.sleep(2000);

            WebElement grandTotalAfter = driver.findElement(By.cssSelector(grandTotalLink));
            String grandTotalAfterValue = grandTotalAfter.getText();
//            System.out.println(grandTotalAfter.getText());

            assert !grandTotalAfterValue.equalsIgnoreCase(grandTotalBeforeValue) : "Grand Total doesn't change";

            Thread.sleep(3000);

            WebElement btnCheckout = driver.findElement(By.cssSelector(btnCheckoutLink));
            btnCheckout.click();

            Thread.sleep(2000);

            WebElement btnContinue = driver.findElement(By.cssSelector(btnContinueBillingLink));
            btnContinue.click();

            Thread.sleep(2000);

            WebElement btnContinueShipping = driver.findElement(By.cssSelector(btnContinueShippingLink));
            btnContinueShipping.click();

            Thread.sleep(2000);

            WebElement radioPayment = driver.findElement(By.cssSelector(radioPaymentLink));
            radioPayment.click();

            Thread.sleep(2000);

            WebElement btnContinuePayment = driver.findElement(By.cssSelector(btnContinuePaymentLink));
            btnContinuePayment.click();

            Thread.sleep(2000);

            WebElement btnPlaceOrder = driver.findElement(By.cssSelector(btnPlaceOrderLink));
            btnPlaceOrder.click();

            Thread.sleep(2000);

            WebElement orderId = driver.findElement(By.xpath(orderIdLink));
            System.out.println(orderId.getText());

            Thread.sleep(2000);

            assert orderId.isDisplayed() : "Order not generated!";

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
