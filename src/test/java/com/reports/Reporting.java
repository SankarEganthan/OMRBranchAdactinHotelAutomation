package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Sankar
 * @description Used to find Select Hotel Page web elements and execute
 * @date 01-09-2022
 */
public class Reporting {
	/**
	 * @description Used to generate report based on the json file
	 * @param jsonFile
	 */
	public static void generateJVMReport(String jsonFile) {
		// 1. Mention the path of jvmreport where to store?
		File file = new File(System.getProperty("user.dir") + "\\target");

		// 2. Create the Object for configuration class
		Configuration configuration = new Configuration(file, "OMRBranchAdactinHotelAutomationtest");

		// 3. Mention the os, browser type and version
		configuration.addClassifications("OS", "WIN8");
		configuration.addClassifications("BrowserType", "Chrome");
		configuration.addClassifications("Version", "IOS");
		configuration.addClassifications("Sprint", "34");

		// 4. Pass the json file to fetch results from json report file
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

		// 5. Build the JVm Report
		builder.generateReports();
	}

}
