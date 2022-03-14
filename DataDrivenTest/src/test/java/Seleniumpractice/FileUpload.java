package Seleniumpractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUpload {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException,AWTException  {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();

        driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");
//1. Pass the path of file in SendKeys -- this will work if type=file for the Upload button.
      //  driver.findElement(By.xpath("dfsf")).sendKeys("D:\\Shloka Docs\\Tanvi Docs\\ETC\\Age_Declaration_Form.pdf");

        //2.  Using Robot class and StringSelection class

        Actions act = new Actions(driver);
        WebElement uploadButton=driver.findElement(By.id("fileupload1"));
        act.moveToElement(uploadButton).click().perform();
        String filePath="D:\\Shloka Docs\\Tanvi Docs\\ETC\\Age_Declaration_Form.pdf";
        Thread.sleep(2000);
        uploadFile(filePath);
        driver.quit();

    }

    public static void setClipBoard(String file){
        StringSelection obj = new StringSelection(file);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj,null);

    }
    public static void uploadFile(String filepath) throws AWTException {
        setClipBoard(filepath);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }
}
