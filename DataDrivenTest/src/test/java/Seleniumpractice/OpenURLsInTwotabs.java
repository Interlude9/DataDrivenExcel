package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenURLsInTwotabs {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://jqueryui.com/tooltip/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

        driver.close();
    }
}
