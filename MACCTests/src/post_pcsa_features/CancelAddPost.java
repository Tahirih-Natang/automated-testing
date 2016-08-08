package post_pcsa_features;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import common.DataProviderCommonCode;

public class CancelAddPost extends DataProviderCommonCode{
	
	private String expectedURL;
	
	@Test
	public void canceladdpost() {
		
		driver.get(utilities.Constants.posts_list);
		WebElement addPost = driver.findElement(By.linkText(
				utilities.Constants.addNewPost));
		addPost.click();	
		WebElement cancel = driver.findElement(By.linkText("Cancel"));
		cancel.click();
		expectedURL = utilities.Constants.posts_list;
		Assert.assertEquals(expectedURL, driver.getCurrentUrl());
	}	

}
