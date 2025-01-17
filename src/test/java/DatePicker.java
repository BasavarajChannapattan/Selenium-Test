import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatePicker {

    public WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void pickTheCurrentDate() {
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeModal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
        closeModal.click();

        WebElement departureDate = driver.findElement(By.xpath("//span[contains(normalize-space(text()), 'Departure')]"));
        departureDate.click();

        String targetMonthYear = "December 2025";
        String targetDay = "18";


        WebElement monthYearCaption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'DayPicker-Caption')]")));

        while (true) {
            String displayedMonthYear = monthYearCaption.getText();
            if (displayedMonthYear.equals(targetMonthYear)) {
                break;
            } else {
                WebElement nextButton = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
                nextButton.click();
                monthYearCaption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'DayPicker-Caption')]")));
            }
        }

        WebElement dayElement = driver.findElement(By.xpath("//p[text()='" + targetDay + "']"));
        dayElement.click();
    }


}
