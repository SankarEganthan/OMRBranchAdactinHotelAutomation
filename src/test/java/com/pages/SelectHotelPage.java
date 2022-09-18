package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Sankar
 * @description Used to find Select Hotel Page web elements and execute
 * @date 01-09-2022
 */
public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @description Used to find sucess search msg web element
	 */

	@FindBy(xpath = "//td[contains(text(), 'Select Hotel')]")
	private WebElement successSearchMsg;

	/**
	 * @description Used to find radio button web element
	 */

	@FindBy(id = "radiobutton_0")
	private WebElement radioButton;

	/**
	 * @description Used to find continue button web element
	 */

	@FindBy(id = "continue")
	private WebElement btnContinue;

	/**
	 * @description Used to find select hotel error msg web element
	 */

	@FindBy(xpath = "//label[contains(text(), 'Please Select a Hotel')]")
	private WebElement selectHotelErrorMsg;

	public WebElement getSelectHotelErrorMsg() {
		return selectHotelErrorMsg;
	}

	public WebElement getSuccessSearchMsg() {
		return successSearchMsg;
	}

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	/**
	 * @description Used to execute select hotel
	 */
	// 1. By Select Hotel name
	public void selectHotelPage() {
		elementClick(getRadioButton());
		elementClick(getBtnContinue());
	}

	/**
	 * @description Used to execute without select hotel
	 */
	// 2. Without Select Hotel
	public void withoutSelectHotel() {
		elementClick(getBtnContinue());
	}

}
