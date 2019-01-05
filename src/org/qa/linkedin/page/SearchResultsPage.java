package org.qa.linkedin.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qa.linkedin.base.TestBase;
import org.qa.linkedin.util.TestUtil;
import org.testng.Reporter;

public class SearchResultsPage extends TestBase{

	public SearchResultsPage() throws IOException {
		super();
	PageFactory.initElements(driver, this);
	}

	public static final String HOME_TAB="//span[@class='nav-item__title'][contains(.,'Home')]";
	public static final String SEARCH_RESULTS_HEADER="//*[contains(@class,'search-results__total')]";
	
	public int getResultsCount() {
		wait.until(ExpectedConditions.titleContains("Search | LinkedIn"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_RESULTS_HEADER)));
		Reporter.log("fetch the results count text");
		String results_txt=driver.findElement(By.xpath(SEARCH_RESULTS_HEADER)).getText();
		Reporter.log("results count text is-->"+results_txt);
		//String results_txt="Showing 206,351 results";
		String[] str=results_txt.split("\\s");
		Reporter.log("results count in string format-->"+str[1]);
		int resultsCount=Integer.parseInt(str[1].replace(",",""));
		
		return resultsCount;
	}
	
	public void navigateToHomePage() {
		Reporter.log("click on Home tab");
		driver.findElement(By.xpath(HOME_TAB)).click();
		
	}
	
	
}
