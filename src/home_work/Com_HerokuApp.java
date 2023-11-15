package home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project - 3.
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */
public class Com_HerokuApp {


    // Static variables assign to call direct to main method
    static String browser = "Chrome";   //launch the Chrome browser as requested.
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Print the title
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);

        // Print the current Url
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        // Print the Page Source
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

        // FInd the element and lacate.
        WebElement userName = driver.findElement(By.id("username"));
        // Entered username
        userName.sendKeys("tomsmith");
        Thread.sleep(2500);

        // Find the element and locate.
        WebElement passWord = driver.findElement(By.id("password"));

        // Entered the password
        passWord.sendKeys("SuperSecretPassword!");
        Thread.sleep(2500);

        // Find the element and locate
        WebElement login = driver.findElement(By.className("radius"));
        // action to click the login button.
        login.click();
        Thread.sleep(5000);

        // Print the current Url
        String currentUrl1 = driver.getCurrentUrl();
        System.out.println(currentUrl1);

        // Refresh the page
        driver.navigate().refresh();
        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    }
}
