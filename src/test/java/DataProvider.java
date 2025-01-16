import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DataProvider {


    public static WebDriver driver;

    @Test(dataProvider = "LoginData")
    public void login(String username, String password) {

        WebDriverManager.chromedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.quit();
    }


   @org.testng.annotations.DataProvider(name = "LoginData")
    public Object[][] LoginData() {

        return new Object[][]{
                {"standard_user", "secret_sauce" },
                {"locked_out_user", "secret_sauce" },
                {"problem_user", "secret_sauce" },
                {"performance_glitch_user", "secret_sauce" },
                {"error_user", "secret_sauce" },
                {"visual_user", "secret_sauce" }
        };
    }
}
