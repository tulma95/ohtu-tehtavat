package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {

        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        element.submit();

//        passwordWrongTest(driver);
        newUserCreate(driver);
        logout(driver);
        driver.quit();

    }

    private static void logout(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
    }

    private static void newUserCreate(WebDriver driver) {
        Random r = new Random();

        driver.get("http://localhost:4567");

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("kalle1" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("kalle1kalle");

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("kalle1kalle");
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private static void passwordWrongTest(WebDriver driver) {
        driver.get("http://localhost:4567");

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep1");
        element = driver.findElement(By.name("login"));
        System.out.println(driver.getPageSource());
        sleep(2);
        element.submit();
        System.out.println(driver.getPageSource());

        sleep(3);
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
