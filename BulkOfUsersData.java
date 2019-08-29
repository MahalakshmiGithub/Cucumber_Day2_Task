package fis.del;

import java.util.List;
import java.util.Map;

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
		driver.manage().window().maximize();
	}

	@Given("User should click add Tariff Plans link")
	public void user_should_click_add_Tariff_Plans_link() {
		driver.findElement(By.xpath("//a[text()='Add Tariff Plan']")).click();
	}

	// ============================TWO DIMENSIONAL
	// LIST==========================================

	/*
	 * @When("User should enter the valid details") public void
	 * user_should_enter_the_valid_details(io.cucumber.datatable.DataTable
	 * dataTable) { System.out.println("when --1"); List <List<String>> tdlist =
	 * dataTable.asLists(String.class); System.out.println(tdlist);
	 * driver.findElement(By.id("rental1")).sendKeys(tdlist.get(0).get(0));
	 * driver.findElement(By.id("local_minutes")).sendKeys(tdlist.get(0).get(1))
	 * ;
	 * driver.findElement(By.id("inter_minutes")).sendKeys(tdlist.get(0).get(2))
	 * ; driver.findElement(By.id("sms_pack")).sendKeys(tdlist.get(1).get(3));
	 * driver.findElement(By.id("minutes_charges")).sendKeys(tdlist.get(1).get(4
	 * ));
	 * driver.findElement(By.id("inter_charges")).sendKeys(tdlist.get(2).get(5))
	 * ;
	 * driver.findElement(By.id("sms_charges")).sendKeys(tdlist.get(1).get(6));
	 * driver.findElement(By.xpath("//input[@name='submit']")).click();
	 * 
	 * }
	 */

	// ====================TWO DIMENSIONAL
	// MAP=======================================

	@When("User should enter the valid details")
	public void user_should_enter_the_valid_details(io.cucumber.datatable.DataTable dataTable) {
		System.out.println("when --1");
		List<Map<String, String>> tdmap = dataTable.asMaps(String.class, String.class);
		System.out.println(tdmap);
		driver.findElement(By.id("rental1")).sendKeys(tdmap.get(0).get("monrental"));
		driver.findElement(By.id("local_minutes")).sendKeys(tdmap.get(0).get("freelocmins"));
		driver.findElement(By.id("inter_minutes")).sendKeys(tdmap.get(0).get("freeintermins"));
		driver.findElement(By.id("sms_pack")).sendKeys(tdmap.get(1).get("freesmspck"));
		driver.findElement(By.id("minutes_charges")).sendKeys(tdmap.get(1).get("lperminchrge"));
		driver.findElement(By.id("inter_charges")).sendKeys(tdmap.get(2).get("Interperminchrger"));
		driver.findElement(By.id("sms_charges")).sendKeys(tdmap.get(1).get("smsperchrge"));
		driver.findElement(By.xpath("//input[@name='submit']")).click();

	}

	@Then("The text message should be generated")
	public void the_text_message_should_be_generated() {
		Assert.assertTrue(
				driver.findElement(By.xpath("//h2[text()='Congratulation you add Tariff Plan']")).isDisplayed());

	}

	/*
	 * @Given("User should click add Customer link") public void
	 * user_should_click_add_Customer_link() {
	 * 
	 * driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
	 * 
	 * }
	 */

	/*
	 * ==============SCENARIO OUTLINE=============
	 * 
	 * @When(
	 * "The users should enter the valid details{string},{string},{string},{string},{string}"
	 * ) public void the_users_should_enter_the_valid_details(String fname,
	 * String lname, String email, String address, String phone) {
	 * driver.findElement(By.xpath("//label[text()='Done']")).click();
	 * driver.findElement(By.id("fname")).sendKeys(fname);
	 * driver.findElement(By.id("lname")).sendKeys(lname);
	 * driver.findElement(By.id("email")).sendKeys(email);
	 * driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(address
	 * ); driver.findElement(By.id("telephoneno")).sendKeys(phone);
	 * driver.findElement(By.xpath("//input[@name='submit']")).click();
	 * 
	 * }
	 */

	/*
	 * ===========================ONE D LIST===============
	 * 
	 * @When("The users should enter the valid details") public void
	 * the_users_should_enter_the_valid_details(io.cucumber.datatable.DataTable
	 * dataTable) { System.out.println("When-1"); List<String> onedlist =
	 * dataTable.asList(String.class); System.out.println(onedlist);
	 * driver.findElement(By.xpath("//label[text()='Done']")).click();
	 * driver.findElement(By.id("fname")).sendKeys(onedlist.get(0));
	 * driver.findElement(By.id("lname")).sendKeys(onedlist.get(1));
	 * driver.findElement(By.id("email")).sendKeys(onedlist.get(2));
	 * driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(
	 * onedlist.get(3));
	 * driver.findElement(By.id("telephoneno")).sendKeys(onedlist.get(4));
	 * driver.findElement(By.xpath("//input[@name='submit']")).click();
	 * 
	 * }
	 */

	// ======================== ONE D MAP=========

	/*
	 * @When("The users should enter the valid details") public void
	 * the_users_should_enter_the_valid_details(io.cucumber.datatable.DataTable
	 * cust) { Map<String, String> onedmap = cust.asMap(String.class,
	 * String.class); System.out.println(onedmap);
	 * driver.findElement(By.xpath("//label[text()='Done']")).click();
	 * driver.findElement(By.id("fname")).sendKeys(onedmap.get("fname"));
	 * driver.findElement(By.id("lname")).sendKeys(onedmap.get("lname"));
	 * driver.findElement(By.id("email")).sendKeys(onedmap.get("email"));
	 * driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(onedmap
	 * .get("address"));
	 * driver.findElement(By.id("telephoneno")).sendKeys(onedmap.get("phoneno"))
	 * ; driver.findElement(By.xpath("//input[@name='submit']")).click();
	 * 
	 * }
	 */

	/*
	 * @Then("The id should be generated") public void
	 * the_id_should_be_generated() {
	 * Assert.assertTrue(driver.findElement(By.xpath(
	 * "(//td[@align='center'])[2]")).isDisplayed());
	 * 
	 * }
	 */

}
