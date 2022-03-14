package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class StatusOfWebElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //isDisplayed() isEnabaled()

        driver.get("https://demo.nopcommerce.com/register");
        driver.manage().window().maximize();
        WebElement searchstore = driver.findElement(By.id("small-searchterms"));
        //isDisplayed and isEnabled()
        System.out.println("Search field is displayed: "+searchstore.isDisplayed());
        System.out.println("Search field is enabled: "+searchstore.isEnabled());

        //isSelected #checkbox, #radio buttons , dropdowns
        WebElement Mgender = driver.findElement(By.id("gender-male"));
        Mgender.click();
        System.out.println("Is Male gender selected: "+Mgender.isSelected());
        driver.close();
    }
}
