import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium {
    public static void main(String[] args) throws InterruptedException {
        //Developer Written START
        System.setProperty("webdriver.chrome.driver","D:\\Software\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://the-internet.herokuapp.com/login";

        //Developer Written END

        String expectedTitle = "The Internet";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);  // THIS WILL GO TO THE INTERNET AND FETCH THE WEBSITE VIA SELENIUM WEB DRIVER INSTANCE

        // get the actual value of the title
        actualTitle = driver.getTitle();


        /*
         * Test Case 01:
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //#### TEST LOGIN ##//
        WebElement username =  driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement button = driver.findElement(By.className("radius"));

        //## SETTING USERNAME AND PASSWORD ##//
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        button.submit();

        Thread.sleep(6000);  // WE STOP UNTIL THE REQUEST GOES BEHIND THE SCENES AND COMEBACK

        String homeUrl = "https://the-internet.herokuapp.com/secure";

        String currentUrl = driver.getCurrentUrl();

        /*
         * Test Case 02:
         */
        if(currentUrl.contentEquals(homeUrl))
        {
            System.out.println("In home page");
        }
        else
        {
            System.out.println("Could not logged in");
        }

        /*
         * Test Case 03:
         */
        WebElement logoutButton = driver.findElement(By.className("button"));
        logoutButton.click();

        Thread.sleep(6000);
        currentUrl = driver.getCurrentUrl();
        if(currentUrl.contentEquals(baseUrl))
        {
            System.out.println("Back to login page");
        }
        else
        {
            System.out.println("Could not logout");
        }


        //Developer Written START
        //close Fire fox
        driver.close();
        //Developer Written END
    }
}
