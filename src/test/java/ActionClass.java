import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class ActionClass {


    @Test
    public void Action(){

        System.setProperty("webdriver.gecko.driver","D:\\drive\\geckodriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Action
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(By.className("logoClass"))).perform();
        action.contextClick(driver.findElement(By.className("logoClass"))).perform();
    }
}
