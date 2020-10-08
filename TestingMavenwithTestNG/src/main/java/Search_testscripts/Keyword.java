package Search_testscripts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Nifa
 *
 */
public class Keyword {
	static ChromeDriver driver ;
	static Properties prop;
	static  WebDriverWait wait;
	/**
	 * openbrowser() is to set configuration of a browser
	 * @throws Exception
	 */
	public void openbrowser()throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\priya\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		FileInputStream ffile=new FileInputStream("E:\\AutomationForAliExpress\\src\\properties\\keyword.properties");
		prop=new Properties();
		prop.load(ffile);
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,30);
	}
	/**
	 * implicitWait() methods inbuild wait for a field
	 */
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
	}
	/**
	 * navigate() method is to get the url
	 * @param datas
	 */
	public void navigate(String datas) throws Exception{
		System.out.println("Getting into website");
		driver.get(datas);
		System.out.println("Screenshot is taken");

	}
	/**
	 * input() is to enter input into the field
	 * @param datas
	 * @param objectName
	 */
	public void input(String datas, String objectName) {

		System.out.println("Inside input");
		System.out.println(prop.getProperty(objectName));
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(datas);
		System.out.println("Input is written");
	}


	/**
	 * click() method is used to click button
	 * @param objectName
	 * @throws Exception
	 */
	public void click(String objectName) throws Exception {
		System.out.println("Inside click");
		if(objectName.equals("submit")){
			implicitWait();
			System.out.println(driver.findElement(By.xpath(prop.getProperty(objectName))));
			System.out.println("Screenshot is taken");
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
			System.out.println("Done click");
		}else if(objectName.equals("home")){
			System.out.println("In home page ");
			System.out.println(driver.findElement(By.xpath(prop.getProperty(objectName))));
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
			System.out.println("Done click");
		}
		else if(objectName.equals("addwishlist")){
			System.out.println(driver.findElement(By.xpath(prop.getProperty(objectName))));
			System.out.println("Screenshot is taken");
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
			System.out.println("Done click");
		}else if(objectName.equals("wishlist")){
			System.out.println(driver.findElement(By.xpath(prop.getProperty(objectName))));
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
			System.out.println("Done click");
			System.out.println("Screenshot is taken");
		}
		else if(objectName.equals("signout")){
			System.out.println(driver.findElement(By.xpath(prop.getProperty(objectName))));
			System.out.println("Screenshot is taken");
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
			System.out.println("Signing Out");
			driver.quit();
		}
		else{
			System.out.println(driver.findElement(By.xpath(prop.getProperty(objectName))));
			driver.findElement(By.xpath(prop.getProperty(objectName))).click();
			System.out.println("Done click");
		}
	}
	/**
	 * verifyTitle() method used to verify title by assert
	 * @return
	 */
	public String verifyTitle() {
		System.out.println("verify Title::::"+driver.getTitle());
		return driver.getTitle();	
	}
	/**
	 * dropdown() method is to select dropdown menu
	 * @param objectName
	 */
	public void dropdown(String objectName) {
		// TODO Auto-generated method stub
		WebElement menuOption=driver.findElement(By.xpath(prop.getProperty(objectName)));
		System.out.println(menuOption.getText());
		menuOption.click();
		System.out.println("Selected ");

	}
	/**
	 * select() method is to select from dropdown
	 * @param objectName
	 */
	public void select(String objectName) {
		// TODO Auto-generated method stub
		WebElement LangmenuOption=driver.findElement(By.xpath(prop.getProperty(objectName)));
		LangmenuOption.click();
		System.out.println("Language menu selected");
	}
}

