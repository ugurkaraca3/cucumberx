import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class StepDefinitions {
    WebDriver driver;
    @AfterStep
    public void tOut() throws InterruptedException {
        Thread.sleep(500);
    }
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Given("Browser is opened")
    public void browser_is_opened() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @When("GUI is opened")
    public void gui_is_opened() {
        driver.get("http://192.168.56.108:9080");

    }

    @When("Enter Username")
    public void enter_username() {
        driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys("default.5g@siemens.com" + Keys.TAB);
    }

    @When("Enter Password")
    public void enter_password() {
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("123456" + Keys.ENTER);
    }

    @When("Click Sign in")
    public void click_sign_in() {
        Assert.assertEquals(driver.getCurrentUrl(), "http://192.168.56.108:9080/app");
    }
}
