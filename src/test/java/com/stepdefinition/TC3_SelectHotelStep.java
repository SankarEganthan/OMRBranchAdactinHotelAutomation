package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Sankar
 * @description Used to execute select hotel page snippets, methods of the select hotel page
 * date 01-09-2022
 *
 */
public class TC3_SelectHotelStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should select Hotel Name")
	public void userShouldSelectHotelName() {
		pom.getSelectHotelPage().selectHotelPage();
	}
	
	@Then("User should continue without selecting any Hotel Name")
	public void userShouldContinueWithoutSelectingAnyHotelName() {
		pom.getSelectHotelPage().withoutSelectHotel();
	}
	@Then("User should verify without selecting any hotel name error msg {string}")
	public void userShouldVerifyWithoutSelectingAnyHotelNameErrorMsg(String errorMsg) {
		Assert.assertTrue("Verify after errormsg", pom.getSelectHotelPage().getSelectHotelErrorMsg().getText().contains(errorMsg));
	}


}
