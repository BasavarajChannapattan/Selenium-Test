import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindow {

    public WebDriver driver;

    @Test
    public void switchTab()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/popup.php");
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Set element " + s1);
        Iterator<String> i1 = s1.iterator();

        while(i1.hasNext()) {
            String childWindow = i1.next();
            if(!MainWindow.equalsIgnoreCase(childWindow))
            {
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
                driver.close();
            }
        }

        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);


    }
}
