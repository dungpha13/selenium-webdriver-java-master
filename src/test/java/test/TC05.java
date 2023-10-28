package test;

import driver.driverFactory;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


@Test
public class TC05 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/");

            WebElement myAccountLink = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a"));
            myAccountLink.click();

            WebElement btnCreateAccount = driver.findElement(By.cssSelector("a[title='Create an Account'] span span"));
            btnCreateAccount.click();

            WebElement firstName = driver.findElement(By.id("firstname"));
            firstName.sendKeys("Dung");

            WebElement middlename = driver.findElement(By.id("middlename"));
            middlename.sendKeys("Anh Huy");

            WebElement lastName = driver.findElement(By.id("lastname"));
            lastName.sendKeys("Pham");

            WebElement email = driver.findElement(By.id("email_address"));
            email.sendKeys(new RandomString(5).nextString() + "@gmail.com");

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("password123");

            WebElement confirmPassword = driver.findElement(By.id("confirmation"));
            confirmPassword.sendKeys("password123");

            WebElement btnRegister = driver.findElement(By.cssSelector("button[title='Register'] span span"));
            btnRegister.click();

            Thread.sleep(3000);

            WebElement verifyRegistration = driver.findElement(By.cssSelector("li[class='success-msg'] ul li span"));
            assert verifyRegistration.isDisplayed() : "Register failed!";

            WebElement btnTVMenu = driver.findElement(By.linkText("TV"));
            btnTVMenu.click();

            WebElement btnAddToWishList = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a"));
            btnAddToWishList.click();

            WebElement btnShareWishList = driver.findElement(By.cssSelector("button[title='Share Wishlist'] span span"));
            btnShareWishList.click();

            WebElement emailShare = driver.findElement(By.id("email_address"));
            emailShare.sendKeys(new RandomString(5).nextString() + "@gmail.com");

            WebElement messageShare = driver.findElement(By.id("message"));
            messageShare.sendKeys(new RandomString(10).nextString());

            WebElement btnConfirm = driver.findElement(By.cssSelector("button[title='Share Wishlist'] span span"));
            btnConfirm.click();

            Thread.sleep(3000);

            WebElement verifyShareWishList = driver.findElement(By.cssSelector("li[class='success-msg'] ul li span"));
            assert  verifyShareWishList.isDisplayed() : "Share failed!";

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
