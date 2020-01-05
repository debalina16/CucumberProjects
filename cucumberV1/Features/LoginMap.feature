Feature: Login user using Map

@smoketest
Scenario: Successfully Login with Valid Credentials with Datatable multiple parameter
Given User Launch Chrome Browser
When User open URL "https://admin-demo.nopcommerce.com/login"
And User enters registerd username and password as a parameter for multiple parameter testing
    |      user     | password |
    | admin@yourstore.com | admin |
    | admin@yourstore.com | admin123333 |
And click on Login
Then Page Title should be "Dashboard / nopCommerce administration" 
When User click on Logout link
Then Page Title should be "Your store. Login"
And close browser

 @regressiontest 
Scenario: Successfully Login with Valid Credentials with Datatable single parameter
Given User Launch Chrome Browser
When User open URL "https://admin-demo.nopcommerce.com/login"
And User enters registerd username and password as a parameter
    | admin@yourstore.com | admin |
	
And click on Login
Then Page Title should be "Dashboard / nopCommerce administration" 
When User click on Logout link
Then Page Title should be "Your store. Login"
And close browser





