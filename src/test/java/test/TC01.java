package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class TC01 {
    public static void testcase01() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("http://live.techpanda.org/index.php/");
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement btnMobile = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));

            btnMobile.click();

            WebElement slcSortBy = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));

            Select selectOption = new Select(slcSortBy);

            selectOption.selectByValue("http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");

            List<WebElement> list = driver.findElements(By.className("product-name"));

//            if (!isSorted(list)) {
                assert isSorted(list) : "List chưa được sort";
//            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }

    public static boolean isSorted(List<WebElement> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).getText().compareTo(list.get(i).getText()) > 0) {
                return false;
            }
        }
        return true;
    }
}
