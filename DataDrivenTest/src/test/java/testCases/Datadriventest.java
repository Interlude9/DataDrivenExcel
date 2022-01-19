package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Datadriventest {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Softwares\\drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test(dataProvider = "LoginData")
    public void logintest(String user, String password, String expect){
        driver.get("https://admin-demo.nopcommerce.com/login");
        WebElement txtmail = driver.findElement(By.id("Email"));
        txtmail.clear();
        txtmail.sendKeys(user);
        WebElement txtpasswd = driver.findElement(By.id("Password"));
        txtpasswd.clear();
        txtpasswd.sendKeys(password);
        WebElement Lbutton = driver.findElement(By.cssSelector("button[type='submit']"));
        Lbutton.click();
        String expected_title = "Dashboard / nopCommerce administration";
        String act_title = driver.getTitle();

        if (expect.equals("Valid")){
            if(expected_title.equals(act_title)){
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(true);
            }
            else {
                Assert.assertTrue(false);
            }
        }
        else if (expect.equals("Invalid")){
            if (expected_title.equals(act_title)){
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(false);
            }
            else {
                Assert.assertTrue(true);
            }
        }
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() throws IOException {
        /*String[][] logindata = {
                {"admin@yourstore.com","admin","Valid"},
                {"admin@gmail.com","admin1","Invalid"},
                {"admin@yourstore.com","admn","Invalid"},
                {"admn@yourstore.com","admin","Invalid"},
        };*/

        //get the data from excel
        String path = ".\\datafiles\\loginData.xlsx";
        excelutility xutils = new excelutility(path);
        int totalrows=xutils.getRowCount("Sheet1");
        int totalcols=xutils.getCellCount("Sheet1",1);

        String logindata[][]= new String[totalrows][totalcols];

        for(int i=1; i<=totalrows;i++){

            for (int j = 0; j < totalcols; j++) {
                logindata[i-1][j]=xutils.getCellData("Sheet1",i,j);
            }
        }
        return logindata;
    }
    @AfterClass
    void tearDown(){
        driver.close();
    }


}
















