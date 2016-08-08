package post_pcsa_features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import common.DataProviderCommonCode;

public class AddPost extends DataProviderCommonCode{
	
	private String expectedURL;

	@Test(dataProvider = "post")
	public void addpostTest(String title, String description) {
		
		driver.get(utilities.Constants.posts_list);
		
		//add a new post
		WebElement addpostButton = driver.findElement(By.linkText(utilities.Constants.addNewPost));
		addpostButton.click();
		WebElement ttle = driver.findElement(By.name("title"));
		ttle.sendKeys(title);
		WebElement description_post = driver.findElement(By.name("description"));
		description_post.sendKeys(description);
		WebElement submitButton = driver.findElement(By.xpath("html/body/div/div/form/div[3]/div/button"));
		submitButton.click();
		expectedURL = utilities.Constants.posts_list; 
		Assert.assertEquals(expectedURL, driver.getCurrentUrl());
	}
	@DataProvider(name = "post")
	public Object[][] addpostDataProvider() throws Exception {
		Object[][]connect = utilities.ExcelReader.connect(utilities.Constants.pathTestData,
				utilities.Constants.postDataSheetName);
		
		Object[][] cellData = utilities.ExcelReader.read(connect);
		return cellData;	
	}
}
