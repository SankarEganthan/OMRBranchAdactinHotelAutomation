package com.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Sankar
 * @description Used to find Login Page web elements and execute
 * @date 01-09-2022
 */

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @description Used to find user name text box web element
	 */

	@FindBy(id = "username")
	private WebElement txtUserName;

	/**
	 * @description Used to find password text box web element
	 */
	@FindBy(id = "password")
	private WebElement txtPassword;

	/**
	 * @description Used to find login button web element
	 */

	@FindBy(id = "login")
	private WebElement btnLogin;

	/**
	 * @description Used to find error msg web element
	 */

	@FindBy(xpath = "//b[contains(text(), 'Invalid Login details or Your Password might have expired')]")
	private WebElement errormsg;

	public WebElement getErrormsg() {
		return errormsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @description Used to execute login page
	 * @param userName
	 * @param password
	 */
	// 1.
	// 3.
	public void login(String userName, String password) {
		elementSendKeys(getTxtUserName(), userName);
		elementSendKeys(getTxtPassword(), password);
		elementClick(getBtnLogin());
	}

	/**
	 * @description Used to execute login page with enter key
	 * @param userName
	 * @param password
	 * @throws AWTException
	 */
	// 2. Verifying login with Enter key
	public void loginWithEnter(String userName, String password) throws AWTException {
		elementSendKeys(getTxtUserName(), userName);
		elementSendKeys(getTxtPassword(), password);
		robotKeyTAB();
		robotKeyTAB();
		robotKeyEnter();
	}

}
