import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class DatePicker {

    public WebDriver driver;

    @Test
    public void pickTheCurrentDate() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");

        driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
        driver.findElement(By.xpath("//span[contains(normalize-space(text()), 'Departure')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@class, 'DayPicker-Day') and contains(@aria-label, 'Fri Jul 30 2021')]")).click();
    }
}

