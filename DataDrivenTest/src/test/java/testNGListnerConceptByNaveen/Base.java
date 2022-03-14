package testNGListnerConceptByNaveen;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Base {
    public static WebDriver driver ;
    LocalDate dateOnly = LocalDate.now();
    LocalDateTime dateTime = LocalDateTime.now();

    public static void initialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.google.com");
    }

    public void failed(String testMethodName) throws IOException {
        String currentDateTime = dateTime.toString();
        String date = dateOnly.toString();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File(".\\screenshots\\"+"failed_"+"_"+testMethodName+
                "_"+ date+"_screen.png"));
    }
}
