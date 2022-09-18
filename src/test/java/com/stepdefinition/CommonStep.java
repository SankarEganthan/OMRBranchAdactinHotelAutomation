package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Sankar
 * @description Used to execute the common steps in the project
 * @date 01-09-2022
 */
public class CommonStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
		
	//TC_1Login Page
	@Then("User should verify success msg after login {string}")
	public void userShouldVerifySuccessMsgAfterLogin(String succesMsg) {	
		Assert.assertEquals("Verify after login success msg", succesMsg, elementGetAttribute(pom.getSearchHotelPage().getWelcomeMsg()));
	}
	
	//TC3_SelectHotel
	@Then("User should verify success msg after selecting Hotel {string}")
	public void userShouldVerifySuccessMsgAfterSelectingHotel(String successMsg) {
		implicitWait();
		Assert.assertEquals("Verify after login success msg", successMsg, elementGetText(pom.getBookHotelPage().getSuccessSearchMsg()));
	}
	
	//TC4_BookHotel
	@Then("User should verify success msg after submitting the personal and payment details {string}")
	public void userShouldVerifySuccessMsgAfterSubmittingThePersonalAndPaymentDetails(String successMsg) {
		implicitWait();
		Assert.assertEquals("Verify after login success msg", successMsg, elementGetText(pom.getBookingConfirmPage().getSuccessMsg()));
	}
	
	//TC5_CancelBooking
	@Then("User should verify succes msg after cancelling the booking order id {string}")
	public void userShouldVerifySuccesMsgAfterCancellingTheBookingOrderId(String succesMsgCancel) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals("Verify after login success msg", succesMsgCancel, elementGetText(pom.getCancelBookingPage().getSuccessCancelMsg()));
	}
}
