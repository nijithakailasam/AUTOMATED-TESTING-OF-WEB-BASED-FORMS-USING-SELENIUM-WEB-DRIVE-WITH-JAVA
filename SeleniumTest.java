package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("my-text-id")).sendKeys("John Doe");
        driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[2]/input")).sendKeys("password123");
        driver.findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[3]/textarea")).sendKeys("this is simple");

        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select")));
        Select s = new Select(dropdownElement);
        String str="2";
        s.selectByValue(str);

        WebElement inputElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > main > div > form > div > div:nth-child(2) > label:nth-child(2) > input")));
        inputElement.clear();
        inputElement.sendKeys("Seattle");

        WebElement fileInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > main > div > form > div > div:nth-child(2) > label:nth-child(3) > input")));
        fileInput.sendKeys("C:\\Users\\ACER\\Documents\\dhanush.java");

        WebElement defaultCheckbox = driver.findElement(By.id("my-check-2"));
        if(defaultCheckbox.isSelected())
        {
        	defaultCheckbox.click();
        }
        else {
        defaultCheckbox.click();
        }
        WebElement defaultRadio = driver.findElement(By.id("my-radio-2"));
        defaultRadio.click();

        WebElement submitBtn = driver.findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        submitBtn.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
