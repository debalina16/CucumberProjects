/**
 * 
 */
package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Debalina
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/Login.feature", glue = "StepDefinitions", dryRun = true, plugin = { "pretty",
		"html:test-output" }, monochrome = true)
public class TestRun {

}
