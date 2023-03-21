import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Scenario - DeleteAccount")
public class DeleteAccount_Functionality {
	
	//Declaration of the object webdriver
	public static WebDriver driver = null;
	public static String userID = "mngr483896";
	
	
	@BeforeAll
	public static void beforeALL() {
		//---------------------------
		//Setup Environment  --------
		//---------------------------
		//Set environment variable
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		//WebDriverManager will setup the chrome browser 
		WebDriverManager.chromedriver().setup();
		
		//Inicialize our virtual Browser
		driver = new ChromeDriver();
	}
	
	@BeforeEach
	public void beforeEach() {
		//block of code to be executed before each test case
		 
	}
	
	@AfterAll
	public static void afterAll() {
		//driver.quit(); 
		//driver.close();
	}
	
	/*@AfterEach
	public static void afterEach() {
		//block of code to be executed after each test case
		 * 
		 * 
	}*/
	
	
	@Test
	@Order(19)
	@DisplayName("Check results on entering valid Account Id.")
	public void tc019() throws InterruptedException {	
		
		//---------------------------
		//Test Steps ----------------
		//---------------------------
		
		//Click on delete account
		driver.get("https://demo.guru99.com/V4/manager/deleteAccountInput.php");
		Thread.sleep(4000);
		
		//Close the iframe - Privacy Police
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(4000);
		
		
		//Enter valid AccountID
		driver.findElement(By.name("accountno")).sendKeys("113807");
		Thread.sleep(3000);
		
		//Click on Submit
		driver.findElement(By.name("AccSubmit")).click();
		
		//Click on Alert
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		
		//----------------------------------------------
		//Expected Results: deleted with an appropriate message 
		//----------------------------------------------
		
		//error message
		driver.switchTo().alert().getText();
		
		String expectedResults = "deleted with an appropriate message";
		String actualResults = driver.switchTo().alert().getText();
		
		
		assertEquals(expectedResults,actualResults);
		
		System.out.println("TC019 - Test Passed!");
		
	}
	
	
	@Test
	@Order(20)
	@DisplayName("Check results on entering invalid Account ID")
	public void tc020() throws InterruptedException {
		
		//Test Steps
		
		//Click on delete account
		driver.get("https://demo.guru99.com/V4/manager/deleteAccountInput.php");
		
		//Close the iframe - Privacy Police
		Thread.sleep(4000);
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(4000);
		
		//Enter invalid AccountID
		driver.findElement(By.name("accountno")).sendKeys("123456");
		Thread.sleep(3000);
		
		//Click on Submit
		driver.findElement(By.name("AccSubmit")).click();
		
		//Click on Alert
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		//Check Results
		String expectedResults = "Account does not exist";
		String actualResults = driver.switchTo().alert().getText();
		
		//System.out.println(actualResults);
		
		assertEquals(expectedResults,actualResults);
		//assertTrue(actualResults.equals(expectedResults));
		
		System.out.println("TC020 - Test Passed!");
		
	}
	
	@Test
	@Order(21)
	@DisplayName("Check results leaving blank the field Account ID")
	public void tc021() throws InterruptedException {
		
		//Test Steps
		
		//Click on delete account
		driver.get("https://demo.guru99.com/V4/manager/deleteAccountInput.php");
				
		//Close the iframe - Privacy Police
		Thread.sleep(4000);
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
		Thread.sleep(4000);
				
		//Blank AccountID or Empty Account ID
		
				
		//Click on Submit
		driver.findElement(By.name("AccSubmit")).click();
				
		//Click on Alert
		Thread.sleep(3000);
		driver.switchTo().alert().getText();
				
		//Check Results
		String expectedResults = "Please fill all fields";
		String actualResults = driver.switchTo().alert().getText();
				
		//System.out.println(actualResults);
				
		assertEquals(expectedResults,actualResults);
		//assertTrue(actualResults.equals(expectedResults));
				
		System.out.println("TC021 - Test Passed!");
		
	}
	

}