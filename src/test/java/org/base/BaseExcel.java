package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseExcel {
	static WebDriver driver;

	public void browserLanch() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\Frameowork\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Browser Lauch sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("browser launch failed");
		}
	}

	public void geturl(String url) {
		driver.get(url);
	}

	public void currenturl() {
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);

	}

	public String writedatatoexcel(String pathname, String SheetName, int rownum, int cellnum, String value)
			throws IOException {
		File file = new File(pathname);
		FileOutputStream f = new FileOutputStream(file);
		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet(SheetName);
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(value);
		workbook.write(f);
		return value;

	}

	public String getdatafromexcel(String pathname, String sheetname, int rownum, int cellnum) throws IOException {
		File file = new File(pathname);
		FileInputStream f = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(f);
		Sheet sheet = w.getSheet(sheetname);
		Row r = sheet.getRow(rownum);
		Cell c = r.getCell(cellnum);

		System.out.println(sheet.getRow(rownum).getCell(cellnum));
		int CellType = c.getCellType();

		String value = "";

		if (CellType == 1) {
			value = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {

			Date date = c.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			value = dateFormat.format(date);

		} else {
			double parsedouble = c.getNumericCellValue();
			DecimalFormat df = new DecimalFormat("0");
			String formatnumber = df.format(parsedouble);
			value = String.valueOf(formatnumber);

		}
		return value;

	}

	public WebElement locatorbyid(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement locatorbyxpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}

	public void quitbrowser() {
		driver.close();
		driver.quit();
	}
	public String selectbyid(WebElement locatorbyid, String value) {
    	 Select s=new Select(locatorbyid);
    	 s.selectByValue(value);
    	 return value;
                
	}
	
	public void send(WebElement e, String s) {
		e.sendKeys(s);
	}
	
}
