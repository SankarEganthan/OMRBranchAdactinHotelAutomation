package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Sankar
 * @description Used to execute search hotel page snippets, methods of the search hotel page
 *
 */
public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User should enter the details {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldEnterTheDetailsAnd(String location, String hotels, String roomType, String noOfRooms,
			String checkInDate, String checkOutDate, String adults, String children) {
		pom.getSearchHotelPage().searchHotelPage(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate,
				adults, children);

	}

	// TC2_Search Hotel
	@Then("User should verify msg after Search Hotel {string}")
	public void userShouldVerifyMsgAfterSearchHotel(String searchHotelMsg) {
		implicitWait();
		Assert.assertEquals("Verify after login success msg", searchHotelMsg,
				elementGetText(pom.getSelectHotelPage().getSuccessSearchMsg()));
	}

	@When("User should enter the mandatory details {string}, {string}, {string}, {string} and {string}")
	public void userShouldEnterTheMandatoryDetailsAnd(String location, String noOfRooms, String checkInDate,
			String checkOutDate, String adults) {
		pom.getSearchHotelPage().searchHotelPage(location, noOfRooms, checkInDate, checkOutDate, adults);

	}

	@Then("User should verify date error msg after Search Hotel {string} and {string}")
	public void userShouldVerifyDateErrorMsgAfterSearchHotelAnd(String checkInDateErrorMsg,
			String checkOutDateErrorMsg) {
		Assert.assertTrue("Verify after errormsg",
				pom.getSearchHotelPage().getCheckinErrorMsg().getText().contains(checkInDateErrorMsg));
		Assert.assertTrue("Verify after errormsg",
				pom.getSearchHotelPage().getCheckoutErrorMsg().getText().contains(checkOutDateErrorMsg));
	}

	@When("User should not enter the details")
	public void userShouldNotEnterTheDetails() {
		pom.getSearchHotelPage().searchHotelPage();
	}

	@Then("User should verify select location error msg after Search Hotel {string}")
	public void userShouldVerifySelectLocationErrorMsgAfterSearchHotel(String locationErrorMsg) {
		Assert.assertTrue("Verify after errormsg",
				pom.getSearchHotelPage().getLocationErrormsg().getText().contains(locationErrorMsg));
	}

}
