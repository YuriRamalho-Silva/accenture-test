package br.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestConfig {

    private WebDriver driver;
    private TestConfig testConfig;
    private WebDriverWait wait;

    public TestConfig(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Given("click in the button 2")
    public void clickButton(By by) {
        driver.findElement(by).click();

    }

    @Given("click in the button {string}")
    public void click_in_the_button(String element) {
        driver.findElement(By.xpath(element)).click();

    }

    @Given("my daughter wants a new laptop")
    public void my_daughter_wants_a_new_laptop() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yuri Ramalho Silva\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        testConfig = new TestConfig(driver, wait);
        driver.manage().window().maximize();

    }


    public void waitElementToClick(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    public void write(By by, String value) {
        driver.findElement(by).sendKeys(value);
    }

    public void waitPresenceOfAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
    }


    @When("click in the laptops")
    public void clickInTheLaptops() {
        driver.findElement(By.xpath("//a[text()='Laptops']"));
    }

    @Then("the teste hass been passed")
    public void theTesteHassBeenPassed() {
    }

    @Given("open the google chrome page {string}")
    public void open_the_google_chrome_page(String page) {
        driver.get(page);
    }
}
