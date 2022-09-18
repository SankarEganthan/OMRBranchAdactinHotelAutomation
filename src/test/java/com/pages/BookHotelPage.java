package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Sankar
 * @description Used to find web elements in Book Hotel Page and execute
 * @date 01-09-2022
 *
 */

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * @description Used to identify the Succes Msg
	 */

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement successSearchMsg;
	
	/**
	 * @description  Used to identify the first name textbox
	 */

	@FindBy(id = "first_name")
	private WebElement firstName;
	
	/**
	 * @description  Used to identify the last name textbox
	 */

	@FindBy(id = "last_name")
	private WebElement lastName;

	/**
	 * @description  Used to identify the address textbox
	 */
	
	@FindBy(id = "address")
	private WebElement aDdress;

	/**
	 * @description  Used to identify the credit card no textbox
	 */

	@FindBy(id = "cc_num")
	private WebElement ccNum;

	/**
	 * @description  Used to identify the credit card type textbox
	 */

	@FindBy(id = "cc_type")
	private WebElement ccType;

	/**
	 * @description  Used to identify the credit card expiry month textbox
	 */

	@FindBy(id = "cc_exp_month")
	private WebElement ccExpMonth;

	/**
	 * @description  Used to identify the credit card expiry year textbox
	 */

	@FindBy(id = "cc_exp_year")
	private WebElement ccExpYear;

	/**
	 * @description  Used to identify the credit card CVV textbox
	 */

	@FindBy(id = "cc_cvv")
	private WebElement ccCvv;

	/**
	 * @description  Used to identify the book now button
	 */

	@FindBy(id = "book_now")
	private WebElement bookNow;

	/**
	 * @description  Used to identify the First Name error msg
	 */

	@FindBy(xpath = "//label[contains(text(), 'Please Enter your First Name')]")
	private WebElement firstNameErrorMsg;

	/**
	 * @description  Used to identify the last name error msg 
	 */

	@FindBy(xpath = "//label[contains(text(), 'Please Enter you Last Name')]")
	private WebElement lastNameErrorMsg;

	/**
	 * @description  Used to identify the address error msg 
	 */

	@FindBy(xpath = "//label[contains(text(), 'Please Enter your Address')]")
	private WebElement addressErrorMsg;

	/**
	 * @description  Used to identify the credit card no error msg 
	 */

	@FindBy(xpath = "//label[contains(text(), 'Please Enter your 16 Digit Credit Card Number')]")
	private WebElement creditNoErrorMsg;

	/**
	 * @description  Used to identify the credit card type error msg  
	 */

	@FindBy(xpath = "//label[contains(text(), 'Please Select your Credit Card Type')]")
	private WebElement creditTypeErrorMsg;

	/**
	 * @description  Used to identify the credit card expiry month error msg
	 */

	@FindBy(xpath = "//label[contains(text(), 'Please Select your Credit Card Expiry Month')]")
	private WebElement expiryMonthErrorMsg;

	/**
	 * @description  Used to identify the credit card cvv error msg
	 */

	@FindBy(xpath = "//label[contains(text(), 'Please Enter your Credit Card CVV Number')]")
	private WebElement cvvErrorMsg;

	public WebElement getaDdress() {
		return aDdress;
	}

	public WebElement getFirstNameErrorMsg() {
		return firstNameErrorMsg;
	}

	public WebElement getLastNameErrorMsg() {
		return lastNameErrorMsg;
	}

	public WebElement getAddressErrorMsg() {
		return addressErrorMsg;
	}

	public WebElement getCreditNoErrorMsg() {
		return creditNoErrorMsg;
	}

	public WebElement getCreditTypeErrorMsg() {
		return creditTypeErrorMsg;
	}

	public WebElement getExpiryMonthErrorMsg() {
		return expiryMonthErrorMsg;
	}

	public WebElement getCvvErrorMsg() {
		return cvvErrorMsg;
	}

	public WebElement getSuccessSearchMsg() {
		return successSearchMsg;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getADdress() {
		return aDdress;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcExpMonth() {
		return ccExpMonth;
	}

	public WebElement getCcExpYear() {
		return ccExpYear;
	}

	public WebElement getCcCvv() {
		return ccCvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}
/**
 * @description Used to perform hotel booking with all details
 * @param firstname
 * @param lastname
 * @param address
 * @param ccnum
 * @param cctype
 * @param ccexpmonth
 * @param ccyear
 * @param cvvNumber
 */
	// 1. By select all fields
	public void bookHotel(String firstname, String lastname, String address, String ccnum, String cctype,
			String ccexpmonth, String ccyear, String cvvNumber) {
		elementSendKeys(getFirstName(), firstname);
		elementSendKeys(getLastName(), lastname);
		elementSendKeys(getADdress(), address);
		elementSendKeys(getCcNum(), ccnum);
		selectByVisibleText(getCcType(), cctype);
		selectByVisibleText(getCcExpMonth(), ccexpmonth);
		selectByVisibleText(getCcExpYear(), ccyear);
		elementSendKeys(getCcCvv(), cvvNumber);
		elementClick(getBookNow());
	}

	/**
	 * @description Used to perform hotel booking with out the details
	 */
	// 2. without enter any fields
	public void bookHotel() {
		elementClick(getBookNow());
	}

}
