package post_pcsa_features;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.DataProviderCommonCode;

public class ViewPost extends DataProviderCommonCode {
	
	private String expectedURL;
	
	@Test
	public void viewpost() {
		
		driver.get(utilities.Constants.posts_list);
		try {
			WebElement viewButton = driver.findElement(By.linkText("View"));
			viewButton.click();
			WebElement list = driver.findElement(By.linkText("Back to Post List"));
			list.click();
			expectedURL = utilities.Constants.posts_list;
			Assert.assertEquals(expectedURL, driver.getCurrentUrl());
			}
			catch(NoSuchElementException e) {
				System.out.println("No such element: View");
			}
	}

}
