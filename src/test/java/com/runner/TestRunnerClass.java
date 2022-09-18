package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

/**
 * 
 * @author Sankar
 * @description Used to run the Cucumber framework with all the classes based on the feature files
 * @date 01-09-2022
 */

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true, stepNotifications =true, snippets = SnippetType.CAMELCASE, plugin= {"json:target//Output.json"}, features = "src\\test\\resources", glue = "com.stepdefinition")
public class TestRunnerClass {
	@AfterClass
	public static void afterClass() {
		Reporting.generateJVMReport(System.getProperty("user.dir")+"\\target\\Output.json");
	}
}
