package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Sankar
 * @description Used to execute book hotel page snippets, methods of the book hotel page
 * date 01-09-2022
 *
 */
public class TC4_BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User should enter the personal and payment details {string}, {string} and {string}")
	public void userShouldEnterThePersonalAndPaymentDetailsAnd(String firstName, String lastName, String billingAddress,
			io.cucumber.datatable.DataTable dataTable) throws FileNotFoundException, IOException {
		pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, getPropertyFileValue("creditCardNo"),
				getPropertyFileValue("creditCardType"), getPropertyFileValue("expiryMonth"),
				getPropertyFileValue("expiryYear"), getPropertyFileValue("cvvNumber"));
	}

	@When("User should submit without entering the personal and payment details")
	public void userShouldSubmitWithoutEnteringThePersonalAndPaymentDetails() {
		
		pom.getBookHotelPage().bookHotel();
	}

	@Then("User should verify error msg after submitting without the personal and payment details {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyErrorMsgAfterSubmittingWithoutThePersonalAndPaymentDetailsAnd(String errorMsgFN,
			String errorMsgLN, String errorMsgAddress, String errorMsgCNo, String errorMsgCType, String errorMsgCEM,
			String errorMsgCVV) {
		Assert.assertTrue("Verify after errormsg", pom.getBookHotelPage().getFirstNameErrorMsg().getText().contains(errorMsgFN));
		Assert.assertTrue("Verify after errormsg", pom.getBookHotelPage().getLastNameErrorMsg().getText().contains(errorMsgLN));
		Assert.assertTrue("Verify after errormsg", pom.getBookHotelPage().getAddressErrorMsg().getText().contains(errorMsgAddress));
		Assert.assertTrue("Verify after errormsg", pom.getBookHotelPage().getCreditNoErrorMsg().getText().contains(errorMsgCNo));
		Assert.assertTrue("Verify after errormsg", pom.getBookHotelPage().getCreditTypeErrorMsg().getText().contains(errorMsgCType));
		Assert.assertTrue("Verify after errormsg", pom.getBookHotelPage().getExpiryMonthErrorMsg().getText().contains(errorMsgCEM));
		Assert.assertTrue("Verify after errormsg", pom.getBookHotelPage().getCvvErrorMsg().getText().contains(errorMsgCVV));
		
		
	}

}
