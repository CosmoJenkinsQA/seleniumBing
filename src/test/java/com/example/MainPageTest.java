package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @BeforeEach
    public void wellcome(){
        System.out.println("Thanks for watching my test ");
    }

    @Test
    public void search() throws InterruptedException {

        driver.navigate().to("https://www.avito.ru/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement searchField = driver.findElement(By.cssSelector("#sb_form_q"));
        searchField.sendKeys("Test");
        Thread.sleep(3000);
        searchField.submit();
        Thread.sleep(3000);


        WebElement searchPageField = driver.findElement(By.cssSelector("#sb_form_q"));
        assertEquals("Test", searchPageField.getAttribute("value"));

    }
}


