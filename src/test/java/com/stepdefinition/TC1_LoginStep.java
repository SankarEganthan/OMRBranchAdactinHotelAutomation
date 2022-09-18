package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Sankar
 * @description Used to execute login page snippets, methods of the login page
 * @date 01-09-2022
 *
 */
public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the adactin page")
	public void userIsOnTheAdactinPage() throws FileNotFoundException, IOException, InterruptedException {
		
	}

	@When("User should perform login {string} and {string}")
	public void userShouldPerformLoginAnd(String userName, String password) throws FileNotFoundException, IOException {
		pom.getLoginPage().login(userName, password);
	}

	@When("User should perform login {string}, {string} with Enter key")
	public void userShouldPerformLoginWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(userName, password);
	}

	@Then("User should verify after login error contains {string}")
	public void userShouldVerifyAfterLoginErrorContains(String errorMsg) {
		Assert.assertTrue("Verify after login errormsg", pom.getLoginPage().getErrormsg().getText().contains(errorMsg));

	}
}
