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
public class TC07 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/");

            String emailAddress = "dung130903@gmail.com";
            String password = "123456";
            String myAccountLink = "div[class='footer'] a[title='My Account']";
//            String myOrderLink = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a/strong";
            String myOrderLink = "a[href='http://live.techpanda.org/index.php/sales/order/history/']";
            String viewOrderLink = "a[href='http://live.techpanda.org/index.php/sales/order/view/order_id/20466/']";
            String printOrderLink = ".link-print";

            WebElement myAccount = driver.findElement(By.cssSelector(myAccountLink));
            myAccount.click();

            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys(emailAddress);

            WebElement pass = driver.findElement(By.id("pass"));
            pass.sendKeys(password);

            WebElement btnLogin = driver.findElement(By.id("send2"));
            btnLogin.click();

            Thread.sleep(2000);

            WebElement myOrder = driver.findElement(By.cssSelector(myOrderLink));
            myOrder.click();

            Thread.sleep(2000);

            WebElement viewOrder = driver.findElement(By.cssSelector(viewOrderLink));
            viewOrder.click();

            Thread.sleep(2000);

            WebElement printOrder = driver.findElement(By.cssSelector(printOrderLink));
            printOrder.click();

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
