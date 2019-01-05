package org.qa.linkedin.testcase;

import java.io.IOException;

import org.qa.linkedin.base.TestBase;
import org.qa.linkedin.page.LinkedinLandingPage;
import org.qa.linkedin.util.TestUtil;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinkedinLandingTest extends TestBase{
	LinkedinLandingPage llPg;
	public LinkedinLandingTest() throws IOException {
		super();
		
	}

@BeforeClass
public void launchUrl() throws IOException {
	llPg=new LinkedinLandingPage();
	initilization();
}


@Test
public void verifyLinkedinLogoTest() {
	llPg.verifyLogo();
}
	

@Test
public void verifyLinkedinLandingTitle() {
	String t=llPg.fetchTitle();
	Assert.assertEquals(t, "LinkedIn: Log In or Sign Up");
}

@Test
public void verifyLinkedinLoginSection() {
	llPg.verifyLoginSection();
	
}

@Test
public void verifyLinkedinLandingRegSection() {
	llPg.verifyRegistrationForm();
	String path=TestUtil.CaptureScreenShotWithTestStepName(driver,"regfarm");
	Reporter.log(path);
}


@Test
public void verifyLinkedinLandingForgotPwdLink() {
	llPg.validateForgotPassword();
	String path=TestUtil.CaptureScreenShotWithTestStepName(driver,"forgotpassword");
	Reporter.log(path);
	
}



@AfterClass
public void tearDown() {
driver.close();
}

}
