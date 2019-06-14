package learntechpuzz.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import base.BaseScenario;
import cucumber.api.java.en.Given;

public class CommonStepDef extends BaseScenario {

	/**
	 * Common Step to Open the site with device
	 * 
	 * @param screenSize desktop | tablet | mobile
	 * @throws Throwable
	 */

	@Given("^user is on homepage opened$")
	public void user_is_on_homepage() throws Throwable {

		WebDriver driver = getDriver();
		String screenSize = "desktop";
		if (screenSize.equalsIgnoreCase("desktop")) {
			// Resize the browser to desktop
			driver.manage().window().setPosition(new Point(0, 0));
			driver.manage().window().setSize(new Dimension(1968, 1024));
		} else if (screenSize.equalsIgnoreCase("mobile")) {
			// Resize the browser to mobile
			driver.manage().window().setPosition(new Point(0, 0));
			driver.manage().window().setSize(new Dimension(320, 568));
		} else if (screenSize.equalsIgnoreCase("tablet")) {
			// Resize the browser to mobile
			driver.manage().window().setPosition(new Point(0, 0));
			driver.manage().window().setSize(new Dimension(768, 1024));
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(getSiteBaseUrl());

	}

}