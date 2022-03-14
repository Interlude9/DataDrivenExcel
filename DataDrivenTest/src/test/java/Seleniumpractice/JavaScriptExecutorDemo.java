package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

      /*  JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(Script,args); */
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();


        //flash

        //Drawing border and take screenshot

        /*WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        JavaScriptUtil.drawBorder(logo,driver);
        File src = logo.getScreenshotAs(OutputType.FILE);
        File trg = new File(".\\screenshots\\logoWithBorder.png");
        FileUtils.copyFile(src,trg);*/

        //Getting title of the page

        /*String title = JavaScriptUtil.getTitleByJS(driver);
        System.out.println(title);*/

        //click action using JS
        /*WebElement regLink = driver.findElement(By.linkText("Register"));
        JavaScriptUtil.clickElementByJS(regLink,driver);
        //Generate alert
        JavaScriptUtil.generateAlert(driver,"This is my Alert");*/

        //Refreshing the page
        JavaScriptUtil.refreshBrowserByJS(driver);

        //Scrolling down page
        JavaScriptUtil.scrollPageDown(driver);

        //Scroll up page
        JavaScriptUtil.scrollPageUp(driver);

        //Zoom page


    }
}
