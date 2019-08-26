package fis.del;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BulkOfUsersData {
	public static WebDriver driver;

	@Given("User should launch the browser")
	public void user_should_launch_the_browser() {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\CucumberProect\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.demo.guru99.com/telecom/");
	}

	@Given("User should click add Customer link")
	public void user_should_click_add_Customer_link() {

		driver.findElement(By.xpath("//a[text()='Add Customer']")).click();

	}

	@When("The users should enter the valid details{string},{string},{string},{string},{string}")
	public void the_users_should_enter_the_valid_details(String fname, String lname, String email, String address,
			String phone) {
		driver.findElement(By.xpath("//label[text()='Done']")).click();
		driver.findElement(By.id("fname")).sendKeys(fname);
		driver.findElement(By.id("lname")).sendKeys(lname);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(address);
		driver.findElement(By.id("telephoneno")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@name='submit']")).click();

	}

	@Then("The id should be generated")
	public void the_id_should_be_generated() {
		Assert.assertTrue(driver.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());

	}

}
