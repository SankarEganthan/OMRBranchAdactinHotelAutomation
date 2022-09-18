package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Sankar
 * @description Used to find Search Hotel Page web elements and execute
 * @date 01-09-2022
 */
public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @description Used to find user name welcome msg web element
	 */

	@FindBy(id = "username_show")
	public WebElement welcomeMsg;

	/**
	 * @description Used to find location text box web element
	 */

	@FindBy(id = "location")
	public WebElement dDnLocation;

	/**
	 * @description Used to find hotels text box web element
	 */

	@FindBy(id = "hotels")
	public WebElement dBnHotels;

	/**
	 * @description Used to find room type text box web element
	 */

	@FindBy(id = "room_type")
	public WebElement dDnRoomType;

	/**
	 * @description Used to find no of rooms text box web element
	 */

	@FindBy(id = "room_nos")
	public WebElement dDnRoomNo;

	/**
	 * @description Used to find date pick in text box web element
	 */

	@FindBy(id = "datepick_in")
	public WebElement dDnDatePickIn;

	/**
	 * @description Used to find date pick out text box web element
	 */

	@FindBy(id = "datepick_out")
	public WebElement dDnDatePickOut;

	/**
	 * @description Used to find no of adults text box web element
	 */

	@FindBy(id = "adult_room")
	public WebElement dDnAdultRoom;

	/**
	 * @description Used to find no of children text box web element
	 */

	@FindBy(id = "child_room")
	public WebElement dDnChildRoom;

	/**
	 * @description Used to find submit button web element
	 */

	@FindBy(id = "Submit")
	public WebElement dDnSubmit;

	/**
	 * @description Used to find check in error msg web element
	 */

	@FindBy(xpath = "//span[text()='Check-In Date shall be before than Check-Out Date']")
	public WebElement checkinErrorMsg;

	/**
	 * @description Used to find check out error msg web element
	 */

	@FindBy(xpath = "//span[text()='Check-Out Date shall be after than Check-In Date']")
	public WebElement checkoutErrorMsg;

	/**
	 * @description Used to find location error msg web element
	 */

	@FindBy(xpath = "//span[contains(text(), 'Please Select a Location')]")
	public WebElement locationErrormsg;

	public WebElement getLocationErrormsg() {
		return locationErrormsg;
	}

	public WebElement getCheckoutErrorMsg() {
		return checkoutErrorMsg;
	}

	public WebElement getCheckinErrorMsg() {
		return checkinErrorMsg;
	}

	public WebElement getWelcomeMsg() {
		return welcomeMsg;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdBnHotels() {
		return dBnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}

	public WebElement getdDnDatePickIn() {
		return dDnDatePickIn;
	}

	public WebElement getdDnDatePickOut() {
		return dDnDatePickOut;
	}

	public WebElement getdDnAdultRoom() {
		return dDnAdultRoom;
	}

	public WebElement getdDnChildRoom() {
		return dDnChildRoom;
	}

	public WebElement getdDnSubmit() {
		return dDnSubmit;
	}

	/**
	 * @description Used to execute search hotel
	 * @param location
	 * @param hotels
	 * @param roomType
	 * @param noOfRooms
	 * @param datePickIn
	 * @param datePickOut
	 * @param adultRoom
	 * @param childRoom
	 */
	// 1. By Selecting all fields
	// 3. By selecting all fields and greater check in date
	public void searchHotelPage(String location, String hotels, String roomType, String noOfRooms, String datePickIn,
			String datePickOut, String adultRoom, String childRoom) {
		selectByVisibleText(getdDnLocation(), location);
		selectByVisibleText(getdBnHotels(), hotels);
		selectByVisibleText(getdDnRoomType(), roomType);
		selectByVisibleText(getdDnRoomNo(), noOfRooms);
		elementClear(getdDnDatePickIn());
		elementSendKeys(getdDnDatePickIn(), datePickIn);
		elementClear(getdDnDatePickOut());
		elementSendKeys(getdDnDatePickOut(), datePickOut);
		selectByVisibleText(getdDnAdultRoom(), adultRoom);
		selectByVisibleText(getdDnChildRoom(), childRoom);
		elementClick(getdDnSubmit());

	}

	/**
	 * @description Used to search hotel with mandatory details
	 * @param location
	 * @param noOfRooms
	 * @param datePickIn
	 * @param datePickOut
	 * @param adultRoom
	 */
	// 2. By Selecting mandatory fields
	public void searchHotelPage(String location, String noOfRooms, String datePickIn, String datePickOut,
			String adultRoom) {
		selectByVisibleText(getdDnLocation(), location);
		selectByVisibleText(getdDnRoomNo(), noOfRooms);
		elementClear(getdDnDatePickIn());
		elementSendKeys(getdDnDatePickIn(), datePickIn);
		elementClear(getdDnDatePickOut());
		elementSendKeys(getdDnDatePickOut(), datePickOut);
		selectByVisibleText(getdDnAdultRoom(), adultRoom);
		elementClick(getdDnSubmit());

	}

	/**
	 * @description Used to search hotel without entering any details
	 */
	// 4. Without entering any fields
	public void searchHotelPage() {
		elementClick(getdDnSubmit());

	}

}