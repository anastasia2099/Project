package example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class SeleniumTest {
    WebDriver driver;
    @Test
    public void testMethod() {
        System.setProperty("webdriver.chrome.driver" , "D:\\hill\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://jira.hillel.it/login.jsp");
        driver.findElement(By.cssSelector("input[id='login-form-username']")).sendKeys("nastya.pinchuk");
        driver.findElement(By.cssSelector("input[id='login-form-password']")).sendKeys("8845690qa");
        driver.findElement(By.cssSelector("input[id='login-form-submit']")).sendKeys(Keys.ENTER);

        //Assert

        driver.findElement(By.cssSelector("li[id='user-options']")).click();
        driver.findElement(By.cssSelector("[id='view_profile']")).click();
        String actualName = driver.findElement(By.cssSelector("span[id='up-user-title-name']")).getText();
        String expectedName = "Anastasia Pinchuk";

        System.out.println(actualName);
        Assert.assertEquals(actualName, expectedName);
        }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }

}
