package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragandDropImages {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.manage().window().maximize();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement image1 = driver.findElement(By.xpath("//li[1]"));
        WebElement box = driver.findElement(By.id("trash"));


        Actions act = new Actions(driver);
        act.dragAndDrop(image1,box).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.close();

    }
}
