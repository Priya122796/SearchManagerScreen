/**
 * 
 */
package testscripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twilio.rest.preview.sync.service.Document;

/**
 * @author priya
 *
 */
public class Searchmanager {
	public static WebDriver driver;
	static WebDriverWait wait;

	@Test
	public void initialize() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\priya\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addExtensions(new File("E:\\CORS3.crx"));
		// String pathToExtension =
		// "C:\\Users\\priya\\AppData\\Local\\Google\\Chrome\\User
		// Data\\Default\\Extensions\\lhobafahddgcelffkeicbaginigeejlf\\0.1.4_0";
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, co);
		driver = new ChromeDriver(dc);
		driver.manage().window().maximize();
		driver.get("chrome://extensions/shortcuts");
		Actions act = new Actions(driver);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).build().perform();
		// act.sendKeys(Keys.RETURN).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("1").build().perform();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_1);
		Thread.sleep(2000);

		driver.get("https://freeflowstorageqa.z33.web.core.windows.net/manage");
		Thread.sleep(20000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shanmathi@logicvalley.in");
		js.executeScript("document.getElementById('logonIdentifier').value='shanmathi@logicvalley.in';");
		System.out.println("Entering Login");
		// +12058946954
		// Shanmathi = Bohu3855
		//Nifaanya = Maco3129
		js.executeScript(" document.getElementById('password').value='Bohu3855';");
		System.out.println("Entering Password");
		js.executeScript("document.getElementById('next').click();");
		System.out.println("Clicking next");
		Thread.sleep(10000);
		// Sending for new Number

		// js.executeScript("document.getElementById('localNumber').value='4123124643';");
		// System.out.println("Entering number");
		js.executeScript("document.getElementById('verifyCode').click();");
		System.out.println("Sending Code");
		String OTP = TwilioSMS.ReciverOTP();
		System.out.println(OTP);
		Thread.sleep(4000);
		js.executeScript("document.getElementById('verificationCode').value ='" + OTP + "';");
		Thread.sleep(3000);
		js.executeScript("document.getElementById('verificationCode').click();");
		WebElement textbox = driver.findElement(By.xpath("//*[@id='verificationCode']"));
		textbox.sendKeys(Keys.ENTER);
		
		
		  //resend code Thread.sleep(2000);
		  js.executeScript("document.getElementById('retryCode').click();");
		  System.out.println("reSending Code"); Thread.sleep(6000); OTP =
		  TwilioSMS.ReciverOTP(); System.out.println(OTP); Thread.sleep(4000);
		  js.executeScript("document.getElementById('verificationCode').value ='" + OTP
		  + "';"); Thread.sleep(3000);
		  js.executeScript("document.getElementById('verificationCode').click();");
		  textbox.sendKeys(Keys.ENTER);
		  
		 
		System.out.println("Waiting until element visible");
		Thread.sleep(40000);
		/*
		 * js.executeScript(
		 * "document.querySelector(\"#root > div > div > div > div.search_page_grid > div.search_grid_root > div.search_filter_root > div:nth-child(2) > button:nth-child(2)\").click()"
		 * ); System.out.println("Found FPN"); Thread.sleep(1000); js.executeScript(
		 * "document.querySelector(\"#root > div > div > div > div.search_page_grid > div.search_grid_root > div.search_filter_root > div.FFButton_root.search_filter_fields > div > button\").click()"
		 * ); System.out.println("FPN Filter is clicked"); Thread.sleep(1000);
		 * js.executeScript(
		 * "document.querySelector(\"#root > div > div > div > div.search_page_grid > div.search_grid_root > div.search_filter_root > div:nth-child(2) > button:nth-child(1)\").click()"
		 * ); System.out.println("Found PCN"); Thread.sleep(1000); js.executeScript(
		 * "document.querySelector(\"#root > div > div > div > div.search_page_grid > div.search_grid_root > div.search_filter_root > div.FFButton_root.search_filter_fields > div > button\").click()"
		 * ); System.out.println("PCN Filter is clicked");
		 */
		/*
		 * js.executeScript(
		 * "document.querySelector(\"#root > div > div > div > div.search_page_grid > div.search_grid_root > div.search_filter_root > div:nth-child(3) > div > div > input\").click()"
		 * ); System.out.println("Dropdown clicked");
		 */
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@value='Licence']")).click();
		System.out.println("Extend start");
		js.executeScript("document.getElementsByClassName('sidebar-button')[0].click()");
		System.out.println("Extend End");
		js.executeScript(
				"document.querySelector(\"#root > div > div > div > div.sidebar.sidebar-open > div.sidebar-nav-items > ul > li:nth-child(3)\").click()");
		System.out.println("Clicked Admin");
		Thread.sleep(1000);
		// js.executeScript("document.querySelector(\"#root > div > div > div >
		// div.sidebar.sidebar-open > div.sidebar-nav-items > ul > div >
		// div\").click()");
		js.executeScript(
				"document.querySelector(\"#root > div > div > div > div.sidebar.sidebar-open > div.sidebar-nav-items > ul > div > div > a\").click()");
		// document.querySelector("#root > div > div > div > div.sidebar.sidebar-open >
		// div.sidebar-nav-items > ul > div > div > a")
		System.out.println("Roles clicked");
		Thread.sleep(5000);
		js.executeScript(
				"document.querySelector(\"#root > div > div > div > div.sidebar.sidebar-open > div.sidebar-nav-items > ul > li:nth-child(2) > span\").click()");
		Thread.sleep(2000);
		js.executeScript(
				"document.querySelector(\"#root > div > div > div > div.sidebar.sidebar-open > div.sidebar-nav-items > ul > div > div > a\").click()");
		// driver.quit();
		Thread.sleep(2000);
		System.out.println("Extend start");
		js.executeScript("document.getElementsByClassName('sidebar-button')[0].click()");
		System.out.println("Extend End");
		Thread.sleep(5000);
		// js.executeScript("document.querySelector(\"#root > div > div > div >
		// div.search_page_grid > div.search_grid_root > div.search_filter_root >
		// div:nth-child(3) > div > div > fieldset\").click()");
		System.out.println("Trying in js");
		js.executeScript(
				"document.querySelector(\"#root > div > div > div > div.search_page_grid > div.search_grid_root > div.search_filter_root > div:nth-child(3) > div > label\").style.border='3px solid blue'");
		Thread.sleep(4000);System.out.println(" Trying in css");
		WebElement Ele = driver.findElement(By.cssSelector(
				"#root > div > div > div > div.search_page_grid > div.search_grid_root > div.search_filter_root > div:nth-child(3) > div > label"));

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", Ele);
		}
		//act.click(Ele).build().perform();;
		act.moveToElement(Ele).click().build().perform();
		Thread.sleep(1000);
		act.moveToElement(Ele).click().build().perform();
		Thread.sleep(8000);
		System.out.println("Select Licence");
		driver.findElement(By.xpath("//button[@value='Licence']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@value='Case']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@value='FPN']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Organization')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Organization')]")).click();
		
	/*	WebElement ele = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
 Assert.assertTrue(ExpectedConditions.titleContains("facebook").apply(driver).booleanValue());*/
	//}
//}

		/*act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
*/
		// js.executeScript(
		// "document.getElementsByClassName('MuiFormLabel-root MuiInputLabel-root
		// MuiInputLabel-formControl MuiInputLabel-animated MuiInputLabel-shrink
		// MuiInputLabel-outlined Mui-focused Mui-focused').click()");
	}
}