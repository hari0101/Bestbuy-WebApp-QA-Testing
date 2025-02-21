package com.bestbuy.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features/createaccount.feature",
		//glue = {"com.bestbuy.stepdefinitions", "com.bestbuy.hooks"},
		plugin = {"pretty", "html:target/Cucumber-Reports/cucumber-reports.html"},
		monochrome = true,
		stepNotifications = true,
		dryRun = true
		)

public class CucumberTestRunner {

}
