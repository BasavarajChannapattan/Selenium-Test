import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragDrop {

    public WebDriver driver;
    @Test
    public void doDragging()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver= new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        WebElement sourceElement = driver.findElement(By.xpath("//img[@src='images/high_tatras3_min.jpg']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement targetElement = driver.findElement(By.id("#ui-widget-content ui-state-default ui-droppable"));


        //Action
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement, targetElement).perform();



    }
}
