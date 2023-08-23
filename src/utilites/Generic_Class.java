package utilites;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Generic_Class {
//all of the generic method in here
	public static WebDriver driver = null;

	public static Logger applicationLogs = Logger.getLogger("devpinoyLogger");

	// ----THIS IS FOR WINDOW MAXIMIZE -----
	public void maxpage() {
		driver.manage().window().maximize();
	}

	// ----This is for URL Navigation-----
	public void goToUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}
	}

	// -----This is for Text Box using Xpath-----
	public void typeByXpath(String locator, String value) {
		try {
			driver.findElement(By.xpath(locator)).clear();
			driver.findElement(By.xpath(locator)).sendKeys(value);
		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}
	}

	// -----This is for BUTTON/LINK USING XPATH----
	public void clickByXpath(String locator) {
		try {
			driver.findElement(By.xpath(locator)).click();

		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}
	}

	// -----This is for DROPDOWN USING XPATH------
	public void dropdown(String locator, int desiredNumber) {
		try {

			driver.findElement(By.xpath(locator)).click();
			Select dropdown = new Select(driver.findElement(By.xpath(locator)));
			dropdown.selectByIndex(desiredNumber);
		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}
	}

	// -----This is for DROPDOWN USING String text XPATH------
	public void dropdownstring(String locator, String text) {
		try {
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			driver.findElement(By.xpath(locator)).click();
			Select dropdown = new Select(driver.findElement(By.xpath(locator)));
			dropdown.selectByVisibleText(text);
		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}
	}

	// -----This is for ALERT USING XPATH------
	public void alert(String locator) {
		try {
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			driver.findElement(By.xpath(locator)).click();
			Alert confirmation = driver.switchTo().alert();
			confirmation.accept();

		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}

	}

	// -----THIS IS FOR WINDOW HANDLING-----
	public static void windowHandle(String locator) {
		try {

			driver.findElement(By.xpath(locator)).click();

			Set<String> windowH = driver.getWindowHandles();
			Iterator<String> itH = windowH.iterator();
			String parentwin = itH.next();
			String childwin = itH.next();
			System.out.println(parentwin + " -parentwindow" + childwin + " -childwindow");
			System.out.println(driver.getTitle());

			driver.switchTo().window(childwin);
			Thread.sleep(2000);
			System.out.println("childwindow: " + driver.getTitle());

			driver.switchTo().window(parentwin);
			Thread.sleep(2000);
			System.out.println("parentwindow:" + driver.getTitle());

		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}

	}

	// -----This is for FRAME USING XPATH-----
	public void frame(String framelocator, String inputlocator, String inputvalue, String textlocator) {
		try {
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(framelocator)));
			driver.switchTo().frame(driver.findElement(By.xpath(framelocator)));
			driver.findElement(By.xpath(inputlocator)).sendKeys(inputvalue);// xpath2=child frame //val=child frame
																			// value
			driver.switchTo().defaultContent();// outside default content is parent frame
			System.out.println(driver.findElement(By.xpath(textlocator)).getText());
		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}
	}

	// ----This is for DRAG AND DROP USING XPATH
	public void draganddrop(String dragframelocator, String sourcelocator, String destinationlocator) {
		try {

			driver.switchTo().frame(driver.findElement(By.xpath(dragframelocator)));

			WebElement source = driver.findElement(By.xpath(sourcelocator));
			Thread.sleep(2000);
			WebElement destination = driver.findElement(By.xpath(destinationlocator));
			Actions obj = new Actions(driver);
			obj.dragAndDrop(source, destination).build().perform();

		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}

	}

	// -----Thia is for MOUSEHOVER-----

	public static void mouseHover(String locator) {
		try {

			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			WebElement mouseHover = driver.findElement(By.xpath(locator));
			Actions obj = new Actions(driver);
			obj.moveToElement(mouseHover).perform();

		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}
	}

	// -----THIS IS FOR WEBTABLE------
	public static void webtable(String locator, String rowlocator, String collocator) {
		try {
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			WebElement table = driver.findElement(By.xpath(locator));
			List<WebElement> row = table.findElements(By.tagName(rowlocator));
			for (int i = 0; i < row.size(); i++) {
				List<WebElement> column = row.get(i).findElements(By.tagName(collocator));
				for (int j = 0; j < column.size(); j++) {
					System.out.println(column.get(j).getText());
				}
			}
		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}
	}

	// ----DATE PICKER IN CALENDER----
	public static void datePicker(String framelocator, String inputlocator, String calenderlocator, String rowlocator,
			String collocator, String value) {
		try {
			// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(framelocator)));
			driver.switchTo().frame(framelocator);
			driver.findElement(By.xpath(inputlocator)).click();
			WebElement calender = driver.findElement(By.xpath(calenderlocator));
			List<WebElement> row = calender.findElements(By.tagName(rowlocator));
			for (int i = 0; i < row.size(); i++) {
				List<WebElement> column = row.get(i).findElements(By.tagName(collocator));
				for (int j = 0; j < column.size(); j++) {
					String date = column.get(j).getText();
					if (date.equalsIgnoreCase(value)) {
						column.get(j).click();

					}
				}
			}
		} catch (Exception e) {
			System.err.println("issue with" + e.getMessage());
		}

	}

}
