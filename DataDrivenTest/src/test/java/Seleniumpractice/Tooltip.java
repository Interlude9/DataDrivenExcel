package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tooltip {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/tooltip/");

        driver.switchTo().frame(0);
        WebElement inputbox = driver.findElement(By.id("age"));

        String tooltip = inputbox.getAttribute("title");

        System.out.println("tooltip text : "+tooltip);

        driver.close();
    }
}
