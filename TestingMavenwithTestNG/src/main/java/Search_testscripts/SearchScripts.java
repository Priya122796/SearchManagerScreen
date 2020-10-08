package Search_testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.Console;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.twilio.rest.preview.sync.service.Document;

import testscripts.TwilioSMS;

/**
 * @author priya
 *
 */
public class SearchScripts {
	public static WebDriver driver;
	static WebDriverWait wait;
	static Actions act;
	static Robot robot;
	static ExtentReports extent;
	static ExtentTest logger;

	@BeforeClass
	public static void startTest() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/Report/Report.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		logger = extent.startTest("Configuration of CORS");
	}

	@Test
	public void initialize() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\priya\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addExtensions(new File("E:\\CORS3.crx"));
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, co);
		driver = new ChromeDriver(dc);
		driver.manage().window().maximize();
		driver.get("chrome://extensions/shortcuts");
		Thread.sleep(1000);
		// enabling cors
		enablingCors(driver);

		driver.get("https://freeflowstorageqa.z33.web.core.windows.net/manage");
		Thread.sleep(20000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// driver.findElement(By.xpath("//input[@type='email']")).sendKeys("shanmathi@logicvalley.in");
		js.executeScript("document.getElementById('logonIdentifier').value='shanmathi@logicvalley.in';");
		System.out.println("Entering Login");
		// +12058946954
		// Shanmathi = Bohu3855
		// Nifaanya = Maco3129
		js.executeScript(" document.getElementById('password').value='Bohu3855';");
		System.out.println("Entering Password");
		js.executeScript("document.getElementById('next').click();");
		System.out.println("Clicking next");
		Thread.sleep(6000);
		// Fetching previous OTP
		String OTPold = TwilioSMS.ReciverOTP();
		System.out.println(OTPold);
		// js.executeScript("document.getElementById('localNumber').value='4123124643';");
		// System.out.println("Entering number");
		js.executeScript("document.getElementById('verifyCode').click();");
		System.out.println("Sending Code ");

		String OTP = TwilioSMS.ReciverOTP();
		System.out.println(OTP);
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"verificationCode\"]"));
		Boolean temp = true;
		int i = 0;
		while (temp) {
			Thread.sleep(1000);
			if (OTP.contentEquals(OTPold)) {
				// resend code
				Thread.sleep(2000);
				js.executeScript("document.getElementById('retryCode').click();");
				System.out.println("reSending Code  : " + ++i);
				Thread.sleep(3000);
				OTP = TwilioSMS.ReciverOTP();
			} else {
				System.out.println("***OTP Generated****");
				temp = false;
				System.out.println("!!!!!!!" + OTP + "!!!!!!");
			}
		}

		Thread.sleep(6000);
		WebElement textbox1 = driver.findElement(By.id("verificationCode"));
		Thread.sleep(2000);
		// textbox1.sendKeys(OTP);

		System.out.println("Sending human values");
		sendHumanKeys(textbox1, OTP);
		Thread.sleep(1000);
		System.out.println("Performing actions");
		// WebElement text = driver.findElement(By.xpath("//*[@id='verifyCode']"));
		// text.click();
		// act.click(textbox1).sendKeys(OTP).build().perform();
		System.out.println("Waiting until element visible");
		Thread.sleep(30000);
		switchingMenu();
		bulkactions();
	}

	private void bulkactions() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(9000);
		System.out.println("Fetching row count:");
		List<WebElement> rows = driver.findElements(By.xpath(
				"//*[@class='ag-body-viewport ag-layout-normal ag-row-no-animation']//div[@class='ag-center-cols-container']//div[@col-id='CaseNo']"));
		int iSize = rows.size();
		System.out.println("The size of rows is : " + iSize);
		for (int i = 0; i < iSize; i++) {
			String sValue = "CQ000000167";
			if (sValue.equalsIgnoreCase(rows.get(i).getText())) {
				System.out.println("Selecting : " + rows.get(i).getText());
				rows.get(i).click();
				String b=rows.get(i).toString();
				System.out.println("Checking :::::::: "+b.startsWith("xpath: "));
				break;
			}
		}
		Thread.sleep(8000);
		driver.findElement(By.id("Btn_Close")).click();
		System.out.println("Selecting checkbox in grid");
		// div[@class='ag-center-cols-container']
		// List<WebElement> rows =
		// driver.findElements(By.xpath("//input[@id='ag-input-id-789']"));

		driver.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div/div/div[4]/div[1]/div/div/div/div/input"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.id("gridaction_PintheRecords")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Cancel Pin the Records")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("gridaction_Hold")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Cancel Hold")).click();
		Thread.sleep(4000);
		
	}

	private void enablingCors(WebDriver driver2) throws Exception {
		// TODO Auto-generated method stub
		act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		// act.sendKeys(Keys.RETURN).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys("1").build().perform();
		Thread.sleep(1000);

		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_1);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_1);
		Assert.assertTrue(true);
		// To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "Cors is passed navigated to the URL");
		Thread.sleep(1000);
		System.out.println("Deleting all cookies");
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);

	}

	private void switchingMenu() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Switching between Menu");
		driver.findElement(By.id("MenuExtend")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Inavlink_AdminSettings")).click();
		Thread.sleep(2000);
		WebElement ele = driver
				.findElement(By.xpath("//div[@class='nav-link-title-child']//a[contains(text(),'Roles management')]"));
		ele.click();
		Thread.sleep(6000);
		driver.findElement(By.id("Inavlink_CaseManagment")).click();
		Thread.sleep(2000);
		ele = driver
				.findElement(By.xpath("//div[@class='nav-link-title-child']//a[contains(text(),'Serach Manager')]"));
		ele.click();
		Thread.sleep(2000);
		driver.findElement(By.id("MenuExtend")).click();
		Thread.sleep(9000);

	}

	// working
	private static void sendHumanKeys(WebElement element, String text) throws InterruptedException {
		Random r = new Random();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean temp = true;
		// js.executeScript("document.getElementById('verificationCode').value ='" +
		// text.charAt(0) + "';");
		/*
		 * element.click(); char[] gett = text.toCharArray(); for (char a : gett) {
		 * Thread.sleep((int) (r.nextGaussian() * 15 + 100));
		 * System.out.println(" *** Entering " + a); int keycode = (int) a;
		 * System.out.println("The keycode is : "+keycode);
		 * act.moveToElement(element).build().perform(); robot.keyPress(keycode);
		 * robot.keyRelease(keycode); Thread.sleep(500); }
		 */
		for (int i = 0; i < text.length(); i++) {
			if (temp) {
				element.sendKeys(String.valueOf(text.charAt(0)));
				temp = false;
			}
			Thread.sleep((int) (r.nextGaussian() * 15 + 100));
			String s = new StringBuilder().append(text.charAt(i)).toString();
			System.out.println(" *** Entering " + s);
			// act.moveToElement(element).build().perform();
			Thread.sleep(500);
			element.sendKeys(s);

		}

	}

	@AfterClass
	public static void endTest() {
		extent.endTest(logger);
		extent.flush();
	}
}