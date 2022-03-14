package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        WebElement min_slider = driver.findElement(By.xpath("//span[1]"));

        System.out.println("Location of minslider : "+min_slider.getLocation());
        System.out.println("Hieght and width of the slider : "+min_slider.getSize());

        Actions action = new Actions(driver);
        action.dragAndDropBy(min_slider,100,0).perform();

        System.out.println("After moving Location of minslider : "+min_slider.getLocation());
        System.out.println("Hieght and width of the slider : "+min_slider.getSize());

        WebElement max_slider = driver.findElement(By.xpath("//span[2]"));
        System.out.println("Location of Maxslider : "+max_slider.getLocation());
        System.out.println("Height and width of the slider : "+max_slider.getSize());

        action.dragAndDropBy(max_slider,-100,0).perform();

        System.out.println("After sliding Location of maxslider : "+max_slider.getLocation());
        System.out.println("Hieght and width of the slider : "+max_slider.getSize());

        driver.close();

    }
}
