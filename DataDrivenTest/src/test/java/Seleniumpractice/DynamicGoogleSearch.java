package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicGoogleSearch {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("q")).sendKeys("jungkook");

        List<WebElement> listOfSearchResult = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div//span"));
       // driver.findElement(By.xpath("//ul[@role='listbox']//li/descendant::div/span[text()='jungkook tattoo']")).click(); -- doesnt work

        System.out.println("List size is = "+listOfSearchResult.size());

        for (int i=0;i<listOfSearchResult.size();i++){
            System.out.println(listOfSearchResult.get(i).getText());

            if (listOfSearchResult.get(i).getText().contains("jungkook tattoo")){
                listOfSearchResult.get(i).click();
                break;
            }
        }
        driver.manage().window().maximize();

       // driver.close();
    }
}
