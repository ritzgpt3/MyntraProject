package com.MyntraProject.pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyntraProject.keywords.Keyword;

public class BlogsPage {
	private static final Logger LOG = Logger.getLogger(BlogsPage.class);
	public BlogsPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}

	public void scrollBlog() {
		com.MyntraProject.keywords.Keyword.getDriver().executeScript("window.scrollBy(0,700)");
	}

	@FindBy(css = "div.blog-intro__main")
	public WebElement blogLink;

	public void clickOnABlogToVerifyItsAccessible() {
		blogLink.click();
		String text = Keyword.getDriver().getCurrentUrl();
		//System.out.println("Blog link is accessible: " + text);
		LOG.info("Blog link is accessible: " + text);
	}
}
