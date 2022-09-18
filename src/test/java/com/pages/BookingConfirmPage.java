package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Sankar
 * @description Used to find web elements in Booking Confirmation page and execute
 * @date 01-09-2022
 *
 */

public class BookingConfirmPage extends BaseClass {
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * @description Used to find success msg web element
	 */

	@FindBy(xpath = "//td[contains(text(), 'Booking Confirmation ')]")
	private WebElement successMsg;
	
	/**
	 * @description Used to find order id web element
	 */
	
	@FindBy(id = "order_no")
	private WebElement orderNo;

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	
	public WebElement getOrderNo() {
		return orderNo;
	}

	public String getOrderId() {
		String orderID = elementGetAttribute(getOrderNo());
		return orderID;
	}

}
