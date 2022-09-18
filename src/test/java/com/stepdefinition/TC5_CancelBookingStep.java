package com.stepdefinition;

import java.util.List;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Sankar
 * @description Used to execute cancel booking page snippets, methods of the cancel booking page
 *
 */
public class TC5_CancelBookingStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User should cancel the booking order id")
	public void userShouldCancelTheBookingOrderId() {
		pom.getCancelBookingPage().cancelBookingPage(pom.getBookingConfirmPage().getOrderId());
	}

	@When("User should cancel the booking with existing order id")
	public void userShouldCancelTheBookingWithExistingOrderId(io.cucumber.datatable.DataTable dataTable) {
		List<String> orderIDs = dataTable.asList();
		String orderID = orderIDs.get(0);
		pom.getCancelBookingPage().cancelBookingPage(orderID);
	}

	@Then("User should verify succes msg after cancelling the booking with existing order id {string}")
	public void userShouldVerifySuccesMsgAfterCancellingTheBookingWithExistingOrderId(String successMsgCancel) throws InterruptedException {
		
		Thread.sleep(3000);
		Assert.assertEquals("Verify after login success msg", successMsgCancel, elementGetText(pom.getCancelBookingPage().getSuccessCancelMsg()));
//		
//		Thread.sleep(3000);
//		Assert.assertEquals("Verify after login success msg", successMsgCancel,
//				elementGetText(pom.getCancelBookingPage().getCancelBooking()));
	}
}
