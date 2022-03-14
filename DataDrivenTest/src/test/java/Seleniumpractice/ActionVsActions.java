package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionVsActions {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();

        WebDriver driver = new EdgeDriver();

        driver.get("https://www.myntra.com/");
        WebElement women = driver.findElement(By.xpath("//a[@data-group='women']"));

        Actions act = new Actions(driver);
        act.moveToElement(women).perform();

        Action action = act.moveToElement(women).build();
        action.perform();
    }
}
