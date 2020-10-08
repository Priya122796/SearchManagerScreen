package testscripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.twilio.twiml.voice.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

public class IncomingCallServlet extends HttpServlet {
	public static WebDriver driver;

	@Test
	public void initialize() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\priya\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s1.demo.opensourcecms.com/wordpress/");
		Thread.sleep(15000);
		driver.findElement(By.xpath("//input[@id='search-form-1']")).click();
		String get = getRandomNumberString();
		char[] gett = get.toCharArray();
		Robot robot = new Robot();
		for (char a : gett) {
			System.out.println(a);
			int keycode = (int) a;
			System.out.println("The keycode is : "+keycode);
			robot.keyPress(keycode);
			robot.keyRelease(keycode); 
		}

	}

	public static String getRandomNumberString() {
		// It will generate 6 digit random Number.
		// from 0 to 999999
		Random rnd = new Random();
		int number = rnd.nextInt(999999);

		// this will convert any number sequence into 6 character.
		return String.format("%06d", number);
	}

}