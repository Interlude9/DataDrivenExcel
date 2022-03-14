package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshots {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        //Full page screenshot
       /* TakesScreenshot ts = (TakesScreenshot) driver;

        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File(".\\screenshots\\homepage.png");
        FileUtils.copyFile(src,trg); */

        // Section screenshot or WebElement
        WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src = section.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\section.png");
        FileUtils.copyFile(src, trg);



        driver.close();
    }
}
