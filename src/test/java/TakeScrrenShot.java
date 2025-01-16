import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class TakeScrrenShot {

public static WebDriver driver;
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");;
        //driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //canvas[@aria-label='Scan this QR code to link a device!']")));

        TakesScreenshot screenshot = (TakesScreenshot)driver;
       // driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./Screenshots/WHATSAPP.png"));
        System.out.println("Screenshot is captured");
        driver.quit();
    }
}
