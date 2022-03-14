package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandlingCookies {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");

        //How to capture cookies from browser?
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Size of cookies: "+cookies.size());

        //How to print cookies from browser?

    }
}
