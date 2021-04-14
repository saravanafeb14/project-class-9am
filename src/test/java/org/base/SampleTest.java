package org.base;

import org.openqa.selenium.WebDriver;

public class SampleTest extends BaseExcel{
	public void main(String[] args) {
	  SampleTest base=new SampleTest();
	       WebDriver driver=base.getDriver();
	       base.loadurl("https://www.facebook.com/");
	       base.maximize();
	       
		
	}

	private void maximize() {
		// TODO Auto-generated method stub
		
	}

	private void loadurl(String string) {
		// TODO Auto-generated method stub
		
	}

	private WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
           
	
	


