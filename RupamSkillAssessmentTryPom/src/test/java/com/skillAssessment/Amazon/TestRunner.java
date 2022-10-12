package com.skillAssessment.Amazon;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features="Features" , glue = "StepDefinationClass", dryRun = false , monochrome = true )
	public class TestRunner {
}
