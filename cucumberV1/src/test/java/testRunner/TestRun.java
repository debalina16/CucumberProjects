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
@CucumberOptions(
		         features =".//Features/LoginMap.feature", 
                 glue="StepDefinitions", 
                 dryRun=false, 
                 monochrome=true,
                 plugin ={"pretty","html:test-output"}
		         //tags= {"~@smoketest","~@regressiontest"}
                 )


public class TestRun {

}
