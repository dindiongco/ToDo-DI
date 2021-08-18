package com.qa.selenium;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.index.IndexPage;

public class IndexTest {

	private WebDriver driver;

	@BeforeEach
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();

		Timeouts timeouts = driver.manage().timeouts();
		timeouts.implicitlyWait(5, TimeUnit.SECONDS);
		timeouts.pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	@Test
	public void testCreate() {

		String testString = "Get tea";

		IndexPage index = PageFactory.initElements(driver, IndexPage.class);

		this.driver.get(index.URL);

		index.create(testString);

		assertThat(index.checkTask().toLowerCase().contains(testString));
	}

	@Test
	public void testUpdate() {
		
		String testString = "Meditate";

		IndexPage index = PageFactory.initElements(driver, IndexPage.class);

		this.driver.get(index.URL);
		
		index.update(testString);
		
		assertThat(index.checkTask().toLowerCase().contains(testString));
	}

	@AfterEach
	public void teardown() {
		this.driver.quit();
	}
}
