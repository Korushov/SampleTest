import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

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

        System.out.println("Fill all required textboxes");
        webDriver.findElement(By.id("customer_firstname")).sendKeys("UserFirstName");
        webDriver.findElement(By.id("customer_lastname")).sendKeys("UserLastName");
        webDriver.findElement(By.id("passwd")).sendKeys("password");
        webDriver.findElement(By.id("address1")).sendKeys("Address");
        webDriver.findElement(By.id("city")).sendKeys("City");

        Select dropdownState = new Select(webDriver.findElement(By.id("id_state")));
        dropdownState.selectByValue("1");
        webDriver.findElement(By.id("postcode")).sendKeys("12345");
        Select dropdownCountry = new Select(webDriver.findElement(By.id("id_country")));
        dropdownCountry.selectByValue("21");

        webDriver.findElement(By.id("phone_mobile")).sendKeys("1112223344");
        webDriver.findElement(By.id("phone_mobile")).sendKeys(Keys.ENTER);

        System.out.println(webDriver.getCurrentUrl());
        System.out.println(webDriver.getTitle());

        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
