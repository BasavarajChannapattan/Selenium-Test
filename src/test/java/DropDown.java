import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDown {

    public WebDriver driver;
    @Test
    public void doDropDown(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Static dropdowns
         Select obj = new Select(driver.findElement(By.id("dropdown-class-example")));
         obj.selectByIndex(2);

       //dynamic dropdowns
        WebElement element = driver.findElement(By.cssSelector("#autocomplete"));
        element.sendKeys("India");
        //Wait for the dropdown load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown-class-example")));
        //List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item div"));
        List<WebElement> OPT = obj.getOptions();

        for (WebElement option : OPT)
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }


    }
}
