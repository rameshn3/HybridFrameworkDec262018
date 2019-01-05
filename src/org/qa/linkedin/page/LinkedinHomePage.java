package org.qa.linkedin.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qa.linkedin.base.TestBase;
import org.testng.Assert;
import org.testng.Reporter;

public class LinkedinHomePage extends TestBase{

	public LinkedinHomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	
	public static final String SEARCH_EDITBOX="//*[@role='combobox' and @placeholder='Search']";
	
	public static final String SEARCH_BTN="//*[@data-control-name='nav.search_button']";
	
	public static final String PROFILE_CARD_SECTION="//*[contains(@class,'profile-rail-card container')]";
	
	public static final String PROFILE_IMAGE="//img[@class='nav-item__profile-member-photo nav-item__icon']";
	
	public static final String SIGNOUT_LINK="//*[@data-control-name='nav.settings_signout']";
	
	
	public void logoutTest() {
		Reporter.log("Executing the logout()");
		Reporter.log("verify the profile raild card section");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PROFILE_CARD_SECTION)));
		Reporter.log("click on profile image icon");
		driver.findElement(By.xpath(PROFILE_IMAGE)).click();
		Reporter.log("wait for the visibility of sign out link");
		WebElement signout_link=driver.findElement(By.xpath(SIGNOUT_LINK));
		wait.until(ExpectedConditions.visibilityOf(signout_link));
		Reporter.log("click on sign out link");
		signout_link.click();
		wait.until(ExpectedConditions.titleContains("LinkedIn: Log In or Sign Up"));
		Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up");
	}
	
	
	public SearchResultsPage peopleSearch(String keyword) throws IOException, InterruptedException {
		Reporter.log("Type the keyword in search editbox");
		driver.findElement(By.xpath(SEARCH_EDITBOX)).clear();
		driver.findElement(By.xpath(SEARCH_EDITBOX)).sendKeys(keyword);
		Reporter.log("click on search button");
		driver.findElement(By.xpath(SEARCH_BTN)).click();
		Thread.sleep(3000);
		return new SearchResultsPage();
	}
	
	
	
}
