package post_pcsa_features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import common.DataProviderCommonCode;

public class EditPost extends DataProviderCommonCode{
	
	private String expectedURL;
	
	@Test(dataProvider = "editPost")
	public void editpost(String title, String description) {
		
		driver.get(utilities.Constants.posts_list);
		try {			
			WebElement editButton = driver.findElement(By.linkText("Edit"));
			editButton.click();
			WebElement titre = driver.findElement(By.name("title"));
			titre.clear();
			titre.sendKeys(title);
			WebElement description_post = driver.findElement(By.name("description"));
			description_post.clear();
			description_post.sendKeys(description);
			WebElement submitButton = driver.findElement(By.xpath("html/body/div/div/form/div[3]/div/button"));
			submitButton.click();
			WebElement list = driver.findElement(By.linkText("Back to Post List"));
			list.click();
			expectedURL = utilities.Constants.posts_list; 
			Assert.assertEquals(expectedURL, driver.getCurrentUrl());
			}
			catch(NoSuchElementException e) {
				System.out.println("No such element: Edit");
			}
	}
	
	@DataProvider(name = "editPost")
	public Object[][] editpostDataProvider() throws Exception {
		Object[][]connect = utilities.ExcelReader.connect(utilities.Constants.pathTestData,
				utilities.Constants.postDataSheetName);
		
		Object[][] cellData = utilities.ExcelReader.read(connect);
		return cellData;	
	}
	

}
