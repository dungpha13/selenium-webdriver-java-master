package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class TC02 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/");
            // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement btnMobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
            btnMobile.click();

            WebElement sonyXperiaPriceListPage = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span"));
            String priceInListPage = sonyXperiaPriceListPage.getText();

            WebElement btnSonyXperia = driver.findElement(By.linkText("SONY XPERIA"));
            btnSonyXperia.click();

            WebElement sonyXperiaPriceDetailPage = driver.findElement(By.className("price"));
            String priceInDetailPage = sonyXperiaPriceDetailPage.getText();

            assert priceInListPage.equals(priceInDetailPage) : "Not equal";
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
