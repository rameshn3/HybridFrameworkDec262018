package org.qa.linkedin.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.qa.linkedin.base.TestBase;
import org.qa.linkedin.page.LinkedinHomePage;
import org.qa.linkedin.page.LinkedinLandingPage;
import org.qa.linkedin.page.SearchResultsPage;
import org.qa.linkedin.util.TestUtil;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{
	LinkedinLandingPage llPg;
	LinkedinHomePage lhPg;
	SearchResultsPage srchPg;
	String fpath=System.getProperty("user.dir")+"\\src\\org\\qa\\linkedin\\data\\searchdata.xlsx";
	
	
	public SearchTest() throws IOException {
		super();
		
	}

@BeforeClass
public void launchUrl() throws IOException {
	llPg=new LinkedinLandingPage();
	lhPg=new LinkedinHomePage();
	srchPg=new SearchResultsPage();
	initilization();
	String path=TestUtil.CaptureScreenShotWithTestStepName(driver,"landingPage");
	Reporter.log(path);
}


@Test
public void validateLoginTest() throws IOException {
	lhPg=llPg.login();

}
	
@Test(dependsOnMethods= {"validateLoginTest"},dataProvider="testData")
public void searchTest(String keyword) throws IOException, InterruptedException {
	srchPg=lhPg.peopleSearch(keyword);
	int cnt=srchPg.getResultsCount();
	String path=TestUtil.CaptureScreenShotWithTestStepName(driver,"searchresultsPagefor_"+keyword);
	Reporter.log(path);
	Reporter.log("search results count is-->"+cnt);
	
}

@DataProvider
public Object[][] testData() throws InvalidFormatException, IOException{
	Object[][] data=TestUtil.getTestData(fpath, "Sheet1");
	return data;
}





@AfterClass
public void tearDown() {
srchPg.navigateToHomePage();
String path=TestUtil.CaptureScreenShotWithTestStepName(driver,"HomeTab");
Reporter.log(path);
lhPg.logoutTest();
String logpath=TestUtil.CaptureScreenShotWithTestStepName(driver,"logout");
Reporter.log(logpath);
driver.close();
}

}
