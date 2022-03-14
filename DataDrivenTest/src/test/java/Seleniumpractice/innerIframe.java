package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class innerIframe {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.automationtesting.in/Frames.html");
        driver.findElement(By.linkText("Iframe with in an Iframe")).click();
        WebElement outerIframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outerIframe);

        WebElement innerIframe = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(innerIframe);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Welcome");

        driver.close();
    }
}
