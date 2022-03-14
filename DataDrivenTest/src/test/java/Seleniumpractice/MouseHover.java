package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.opencart.com");

        WebElement desktopMenu = driver.findElement(By.linkText("Desktops"));
        WebElement Mac = driver.findElement(By.xpath("//a[text()='Mac (1)']"));

        Actions act = new Actions(driver);
        act.moveToElement(desktopMenu).moveToElement(Mac).click().perform();


        driver.close();
    }
}
