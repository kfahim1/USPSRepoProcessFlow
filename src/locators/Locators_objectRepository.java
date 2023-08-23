package locators;

public class Locators_objectRepository {
//all of the locator will be here

	// ---Login info USPS
	// ----CLICK ON LOGIN FOR SIGIN TO USPS
	public String loginlocator = "//a[@id='login-register-header']";

	// ----USERNAME XPATH FOR LOGIN TO USPS-----
	public String userNamelocator = "//input[@id='username']";// xpath

	// ----PASSWORD XPATH FOR LOGIN TO USPS----
	public String passwordlocator = "//input[@id='password']";

	// -----SUBMIT BUTTON XPATH FOR LOGIN TO USPS----
	public String submitlocator = "//button[@id='btn-submit']";

	// ------SHOP CLICK XPATH FOR USPS----
	public String shoplocator = "//a[@class='menuitem'][contains(text(),'Shop')]";

	// ------GIFT CLICK XPATH FOR USPS------
	public String giftlocator = "//a[@href='/store/results/gifts/_/N-nnxamr#content']";

	// -----CLICKING ON AN ITEM IN USPS-----
	public String desiredItem = "//img[@src='https://www.usps.com/ecp/asset/images/843497-T0.jpg']";

	// -----CLICKING ON ADD TO CART------
	public String addcart = "//a[@id='addToCartVisBtn843497']";

	// ------VIEWING ITEM ON CART-----
	public String viewcart = "//a[@class='button--primary button--white']";

	// -----CHECKOUT CLICK ON USPS---
	public String checkoutButton = "//a[@id='atg_button_checkout']";
	public String nickNameInputLocator = "//input[@id='atg_store_nickNameInput']";
	public String firstNameInputLocator = "//input[@id='atg_store_firstNameInput']";
	public String lastNameInputLocator = "//input[@id='atg_store_lastNameInput']";
	public String addressInputLocator = "//input[@id='atg_store_streetAddressInput']";
	public String cityInputLocator = "//input[@id='atg_store_localityInput']";
	public String stateSelectLocator = "//*[@id='atg_store_stateSelect']";
	public String postalCodeInputLocator = "//input[@id='atg_store_postalCodeInput']";
	public String countryNameSelectLocator = "//select[@id='atg_store_countryNameSelect']";
	public String telephoneInputLocator = "//input[@id='atg_store_telephoneInput']";
	public String emailInputLocator = "//input[@id='atg_store_emailInput']";
	public String shipToThisAddressLocator = "/html/body/form/div[3]/div/div/div[1]/div[2]/div[2]/div[10]/div/label/span";

//-----REMOVING ITEM FROM CART IN USPS-----
	public String removeLocator = "remove_ci_1";

}
