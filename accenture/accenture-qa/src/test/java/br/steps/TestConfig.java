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
    public void clickButton(By by){
        driver.findElement(by).click();

    }

    @Given("click in the button {string}")
    public void click_in_the_button(String element){
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

    @When("execute")
    public void executá_lo() throws InterruptedException {
        driver.get("https://demoblaze.com/");
        testConfig.clickButton(By.xpath("//a[text()='Laptops']"));
        testConfig.waitElementToClick("//*[@id=\"tbodyid\"]//a[contains(text(),\"MacBook air\")]");
        testConfig.waitElementToClick(("//*[@id=\"tbodyid\"]/div//a[contains(text(), \"Add to cart\")]"));
        testConfig.waitPresenceOfAlert();
        testConfig.clickButton(By.id("cartur"));
        testConfig.clickButton(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]//button[contains(text(),\"Place Order\" )]"));
        Thread.sleep(1000);
        testConfig.write(By.id("name"), "John Doe");
        testConfig.write(By.id("country"), "Portugal");
        testConfig.write(By.id("city"), "Lisbon");
        testConfig.write(By.id("card"), "375567668884617");
        testConfig.write(By.id("month"), "Month: 02");
        testConfig.write(By.id("year"), "2030");
        testConfig.waitElementToClick(("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
        //TODO PEGAR OS VALORES PRA  VALIDAÇÃO
        testConfig.waitElementToClick("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
//        //TODO ESSE PATH DEBAIXO
        testConfig.waitElementToClick("//div[@class='sa-confirm-button-container']//button");
        testConfig.waitElementToClick("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
        testConfig.clickButton(By.xpath("//a[text()='Home ']"));

    }







    public void waitElementToClick(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    public void write(By by, String value){
        driver.findElement(by).sendKeys(value);
    }

    public void waitPresenceOfAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
    }


    public WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yuri Ramalho Silva\\OneDrive\\Documentos\\testing\\accenture\\accenture-qa\\drivers");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yuri Ramalho Silva\\OneDrive\\Documentos\\testing\\accenture\\accenture-qa\\drivers");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @When("click in the laptops")
    public void clickInTheLaptops() {
        driver.findElement(By.xpath("//a[text()='Laptops']"));
    }

    @Then("the teste hass been passed")
    public void theTesteHassBeenPassed() {
    }

    @Given("open the google chrome page {string}")
    public void open_the_google_chrome_page(String page){
        driver.get(page);
    }
}
