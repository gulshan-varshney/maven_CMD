package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    
    private static final String URL = "http://127.0.0.1/login.do;jsessionid=agd8itgkeihm8";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "manager";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        try {
            long startTime = System.currentTimeMillis();
            int loginAttempts = 0;

            for (int i = 0; i < 10; i++) {
                long currentTime = System.currentTimeMillis();
                if ((currentTime - startTime) > 1000) {
                    throw new Exception("Exceeded time limit for 10 logins");
                }
                performLogin(driver);
                loginAttempts++;
            }

            // Check for the 11th login
            if ((System.currentTimeMillis() - startTime) <= 1000) {
                throw new Exception("Attempted to login more than 10 times in 1 second");
            }

            System.out.println("Test passed: Logged in 10 times in 1 second without issues");
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public static void performLogin(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        //Thread.sleep(1000); // Allow time for the page to load
        driver.findElement(By.name("username")).sendKeys(USERNAME);
        driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
        driver.findElement(By.id("loginButton")).click();
        driver.findElement(By.xpath("//a[@class='logout']")).click();
    }
}
