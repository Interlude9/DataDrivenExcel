package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchBrowser {
    //Chrome Browser

    public static void main(String[] args) {
        //Chrome browser
       /* System.setProperty("webdriver.chrome.driver","D:\\Softwares\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); */

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        //Driver Manager removes the need to download browser specific driver jars.Just add DriverManager dependency in pom


        driver.get("https://frontend.nopcommerce.com/");
        System.out.println("Website launched");
        System.out.println("Currenturl : "+driver.getCurrentUrl());
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector(".ico-register")).click();
        driver.close();

    }
}
