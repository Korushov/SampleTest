import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class SomeTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        System.out.println("Open browser");
        webDriver = new SafariDriver();
        System.out.println("Go to the website");
        webDriver.get("http://automationpractice.com/");

    }

    @After
    public void cleanUp() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Test
    public void getName() {
        System.out.println(webDriver.getCurrentUrl());
        System.out.println(webDriver.getTitle());
    }

    @Test
    public void CreateAnAccount() {
        System.out.println("Push \"Sign in\"");
        String linkToRegistgerAccount = webDriver.findElement(By.xpath("//a[@title='Log in to your customer account']")).getAttribute("href");
        webDriver.get(linkToRegistgerAccount);
        int emailAtribute = (int)(Math.random()*1000);
        String email = "korushovv" + String.valueOf(emailAtribute) + "@mail.ru";
        System.out.println("Print the email");
        webDriver.findElement(By.id("email_create")).sendKeys(email);
        System.out.println("Push \"Enter\"");
        webDriver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(webDriver.getCurrentUrl());
        System.out.println(webDriver.getTitle());
        System.out.println("Fill all required textboxes");
        webDriver.findElement(By.id("customer_firstname")).sendKeys("User_first_name");
        webDriver.findElement(By.id("customer_lastname")).sendKeys("User_last_name");
        webDriver.findElement(By.id("passwd")).sendKeys("password");
        webDriver.findElement(By.id("address1")).sendKeys("Address");
        webDriver.findElement(By.id("city")).sendKeys("City");


    }
}
