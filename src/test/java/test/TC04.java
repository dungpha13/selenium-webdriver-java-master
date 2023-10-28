package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


@Test
public class TC04 {
    public static void testcase02() {
        WebDriver driver = driverFactory.getChromeDriver();
        try {

            String sonyXperiaLocate = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a";
            String iphoneLocate = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a";
            String btnCompare = "button[title=Compare]";


            driver.get("http://live.techpanda.org/index.php/");

            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            WebElement productInfoIphoneImg = driver.findElement(By.cssSelector("#product-collection-image-2"));
            WebElement productInfoIphoneName = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='IPhone']"));
            WebElement productInfoIphonePrice = driver.findElement(By.cssSelector("span[id='product-price-2'] span[class='price']"));
            String infoIphoneImg = productInfoIphoneImg.getAttribute("src");
            String infoIphoneName = productInfoIphoneName.getText();
            String infoIphonePrice = productInfoIphonePrice.getText();

            WebElement productInfoSamsungXperiaImg = driver.findElement(By.cssSelector("#product-collection-image-1"));
            WebElement productInfoSamsungXperiaName = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='Sony Xperia']"));
            WebElement productInfoSamsungXperiaPrice = driver.findElement(By.cssSelector("span[id='product-price-1'] span[class='price']"));
            String infoSamsungImg = productInfoSamsungXperiaImg.getAttribute("src");
            String infoSamsungName = productInfoSamsungXperiaName.getText();
            String infoSamsungPrice = productInfoSamsungXperiaPrice.getText();


            WebElement sonyXperiaCompare = driver.findElement(By.xpath(sonyXperiaLocate));
            sonyXperiaCompare.click();

            WebElement iphoneCompare = driver.findElement(By.xpath(iphoneLocate));
            iphoneCompare.click();

            WebElement compareButton = driver.findElement(By.cssSelector(btnCompare));
            compareButton.click();

            Thread.sleep(5000);

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            WebElement comparePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div > div.page-title.title-buttons > h1")));

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            WebElement productInfoIphoneCompareImg = driver.findElement(By.cssSelector("img[alt='IPhone']"));
            WebElement productInfoIphoneCompareName = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='IPhone']"));
            WebElement productInfoIphoneComparePrice = driver.findElement(By.cssSelector("span[id='product-price-2-compare-list-top'] span[class='price']"));
            String imgLinkIphoneCompare = productInfoIphoneCompareImg.getAttribute("src");
            String nameIphoneCompare = productInfoIphoneCompareName.getText();
            String priceIphoneCompare = productInfoIphoneComparePrice.getText();

            WebElement productInfoSamsungXperiaCompareImg = driver.findElement(By.cssSelector("img[alt='Sony Xperia']"));
            WebElement productInfoSamsungXperiaCompareName = driver.findElement(By.cssSelector("h2[class='product-name'] a[title='Sony Xperia']"));
            WebElement productInfoSamsungXperiaComparePrice = driver.findElement(By.cssSelector("span[id='product-price-1-compare-list-top'] span[class='price']"));
            String imgLinkSamsungCompare = productInfoSamsungXperiaCompareImg.getAttribute("src");
            String nameSamsungCompare = productInfoSamsungXperiaCompareName.getText();
            String priceSamsungCompare = productInfoSamsungXperiaComparePrice.getText();

            WebElement closePopupButton = driver.findElement(By.xpath("//span[contains(text(),'Close Window')]"));
            closePopupButton.click();

//            assert infoIphoneImg.equals(imgLinkIphoneCompare) : "Not equal img iphone";
            assert infoIphoneName.equals(nameIphoneCompare) : "Not equal name iphone";
            assert infoIphonePrice.equals(priceIphoneCompare) : "Not equal price iphone";

//            assert infoSamsungImg.equals(imgLinkSamsungCompare) : "Not equal img samsung";
            assert infoSamsungName.equals(nameSamsungCompare) : "Not equal name samsung";
            assert infoSamsungPrice.equals(priceSamsungCompare) : "Not equal price samsung";

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 7. Quit browser session
        driver.quit();
    }
}
