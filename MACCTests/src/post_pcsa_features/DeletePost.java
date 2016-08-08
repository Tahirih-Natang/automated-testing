package post_pcsa_features;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import common.DataProviderCommonCode;

public class DeletePost extends DataProviderCommonCode{
	
	private String expectedURL;
	
	@Test
	public void deletepost() {
			
		driver.get(utilities.Constants.posts_list );
		try {			
			WebElement deleteButton = driver.findElement(By.linkText("Delete"));
			deleteButton.click();
			driver.findElement(By.xpath("html/body/div/div/form/div[2]/div/button")).click();
			expectedURL = utilities.Constants.posts_list;
			Assert.assertEquals(expectedURL, driver.getCurrentUrl());
			}
			catch(NoSuchElementException e) {
				System.out.println("No such element: Delete");
			}
	}

}
