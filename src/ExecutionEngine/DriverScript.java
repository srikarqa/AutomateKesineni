package ExecutionEngine;

import Config.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ReporterConfig;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by rkunapareddy on 8/1/2016.
 */
public class DriverScript {
    public static Properties OR;
    public static WebDriver driver;

   @BeforeTest
    public static void LoadKesineni()throws Exception{
        driver=new FirefoxDriver();
       driver.manage().window().maximize();
        String Path_OR= Constants.OR_Path;
        FileInputStream fis=new FileInputStream(Path_OR);
        OR=new Properties(System.getProperties());
        OR.load(fis);
        driver.get(Constants.URL);
           }
    @Test
    public  static  void ClickAboutUS(){
        driver.findElement(By.id(OR.getProperty("tabAboutUs"))).click();
    }
    @AfterTest
    public static void closeDriver(){
        driver.quit();
    }
}
