//yakshaHealthAppPages

package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class yakshaHealthAppPages extends StartupPage {

// 	TC1-Locators
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
//	TC2-Locators
	By billingNavigationMenuElement = By.xpath("(//span[contains(text(), 'Billing')])[1]");
	By selectCounterPopupElement = By.xpath("//h3//span[contains(text(), 'Select Counter')]");
	By new1TextElement = By.xpath("//h5[contains(text(), 'New-1')]");
	By new2TextElement = By.xpath("//h5[contains(text(), 'New-2')]");
	By new3TextElement = By.xpath("//h5[contains(text(), 'New-3')]");
	By old1TextElement = By.xpath("//h5[contains(text(), 'Old-1')]");
	By opdCounterTextElement = By.xpath("//h5[contains(text(), 'OPD-Counter')]");
//	TC3-Locators
	By addNewPatientTextElement = By.xpath("//span[contains(text(), 'Add New Patient')]");
//	TC 4&5 -Locators
	By firstNameTextFieldElement = By.xpath("//input[@id='newPatFirstName']");
	By middleNameTextFieldElement = By.xpath("//input[@id='newPatMiddleName']");
	By lastNameTextfieldElement = By.xpath("//input[@id='newPatLastName']");
	By ageTextfieldElement = By.xpath("//input[@id='age']");
	By contactNumberTextfieldElement = By.xpath("//input[@id='phoneNo']");
//	TC6-Locators
	By countryDropdownByElement = By.xpath("//select[@id='ddlCountry']");
//	TC7-Locators
	By registerAndBillingButtonElement = By.xpath("//button[contains(text(), 'Register & Billing')]");
	By errorMessageOfRegisterBillingByElement = By.xpath("//p[contains(text(), 'Some of the inputs are invalid. Please check and try again. !')]");
//	TC8&9-Locators
	By dispensaryToggle = By.xpath("//span[@data-target='#Dispensary']");
	By prescriptionSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Prescription')]");
	By saleSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Sale')]");
	By stockSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Stock')]");
	By counterSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Counter')]");
	By reportsSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Reports')]");
	By patientConsumptionSubMenu = By.xpath("//ul[@id='Dispensary']//li//a//span[contains(text(),'Patient Consumption')]");
//	TC10-Locators
	By dispensaryLeftNavigationMenu = By.xpath("//a[@href='#/Dispensary']//span[contains(text(), 'Dispensary')]");
	By settingLeftNavigationMenu = By.xpath("//a[@href='#/Settings']//span[contains(text(), 'Settings')]");



	String pageName = this.getClass().getSimpleName();
	public yakshaHealthAppPages(WebDriver driver) 
	{
		super(driver);
	}

	/**@Test1.1
	 * about this method loginTohealthAppByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(signInButton);

			if(commonEvents.isDisplayed(registeredPatientTextElement))
			{   
				WebElement registeredPatientTextWebElement = commonEvents.findElement(registeredPatientTextElement);
				commonEvents.highlightElement(registeredPatientTextWebElement);
				textIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**@Test1.2
	 * about this method verifyTitleOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the title of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyTitleOfThePage() throws Exception {
		String pageTitle = "";
		try {
			pageTitle = commonEvents.getTitle();
			System.out.println("title of the page is  :" + pageTitle );
		}catch(Exception e) {
			throw e;
		}	
		return pageTitle;
	}

	/**@Test1.3
	 * about this method verifyURLOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}

	/**@test2
	 * about this method verifySelectCounterPopupIsPresentAndNavigateToNextpage() 
	 * @param : null
	 * @description : it is verify all fields is present in current page or not 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifySelectCounterPopupIsPresentAndNavigateToNextpage() throws Exception {
		Boolean selectCounterPopUpIsPresent = false;

		WebElement billingNavigationMenuWebElement = commonEvents.findElement(billingNavigationMenuElement);
		commonEvents.highlightElement(billingNavigationMenuWebElement);
		commonEvents.click(billingNavigationMenuElement);
		try {
			if(commonEvents.isDisplayed(selectCounterPopupElement)&&
					commonEvents.isDisplayed(new1TextElement)&&
					commonEvents.isDisplayed(new2TextElement)&&
					commonEvents.isDisplayed(new3TextElement)&&
					commonEvents.isDisplayed(old1TextElement)&&
					commonEvents.isDisplayed(opdCounterTextElement)) {

				WebElement selectCounterPopupWebElement = commonEvents.findElement(selectCounterPopupElement);
				commonEvents.highlightElement(selectCounterPopupWebElement);

				WebElement new1TextWebElement = commonEvents.findElement(new1TextElement);
				commonEvents.highlightElement(new1TextWebElement);

				WebElement new2TextWebElement = commonEvents.findElement(new2TextElement);
				commonEvents.highlightElement(new2TextWebElement);

				WebElement new3TextWebElement = commonEvents.findElement(new3TextElement);
				commonEvents.highlightElement(new3TextWebElement);

				WebElement old1TextWebElement = commonEvents.findElement(old1TextElement);
				commonEvents.highlightElement(old1TextWebElement);

				WebElement opdCounterTextWebElement = commonEvents.findElement(opdCounterTextElement);
				commonEvents.highlightElement(opdCounterTextWebElement);

				selectCounterPopUpIsPresent = true;
			}
			commonEvents.click(new1TextElement);
			Thread.sleep(2000);
		}catch(Exception e) {
			throw e;	
		}
		return selectCounterPopUpIsPresent;
	}

	/**@test3
	 * about this method performKeyBoardOperationToOpenAddNewPatientPopup() 
	 * @param : null
	 * @description : it will perfor Key board operation (Alt +N) to open the Add new patient page
	 * @return : String
	 * @author : Yaksha
	 */
	public String performKeyBoardOperationToOpenAddNewPatientPopup() throws Exception {
		String  addNewpatientPopUpTextValue = "";

		try {
			commonEvents.performAltN();
			WebElement addNewPatientTextWebElement = commonEvents.findElement(addNewPatientTextElement);
			commonEvents.highlightElement(addNewPatientTextWebElement);
			commonEvents.isDisplayed(addNewPatientTextElement);
			addNewpatientPopUpTextValue = commonEvents.getText(addNewPatientTextElement);
			System.out.println("text of the popup is : " + addNewpatientPopUpTextValue);	
			Thread.sleep(2000);
		}catch(Exception e) {
			throw e;	
		}
		return addNewpatientPopUpTextValue;
	}

	/**@Test4
	 * about this method fillTheTextFieldInAddNewPatientPopup() 
	 * @param : get the data from excel file as type Map<String, String> expectedData
	 * @description : enter value in text field of Add New Patient as per excel expected data and fetch the value of that text field ,
	 * @return : fetch the value text field as string type
	 * @author : Yaksha
	 */
	public Boolean findTheTextFieldInAddNewPatientPopup() throws Exception {
		Boolean isTheTextFieldsPresent = false;
		String firstNameTextfieldValue =" ";
		try {
			if(commonEvents.isDisplayed(firstNameTextFieldElement) && 
					commonEvents.isDisplayed(middleNameTextFieldElement) &&
					commonEvents.isDisplayed(lastNameTextfieldElement) &&
					commonEvents.isDisplayed(ageTextfieldElement) &&
					commonEvents.isDisplayed(contactNumberTextfieldElement))
			{
				
				
				
				
				

				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextFieldElement, "value");
				System.out.println("FirstName : " + firstNameTextfieldValue);
				
				isTheTextFieldsPresent = true;
			}
		}catch(Exception e) {
			throw e;
		}
		return isTheTextFieldsPresent;
	}

	/**@Test5.1
	 * about this method verifyFirstNameIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the FirstName textfield
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyFirstNameIsPresent(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue = "";

		try {
			
			commonEvents.sendKeys(firstNameTextFieldElement,expectedData.get("firstName"));
			firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextFieldElement, "value");
			System.out.println("FirstName : " + firstNameTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	/**@Test5.2
	 * about this method verifyMiddleNameIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the MiddleName Text field
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyMiddleNameIsPresent(Map<String, String> expectedData) throws Exception {

		String middleNameTextfieldValue = "";

		try {
			commonEvents.sendKeys(middleNameTextFieldElement,expectedData.get("middleName"));
			middleNameTextfieldValue = commonEvents.getAttribute(middleNameTextFieldElement, "value");
			System.out.println("middleName : " + middleNameTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return middleNameTextfieldValue;
	}

	/**@Test5.3
	 * about this method verifyLastNameIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the LastName Text field
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyLastNameIsPresent(Map<String, String> expectedData) throws Exception {

		String lastNameTextfieldValue = "";

		try {
			commonEvents.sendKeys(lastNameTextfieldElement,expectedData.get("lastName"));
			lastNameTextfieldValue = commonEvents.getAttribute(lastNameTextfieldElement, "value");
			System.out.println("lastName : " + lastNameTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return lastNameTextfieldValue;
	}

	/**@Test5.4
	 * about this method verifyAgeValueIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the age Text field
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyAgeValueIsPresent(Map<String, String> expectedData) throws Exception {

		String ageTextfieldValue = "";

		try {
			commonEvents.sendKeys(ageTextfieldElement,expectedData.get("age"));
			ageTextfieldValue = commonEvents.getAttribute(ageTextfieldElement, "value");
			System.out.println("age : " + ageTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return ageTextfieldValue;
	}

	/**@Test5.5
	 * about this method verifyContactNumberIsPresent() 
	 * @param : null
	 * @description : it will fetch the data from the contact Text field
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyContactNumberIsPresent(Map<String, String> expectedData) throws Exception {

		String contactTextfieldValue = "";

		try {
			commonEvents.sendKeys(contactNumberTextfieldElement,expectedData.get("contact"));
			contactTextfieldValue = commonEvents.getAttribute(contactNumberTextfieldElement, "value");
			System.out.println("contact No. : " + contactTextfieldValue);

		}catch(Exception e) {
			throw e;
		}
		return contactTextfieldValue;
	}

	/**@Test6
	 * about this method verifyIndiaIsSelectedFromCountryDropdown() 
	 * @param : get the data from excel file as type Map<String, String> expectedData
	 * @description : it will select the country as per excel expected data
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyIndiaIsSelectedFromCountryDropdown(Map<String, String> expectedData) throws Exception {

		String selectedCountryName = "";

		try {
			commonEvents.selectByVisibleText(countryDropdownByElement, expectedData.get("selectedCountryName"));
			selectedCountryName = commonEvents.getFirstSelectedOptionFromDropdown(countryDropdownByElement, "elementName", "pageName");
			System.out.println("first selected option from country dropdown : " + selectedCountryName );

		}catch(Exception e) {
			throw e;
		}
		return selectedCountryName;
	}

	/**@test7
	 * about this method validateErrorMessageWhenClickOnRegisterBillingButton() 
	 * @param : null
	 * @description : it is getting the error message and validate the error message ,
	 * @return : errorMessage as string type
	 * @author : Yaksha
	 */
	public String validateErrorMessageWhenClickOnRegisterBillingButton() throws Exception {
		String errorMessageOfRegisterBilling="";

		try {
			commonEvents.click(registerAndBillingButtonElement);

			if(commonEvents.isDisplayed(errorMessageOfRegisterBillingByElement))
			{
				errorMessageOfRegisterBilling =  commonEvents.getText(errorMessageOfRegisterBillingByElement);
				System.out.println("Error Message when click on Register & Billing Button: " + errorMessageOfRegisterBilling);
			}
		}catch(Exception e) { 
			throw e;
		}
		return errorMessageOfRegisterBilling;
	}

	/**@test8
	 * about this method verifyDispensaryArrowIsExpanding() 
	 * @param : null
	 * @description : Verify that the dispensary arrow is expanding, and submodules are being displayed. 
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyDispensaryArrowIsExpanding() throws Exception {
		Boolean dispensaryNavigationMenuIsExapanding=false;
		try {
			commonEvents.jsClick(dispensaryToggle);
			if(commonEvents.isDisplayed(prescriptionSubMenu)&&
					commonEvents.isDisplayed(saleSubMenu)&&
					commonEvents.isDisplayed(stockSubMenu)&&
					commonEvents.isDisplayed(counterSubMenu)&&
					commonEvents.isDisplayed(reportsSubMenu)&&
					commonEvents.isDisplayed(patientConsumptionSubMenu)) {

				dispensaryNavigationMenuIsExapanding = true;
			}	

		}catch(Exception e) {
			throw e;	
		}
		return dispensaryNavigationMenuIsExapanding;
	}

	/**@test9
	 * about this method verifyDispensaryArrowIsMinimizing() 
	 * @param : null
	 * @description : Verify that the dispensary arrow is minimizing properly.
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyDispensaryArrowIsMinimizing() throws Exception {
		Boolean dispensaryNavigationMenuIsMinimizing = false;

		try {
			commonEvents.jsClick(dispensaryToggle);
			if(!(commonEvents.isDisplayed(prescriptionSubMenu)&& commonEvents.isDisplayed(saleSubMenu))) {

				dispensaryNavigationMenuIsMinimizing = true;
			}	

		}catch(Exception e) {
			throw e;	
		}
		return dispensaryNavigationMenuIsMinimizing;
	}

	/**@test10
	 * about this method verifyControlScrollingFromDispensaryToSettingModule() 
	 * @param : null
	 * @description : Verify that the left navigation menu scroll bar is scrolling from Dispensary module to settings module.
	 * @return : true
	 * @author : Yaksha
	 */
	public Boolean verifyControlIsScrollingFromDispensaryToSettingModule() throws Exception {
		Boolean isScrolling = false;

		try {
			if(commonEvents.isDisplayed(dispensaryLeftNavigationMenu)) {

				WebElement dispensaryNavigationMenuWebElement = driver.findElement(dispensaryLeftNavigationMenu);
				commonEvents.highlightElementAfterAction(dispensaryNavigationMenuWebElement);
				commonEvents.jsScrollPageTillElementVisible(settingLeftNavigationMenu, "pageName", "pageName");

				isScrolling = true;
			}	

		}catch(Exception e) {
			throw e;	
		}
		return isScrolling;
	}
}