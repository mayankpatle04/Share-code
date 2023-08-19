package com.vikas.test.altoromutual;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vikas.framework.core.BaseTestSuite;
import com.vikas.framework.utils.CSVReader;
import com.vikas.framework.utils.ExcelReader;
import com.vikas.pages.altoromutual.CommentsPage;
import com.vikas.pages.altoromutual.FeedbackPage;

public class FeedbackFormTest extends BaseTestSuite {

	@BeforeMethod
	public void openUrl() {
		//driver.get("http://demo.testfire.net/feedback.aspx");

	}
	// Read parameter from XML file. make sure you have <parameter name=""
	// value=""> defined in your testng suite file
	// @Parameters({"USER_NAME","USER_EMAIL","FEEDBACK_SUBJECT","FEEDBACK_COMMENT"})
	// @Test
	// public void testFeedbackForm(String name,String email, String
	// subject,String comment){
	// System.out.println("Name: "+name);
	// FeedbackPage feedbackpage = PageFactory.initElements(driver,
	// FeedbackPage.class);
	// feedbackpage.setFeedbackData(name, email, subject, comment);
	// CommentsPage commentsPage = feedbackpage.clickSubmitButton();
	// Assert.assertEquals(commentsPage.getHeadingText(), "Thank You");
	// }

	@Test(dataProvider="FEEDBACK_DATA_FROM_EXCEL")
	public void testFeedbackForm(String name, String email, String subject, String comment) {
		System.out.println("Name: " + name+", Email: "+email);
//		FeedbackPage feedbackpage = PageFactory.initElements(driver, FeedbackPage.class);
//		feedbackpage.setFeedbackData(name, email, subject, comment);
//		CommentsPage commentsPage = feedbackpage.clickSubmitButton();
//		Assert.assertEquals(commentsPage.getHeadingText(), "Thank You");
	}

//	@DataProvider(name="FEEDBACK_DATA")
//	public Object[][] getData() {
//
//		Object arr[][] = new Object[][] { 
//			{ "Vikas", "vikast@mail.com", "Subject1","Comment1" }, 
//			{ "Ashwini", "ash@bollywood.com", "Job Application","Please consider me for Villen post" }};
//		return arr;
//	}
	@DataProvider(name="FEEDBACK_DATA_FROM_EXCEL")
	public Object[][] getData() {

		ExcelReader reader = new ExcelReader("feedback_test_data.xlsx");
		return reader.readData();
	}
	@Test(dataProvider="FEEDBACK_DATA_FROM_CSV")
	public void testFeedbackFormCSVTests(String name, String email, String subject, String comment) {
		System.out.println("CSV , Name: "+name+", Email:"+email);
	}
	@DataProvider(name="FEEDBACK_DATA_FROM_CSV")
	public Object[][] getDataFromCSV() {

		CSVReader reader = new CSVReader("feedback_test_csv_data.csv");
		return reader.readFile();
	}

	
	
}
