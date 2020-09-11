package Frame;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameHW {

	public static int expectedFrame = 3;
	public static WebElement element;

	@Test
	public static void main() throws InterruptedException {

		// code for opening chrome browser
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// code for navigating to the URL & maximizing browser(NO_1)
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		;
		driver.manage().window().maximize();

		// Finding all iframe tags on a web page(NO_2)
		List<WebElement> elements = driver.findElements(By.tagName("frame"));
		int numberOfTags = elements.size();
		System.out.println("No. of Iframes on this Web Page are: " + numberOfTags);

		// Validate total iframe
		if (numberOfTags == expectedFrame) {
			AssertJUnit.assertTrue(true);
			System.out.println("Congrtas ! Total Frame count matched.");
		} else {
			System.out.println("Sorry. Total Frame count don't match. ");
			AssertJUnit.fail();
		}

		// Extract Highlighted Text from page(NO_3)

		// Switch to the frame using the frame name
		System.out.println("Switching to the 1st frame");
		driver.switchTo().frame("packageListFrame"); // using By Name
		element = driver.findElement(By.xpath("//a[@href='allclasses-frame.html']")); // Extraction using Xpath
		Thread.sleep(1000);
		String highlightedText1 = element.getText();
		System.out.println("First Frame Extract = " + highlightedText1);

		driver.switchTo().defaultContent();

		// Switch to the frame using the frame name
		System.out.println("Switching to the 2nd frame");
		driver.switchTo().frame("classFrame");
		element = driver.findElement(By.xpath("//a[@href='com/thoughtworks/selenium/package-summary.html']")); // Extract
																												// using
																												// Xpath
		Thread.sleep(1000);
		String highlightedText2 = element.getText();
		System.out.println("Second Frame Extract = " + highlightedText2);

		driver.switchTo().defaultContent();

		/*
		 * // Switch to the frame using the frame name
		 * System.out.println("Switching to the frame");
		 * driver.switchTo().frame("packageListFrame");
		 */

	}
}
