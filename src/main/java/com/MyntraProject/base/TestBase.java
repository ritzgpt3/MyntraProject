package com.MyntraProject.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.MyntraProject.keywords.Keyword;

public class TestBase {
	Keyword keyword = new Keyword();

	@BeforeMethod
	public void setUp() {
		keyword.openBrowser(Config.getBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl("dev"));
	}

	@AfterMethod
	public void tearDown() {
		keyword.quiteAllWindows();
	}
}
