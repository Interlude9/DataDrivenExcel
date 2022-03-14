package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowSwitch {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();

        driver =new EdgeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
        driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
        driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();

        Set<String> handles = driver.getWindowHandles();
        RightWindow("Twitter",handles);
        driver.getTitle();
        OnParentWindow(parentWindow);

    }

    static boolean RightWindow(String windowTitle, Set<String> handles ){
        List<String> listHandles = new ArrayList<>(handles);
        for (String e :listHandles){
            driver.switchTo().window(e);
            if (driver.getTitle().contains(windowTitle)){
                System.out.println("Found the right window");
                return true;}
        }
         return false;
    }

    static void OnParentWindow(String parentWindow){
        driver.switchTo().window(parentWindow);
        System.out.println("Now we are in parent window!");
    }
}