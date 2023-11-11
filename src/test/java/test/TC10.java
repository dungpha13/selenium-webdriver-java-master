package test;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Test
public class TC10 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            String inputUsernameLink = "username";
            String inputPasswordLink = "login";
            String username = "user01";
            String password = "guru99com";
            String btnLoginLink = "form-button";
            String btnCloseLink = "a[title='close'] span";
            String btnSalesLink = "//span[normalize-space()='Sales']";
            String ordersTabLink = "//span[normalize-space()='Orders']";
            String inputFormDateLink = "created_at[from]";
            String inputToDateLink = "created_at[to]";
            String btnSearchLink = "button[id='id_5cf8d2f5126f705c6b0944fbfc959fc8'] span span span0";


            WebElement inputUsername = driver.findElement(By.id(inputUsernameLink));
            inputUsername.sendKeys(username);

            WebElement inputPassword = driver.findElement(By.id(inputPasswordLink));
            inputPassword.sendKeys(password);

            WebElement btnLogin = driver.findElement(By.className(btnLoginLink));
            btnLogin.click();

            Thread.sleep(2000);

            WebElement btnClose = driver.findElement(By.cssSelector(btnCloseLink));
            btnClose.click();

            WebElement btnSales = driver.findElement(By.xpath(btnSalesLink));
            btnSales.click();

            Thread.sleep(2000);

            WebElement salesTab = driver.findElement(By.xpath(ordersTabLink));
            salesTab.click();

            Thread.sleep(2000);

            WebElement inputFromDate = driver.findElement(By.name(inputFormDateLink));
            inputFromDate.sendKeys("11/1/2023");

            WebElement inputToDate = driver.findElement(By.name(inputToDateLink));
            inputToDate.sendKeys("11/7/2023");

            Thread.sleep(2000);

            WebElement btnSearch = driver.findElement(By.cssSelector(btnSearchLink));
            btnSearch.click();

            Thread.sleep(2000);

            if (driver instanceof TakesScreenshot) {
                TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
                File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

                try {
                    // Specify the path where you want to save the screenshot
                    File destination = new File("path/to/save/screenshot.png");
                    FileUtils.copyFile(screenshot, destination);
                    System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Driver does not support taking screenshots.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
