package testdata;

import org.testng.annotations.Test;

import locators.Locators_objectRepository;
import utils.Xls_Reader;

public class ReadFromExcel {

	
	Xls_Reader obj_xls = new Xls_Reader(System.setProperty(null, "C:\\Users\\fahim\\eclipse-workspace\\modulerDrivenFramework\\src\\utilites\\testdata.xlsx"));
	
	Locators_objectRepository obj_xlsLoc = new Locators_objectRepository();


	@Test
	public void TesReadingFromExcel() {
		
		typeByXpath(obj_xlsLoc.userNamelocator, obj_xls.getCellData("Sign In", "username",2 )); //test data (sheet name- sign in), column name- username, 2 - row number
		
		
	}
}
