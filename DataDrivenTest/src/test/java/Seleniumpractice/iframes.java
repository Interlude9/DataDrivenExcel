package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class iframes {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();

        driver.switchTo().frame("packageListFrame"); // name of the iframe
         /* 3 ways to get frame element
         driver.switchTo().frame(name of the frame/id of the frame)
         driver.switchTo().frame(WebElement)
         driver.switchTo.frame(index)
          */
        driver.findElement(By.xpath("//a[contains(text(),'org.openqa.selenium')]")).click();

        //Switch to main screen
        driver.switchTo().defaultContent();

        //SwitchTo second iframe
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("Alert"));
        driver.close();


    }
}
