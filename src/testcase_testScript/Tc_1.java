package testcase_testScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Configuaration;
import locators.Locators_objectRepository;
import testdata.Locators_Values;

//test cases should be here
public class Tc_1 extends Configuaration {

	Locators_objectRepository obj_Loc = new Locators_objectRepository();
	Locators_Values obj_locValue = new Locators_Values();
	SoftAssert obj_softAssert = new SoftAssert();

	// -----Signin Test Case-----
	@Test(priority = 1)
	public void signInUSPS() {
		// This is for user id
		// goToUrl(obj_locValue.USPS_Url);
		clickByXpath(obj_Loc.loginlocator);
		typeByXpath(obj_Loc.userNamelocator, obj_locValue.usernameValue);
		typeByXpath(obj_Loc.passwordlocator, obj_locValue.passwordvalue);
		clickByXpath(obj_Loc.submitlocator);
		System.out.println("Signing  in to usps");
	}

	// ----------ADDING AN ITEM TO CART IN USPS------
	@Test(dependsOnMethods = { "signInUSPS" })
	public void addToCart() {
		clickByXpath(obj_Loc.shoplocator);
		clickByXpath(obj_Loc.giftlocator);
		clickByXpath(obj_Loc.desiredItem);
		clickByXpath(obj_Loc.addcart);
	}

	// ------VIEWING ITEM ON CART IN USPS-----
	@Test(priority = 2, enabled = false)
	public void viewCart() {
		clickByXpath(obj_Loc.viewcart);
	}

	/// -----CHECKOUT ITEM FROM CART IN USPS------
	@Test
	public void checkout() {
		clickByXpath(obj_Loc.checkoutButton);
		typeByXpath(obj_Loc.nickNameInputLocator, obj_locValue.nickNameValue);
		typeByXpath(obj_Loc.firstNameInputLocator, obj_locValue.firstNameValue);
		typeByXpath(obj_Loc.lastNameInputLocator, obj_locValue.lastNameValue);
		typeByXpath(obj_Loc.addressInputLocator, obj_locValue.adressValue);
		typeByXpath(obj_Loc.cityInputLocator, obj_locValue.cityValue);
		dropdownstring(obj_Loc.stateSelectLocator, obj_locValue.stateValue);
		typeByXpath(obj_Loc.postalCodeInputLocator, obj_locValue.postalcodeValue);
		dropdownstring(obj_Loc.countryNameSelectLocator, obj_locValue.countryValue);
		typeByXpath(obj_Loc.telephoneInputLocator, obj_locValue.telephoneValue);
		typeByXpath(obj_Loc.emailInputLocator, obj_locValue.emailValue);
		clickByXpath(obj_Loc.shipToThisAddressLocator);

	}

	@Test(enabled = false)
	public void removeItem() {
		clickByXpath(obj_Loc.viewcart);
		clickByXpath(obj_Loc.removeLocator);
	}

	// -------- ASSERTION-----
	public void assertPass() {
		String actualValue = "abcd";
		String expectedValue = "abcd";
		Assert.assertEquals(actualValue, expectedValue);
		System.out.println("test cases passed");

		obj_softAssert.assertEquals(actualValue, expectedValue);

	}

}
