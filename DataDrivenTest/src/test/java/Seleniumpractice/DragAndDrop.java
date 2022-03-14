package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();

        WebDriver driver  =new EdgeDriver();
        driver.get("http://dhtmlgoodies.com/packages/dhtml-suite-for-applications/demos/demo-drag-drop-3.html");

        WebElement Oslo = driver.findElement(By.xpath("//div[@class='dragableBox' and @id='box1']"));

        WebElement Norway = driver.findElement(By.xpath("//div[@class='dragableBoxRight' and @id='box101']"));
        Actions act = new Actions(driver);
        act.dragAndDrop(Oslo,Norway).perform();

        driver.close();




    }
}
