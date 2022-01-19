package datadriventesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class datadriven {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Softwares\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void logintest(String user, String password, String expect){
        System.out.println(user+password);
    }

    @DataProvider(name = "LoginData")
    public String[][] loginData(){
        String[][] logindata = {
                {"adm.com","adm","Invalid"},
                {"admin.com","admin","Invalid"}
        };

        return logindata;
    }
    @AfterClass
    void tearDown(){
        driver.close();
    }


}
