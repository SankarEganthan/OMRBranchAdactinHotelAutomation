package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Sankar
 * @description Used to execute browser launch and take screenshot for all scenarios
 *
 */
public class HookClass extends BaseClass{

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		enterUrl(getPropertyFileValue("url"));	
		maximizeWindow();
		implicitWait();
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		scenario.attach(screenshot(), "images/PNG", "Every Senario");
		quit();
	}
}
