package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Sankar
 * @description Used to find Cancel Booking Page web elements and execute
 * @date 01-09-2022
 */

public class CancelBookingPage extends BaseClass{
	
	public CancelBookingPage() {
	PageFactory.initElements(driver, this);
	}
	
	/**
	 * @description Used to find booked itinerary web element
	 */

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement bookedItinerary;
	
	/**
	 * @description Used to find order id text box web element
	 */

	@FindBy(id = "order_id_text")
	private WebElement orderIdText;
	
	/**
	 * @description Used to find search button web element
	 */

	@FindBy(id = "search_hotel_id")
	private WebElement buttonSearch;
	
	/**
	 * @description Used to find cancel button web element
	 */

	@FindBy(xpath = "(//input[@name='ids[]']//ancestor::td//preceding::input)[7]")
	private WebElement button;
	
	/**
	 * @description Used to find success msg web element
	 */

	@FindBy(xpath = "//input[@name='cancelall']")
	private WebElement cancelBooking;
	
	/**
	 * @description Used to find success cancel msg web element
	 */
	@FindBy(id="search_result_error")
	private WebElement successCancelMsg;

	public WebElement getSuccessCancelMsg() {
		return successCancelMsg;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getOrderIdText() {
		return orderIdText;
	}

	public WebElement getButtonSearch() {
		return buttonSearch;
	}

	public WebElement getButton() {
		return button;
	}

	public WebElement getCancelBooking() {
		return cancelBooking;
	}

	/**
	 * @description Used to execute the cancel booking
	 * @param orderid
	 */
	public void cancelBookingPage(String orderid) {
		elementClick(getBookedItinerary());
		elementSendKeys(getOrderIdText(), orderid);
		elementClick(getButtonSearch());
		elementClick(getButton());
		switchToAlertAccept();

	}

}
