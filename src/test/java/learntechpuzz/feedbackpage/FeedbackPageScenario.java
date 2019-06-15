package learntechpuzz.feedbackpage;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import base.BaseScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeedbackPageScenario extends BaseScenario {

	@When("^User navigate to Feedback Page$")
	public void user_navigates_to_Feedback_Page() throws Throwable {
		driver.navigate().to("http://learntechpuzz.com/feedback");
	}

	@When("^User enter the following data and click on Submit button$")
	public void user_enter_the_following_data(DataTable feedbackData) throws Throwable {

		for (Map<String, String> data : feedbackData.asMaps(String.class, String.class)) {
			driver.findElement(By.id("firstName")).sendKeys(data.get("firstName"));
			driver.findElement(By.id("lastName")).sendKeys(data.get("lastName"));
			driver.findElement(By.id("email")).sendKeys(data.get("email"));
			driver.findElement(By.id("mobile")).sendKeys(data.get("mobile"));
			driver.findElement(By.id("comments")).sendKeys(data.get("comments"));
			Thread.sleep(3000);
			driver.findElement(By.id("submit")).click();
		}

	}

	@Then("^Success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		String exp_message = "Thank you very much for the valuable feedback!";
		String actual = driver.findElement(By.id("feedbackConfirmMsg")).getText();
		Assert.assertEquals(exp_message, actual);
		Thread.sleep(3000);
		driver.quit();
	}

}
