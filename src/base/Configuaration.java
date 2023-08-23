package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilites.Generic_Class;

public class Configuaration extends Generic_Class {
	@BeforeSuite
	public static void before_suite() {
		applicationLogs.info("suite started");
		// System.out.println("suit started");
	}

	@AfterSuite
	public static void after_suite() {
		applicationLogs.info("suite end");
		// System.out.println("suit end");
	}

	// this class will hold
	// set up browser
	// driver initialization throw inheritance
	// companys base url
	// data base connection

	// **1.DRIVER INITIALIZATION THROUGH INHERITANCE

	// **2SET UP BROWSER
	@Parameters({ "url", "browser" })
	@BeforeTest
	public void browserSetUp(String base_url, String browsername) {
		if (driver == null) {
			if (browsername.equalsIgnoreCase("firefox")) {

				// browser launch(firefox)
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\fahim\\eclipse-workspace\\DRIVER\\geckodriver.exe");
				// System.setProperty("webdriver.gecko.driver",System.getProperty(("user.dir")+
				// "\\DRIVER\\geckodriver.exe"));
				driver = new FirefoxDriver();
				maxpage();
			} else if (browsername.equalsIgnoreCase("edge")) {
				// browserlaunch (edge)
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\fahim\\eclipse-workspace\\DRIVER\\msedgedriver.exe");
				// System.setProperty("webdriver.edge.driver",System.getProperty(("user.dir")+
				// "\\DRIVER\\msedgedriver.exe"));
				driver = new EdgeDriver();
				maxpage();
			} else if (browsername.equalsIgnoreCase("chrome")) {
				// browserlaunch(chrome)
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\fahim\\eclipse-workspace\\DRIVER\\msedgedriver.exe");
				// System.setProperty("webdriver.edge.driver", System.getProperty(("user.dir")
				// +"\\DRIVER\\msedgedriver.exe\" "));
				driver = new ChromeDriver();
				maxpage();
			} else {
				throw new IllegalArgumentException(" browser type is undefined");
			}

		}
		// System.out.println("unspported browser" +browsername);
		driver.get(base_url);
		applicationLogs.info("www.usps.com opened");
		// .out.println("www.usps.com opened");

	}

	// **3COMPANYS BASE URL
	/*
	 * @BeforeMethod public void baseUrl(String url) { driver.get(url); maxpage(); }
	 * 
	 * @AfterMethod public void closeURl() {
	 * System.out.println("1 test cas excetuion done"); }
	 */

	/// *4 DATABASE CONNECTION(IF ANY)

	// **5BROWSER CLOSE
	@AfterTest
	public void browserClose() {
		driver.close();
		applicationLogs.info("browser closed");
		// System.out.println("browser closed");
	}
}

//before suite
//before test
//before class
//before method
//test case 1
//after method

//before method
//test case 2
//after method

////before method
//test case 3
//after method

//after class
//after test
//after suite