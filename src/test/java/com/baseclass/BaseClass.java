package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Sankar
 * @description Used to maintains the all resuable methods
 * @date 01-09-2022
 * 
 */

public class BaseClass {
	public static WebDriver driver;

	/**
	 * @description Used to get values from properties file
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));
		String value = (String) properties.get(key);
		return value;
	}

	/**
	 * @description Used to select the driver type
	 * @param browserType
	 */

	public void getDriver(String browserType) {
		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}
	}

	/**
	 * @description Used to enter the url in the browser
	 * @param url
	 */

	public void enterUrl(String url) {
		driver.get(url);
	}

	/**
	 * @description Used to maximize the window
	 */

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @description Used to find the web element using ID
	 * @param username
	 * @return WebElement
	 */

	public WebElement elementFindById(String username) {
		WebElement element = driver.findElement(By.id(username));
		return element;
	}

	/**
	 * @description Used to clear the data in the text box
	 * @param element
	 */

	public static void elementClear(WebElement element) {
		element.clear();
	}

	/**
	 * @description Used to pass values using sendKeys in text box
	 * @param element
	 * @param text
	 */

	public static void elementSendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * @description Used to click the web element
	 * @param element
	 */

	public static void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * @description Used to get the attribute value of the web element
	 * @param element
	 * @return String
	 */

	public static String elementGetAttribute(WebElement element) {
		String value = element.getAttribute("value");
		return value;
	}

	/**
	 * @description Used to set attribute using JavascriptExecutor
	 * @param element
	 * @param text
	 */

	public static void elementSetAttribute(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', text)", element);

	}

	/**
	 * @description Used to get text using web element
	 * @param element
	 * @return String
	 */

	public static String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @description Used to select the dropdown option by visible text
	 * @param element
	 * @param text
	 */

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * description Used to identify no of rows in the Excel
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return int
	 * @throws IOException
	 */
	public int getExcelRowNumbers(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		return numberOfRows;
	}

	/**
	 * @description Used to get value from the excel
	 * @param filePath
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return String
	 * @throws IOException
	 */

	public String getExcelCellValue(String filePath, String sheetName, int rownum, int cellnum) throws IOException {
		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		String value = null;
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				value = simpleDateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					value = String.valueOf(round);
				} else {
					value = String.valueOf(numericCellValue);
				}
			}
			break;
		default:
			break;
		}
		System.out.println(value);
		return value;
	}

	/**
	 * @description Used to write value in Excel
	 * @param filePath
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws IOException
	 */

	public void attributeValueWriteInExcel(String filePath, String sheetName, int rownum, int cellnum, String value)
			throws IOException {
		File file = new File(filePath);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(value);
		FileOutputStream stream1 = new FileOutputStream(file);
		workbook.write(stream1);
	}

	/**
	 * @description Used to give tab key using Robot Keys
	 * @throws AWTException
	 */

	public void robotKeyTAB() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	/**
	 * @description Used to give tab key using Robot Keys
	 * @throws AWTException
	 */

	public void robotKeyEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * @description Used to switch to alerts
	 * @return Alert
	 */

	public Alert switchToAlertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}

	/**
	 * @description Used to wait the browser to continue next step
	 */

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	/**
	 * @description used to take screenshot and give as bytes
	 * @return
	 */

	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}

	/**
	 * @description Used to close the browser
	 */

	public void quit() {
		driver.quit();
	}

}
