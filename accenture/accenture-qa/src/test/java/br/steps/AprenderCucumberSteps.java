package br.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumberSteps {

	private WebDriver driver;
	private TestConfig testConfig;
	private WebDriverWait wait;
	public String price;

	@Given("my kids wants a new laptop")
	public void my_kids_wants_a_new_laptop() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yuri Ramalho Silva\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		testConfig = new TestConfig(driver, wait);
		driver.manage().window().maximize();

	}


	@Quando("insert the credit card")
	public void insert_the_credit_card() throws InterruptedException {
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

		testConfig.waitElementToClick("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");

		testConfig.waitElementToClick("//div[@class='sa-confirm-button-container']//button");

	}

	@Então("back to home")
	public void back_to_home() throws InterruptedException {
		testConfig.waitElementToClick("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
		testConfig.clickButton(By.xpath("//a[text()='Home ']"));

	}

	@Entao("a especificação deve finalizar com sucesso")
	public void a_especificação_deve_finalizar_com_sucesso() {

	}



	@And("add some new {string}")
	public void addSomeNew(String laptop) throws InterruptedException {
		driver.get("https://demoblaze.com/");
		testConfig.clickButton(By.xpath("//a[text()='Laptops']"));
		testConfig.waitElementToClick("//*[@id=\"tbodyid\"]//a[contains(text(),\"" + laptop + "\")]");
		Thread.sleep(1000);
		testConfig.waitElementToClick(("//*[@id=\"tbodyid\"]/div//a[contains(text(), \"Add to cart\")]"));
		testConfig.waitPresenceOfAlert();
	}

	@And("insert the credit details name: {string}, country: {string}, city: {string}, card: {string}, month: {string}, year: {string}")
	public void insertTheCreditDetailsNameContryCityCardMonthYear(String name, String country, String city, String card, String month, String year) throws InterruptedException {
		testConfig.clickButton(By.id("cartur"));
		Thread.sleep(1000);
		String price = driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]")).getText();
		testConfig.clickButton(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]//button[contains(text(),\"Place Order\" )]"));
		Thread.sleep(1000);
		testConfig.write(By.id("name"), name);
		testConfig.write(By.id("country"), country);
		testConfig.write(By.id("city"), city);
		testConfig.write(By.id("card"), card);
		testConfig.write(By.id("month"), month);
		testConfig.write(By.id("year"), year);
		testConfig.waitElementToClick(("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
		CheckThePurchaseInformations(price, card, name);
		//TODO PEGAR OS VALORES PRA  VALIDAÇÃO
		testConfig.waitElementToClick("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
//        //TODO ESSE PATH DEBAIXO
		testConfig.waitElementToClick("//div[@class='sa-confirm-button-container']//button");

	}


	public void CheckThePurchaseInformations(String price, String card, String name) {
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text()[1],\"Id\")]")).getText().contains("Id:"));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text()[1],\"Id\")]")).getText().contains(price));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text()[1],\"Id\")]")).getText().contains(card));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text()[1],\"Id\")]")).getText().contains(name));
		String teste = driver.findElement(By.xpath("//p[contains(text()[1],\"Id\")]")).getText();
		System.out.println(teste);

	}

	@And("insert the credit details name: {string}, country: {string}, city: {string}, but forgot the credit card parameters")
	public void insertTheCreditDetailsNameCountryCityButForgotTheCreditCardParameters(String name, String country, String city) throws InterruptedException {
		testConfig.clickButton(By.id("cartur"));
		testConfig.clickButton(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]//button[contains(text(),\"Place Order\" )]"));
		Thread.sleep(1000);
		testConfig.write(By.id("name"), name);
		testConfig.write(By.id("country"), country);
		testConfig.write(By.id("city"), city);
		testConfig.waitElementToClick(("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
		//TODO PEGAR OS VALORES PRA  VALIDAÇÃO

	}

	@Then("an alert appears")
	public void anAlertAppears() throws InterruptedException {
		Thread.sleep(1000);
        testConfig.waitPresenceOfAlert();

	}

	@And("card details are requested")
	public void cardDetailsAreRequested() {
		testConfig.write(By.id("card"), "4411732769254916");
		testConfig.write(By.id("month"), "4");
		testConfig.write(By.id("year"), "2029");
		testConfig.waitElementToClick(("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));
		//TODO PEGAR OS VALORES PRA  VALIDAÇÃO
		testConfig.waitElementToClick("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
//        //TODO ESSE PATH DEBAIXO
		testConfig.waitElementToClick("//div[@class='sa-confirm-button-container']//button");
		testConfig.waitElementToClick("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");

	}


	@And("close the application")
	public void closeTheApplication() {
		driver.quit();
	}
}
