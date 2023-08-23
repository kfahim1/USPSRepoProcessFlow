package base;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownandPoppup {
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
		launchbrowser(url);
		dropdown();
		alert();
		browserclose();

	}

	public static void launchbrowser(String url) {
		// browser launch(firefox)
		driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\17186\\eclipse-workspace\\DRIVER\\geckodriver.exe");
		driver.get(url);
		System.out.println("Website open successfully");

		// for browser maximise
		driver.manage().window().maximize();

	}

	public static void browserclose() {
		// browser close
		driver.close();

		// browser + driver close
		// driver.quit();
	}

	public static void dropdown() throws InterruptedException {

		driver.findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
		// dropdown.selectByValue("Option2");
		dropdown.selectByIndex(2);
		Thread.sleep(2000);

	}

	public static void alert() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Thread.sleep(2000);
		Alert confirmation = driver.switchTo().alert();
		Thread.sleep(2000);
		confirmation.accept();
		Thread.sleep(2000);
	}
}
