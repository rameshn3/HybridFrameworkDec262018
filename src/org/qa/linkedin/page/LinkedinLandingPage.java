package org.qa.linkedin.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qa.linkedin.base.TestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LinkedinLandingPage extends TestBase{

	public LinkedinLandingPage() throws IOException {
		super();
	PageFactory.initElements(driver, this);	
	}
	
	
public static final String LINKEDIN_LOGO="lazy-loaded";
public static final String LOGIN_SECTION="login-form";
public static final String EMAIL_EDITBOX="login-email";
public static final String PWD_EDITBOX="session_password";
public static final String SIGNIN_BTN="input.login.submit-button";
public static final String REGISTRATION_SECTION="reg-form";
public static final String FORGOTPWD_LINK="Forgot password?";
public String fetchTitle() {
	return driver.getTitle();
}

public void verifyLogo() { 
	  
 wait.until(ExpectedConditions.presenceOfElementLocated(By.className(LINKEDIN_LOGO)));
Assert.assertTrue(driver.findElement(By.className(LINKEDIN_LOGO)).isDisplayed(), "linkedinlogo is not present");
	 
}

public void verifyLoginSection() {
	
	  Reporter.log("verifying the linkedin login section present in the page or not");
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.className(LOGIN_SECTION)));
	  Assert.assertTrue(driver.findElement(By.className(LOGIN_SECTION)).isDisplayed(), "linkedin login section is not present");
	  Reporter.log("Linkedin login section is successfully displayed"); 
	 
}


public void verifyRegistrationForm() {

	  Reporter.log("verifying the linkedin RegistrationForm section present in the page or not");
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.className(REGISTRATION_SECTION)));
	  Assert.assertTrue(driver.findElement(By.className(REGISTRATION_SECTION)).isDisplayed(), "linkedin RegistrationForm section is not present");
	  Reporter.log("Linkedin RegistrationForm section is successfully displayed"); 
	 
}



public void validateForgotPassword() {
	
	 Reporter.log("click on forgot password link to validate");
	 driver.findElement(By.linkText(FORGOTPWD_LINK)).click();
	 Reporter.log("verify the forgot password page title--Reset Password | LinkedIn");
	 wait.until(ExpectedConditions.titleContains("Reset Password | LinkedIn"));
	  Assert.assertEquals(driver.getTitle(), "Reset Password | LinkedIn");
	  Reporter.log("Linkedin fogot password title  is verified successfully ");
	  Reporter.log("navigate back to linkedin home page");
	  driver.navigate().back();
	  Reporter.log("verifying the linkedin page title");
	  wait.until(ExpectedConditions.titleContains("LinkedIn: Log In or Sign Up"));
	  Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up");
	  Reporter.log("Linkedin title  is verified successfully ");
	 
}

public LinkedinHomePage login() throws IOException {
	Reporter.log("type the username value in email editbox");
	driver.findElement(By.id(EMAIL_EDITBOX)).sendKeys(prop.getProperty("username"));
	Reporter.log("Type the password value in password editbox");
	driver.findElement(By.name(PWD_EDITBOX)).sendKeys(prop.getProperty("pwd"));
	Reporter.log("click on sign in button");
	driver.findElement(By.cssSelector(SIGNIN_BTN)).click();
	return new LinkedinHomePage();
}



}
