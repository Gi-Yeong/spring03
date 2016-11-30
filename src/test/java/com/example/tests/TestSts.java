package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestSts {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSts() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.linkText("로그인 페이지")).click();
        driver.findElement(By.id("id")).clear();
        driver.findElement(By.id("id")).sendKeys("root");
        driver.findElement(By.id("pw")).clear();
        driver.findElement(By.id("pw")).sendKeys("1111");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.findElement(By.id("id")).clear();
        driver.findElement(By.id("id")).sendKeys("admin");
        driver.findElement(By.id("pw")).clear();
        driver.findElement(By.id("pw")).sendKeys("1111");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.findElement(By.id("id")).clear();
        driver.findElement(By.id("id")).sendKeys("admin");
        driver.findElement(By.id("pw")).clear();
        driver.findElement(By.id("pw")).sendKeys("1234");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.findElement(By.linkText("입 력")).click();
        driver.findElement(By.name("sabun")).clear();
        driver.findElement(By.name("sabun")).sendKeys("6666");
        driver.findElement(By.name("name")).clear();
        driver.findElement(By.name("name")).sendKeys("test");
        driver.findElement(By.name("pay")).clear();
        driver.findElement(By.name("pay")).sendKeys("9090");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.findElement(By.linkText("test")).click();
        driver.findElement(By.linkText("수정")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("test2");
        driver.findElement(By.id("pay")).clear();
        driver.findElement(By.id("pay")).sendKeys("9999");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.findElement(By.xpath("(//a[contains(text(),'test2')])[2]")).click();
        driver.findElement(By.linkText("삭제")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
