# itbootcamp_final_selenium_project

This is the final project for web automation at IT Bootcamp with goal to demonstrate skills for software application testing with Selenium and TestNG libraries.

# Tehnologies and tests
This project uses the following technologies:

Java, Maven, Seleniumm TestNG, Git 

Project have tests arranged into 5 test scenarios:
Login tests: Verifying user login functionality
Signup tests: Verifying user signup functionality
Admin Cities tests: Testing functionalities for creating, editing and deleting cities
Auth Routes tests: Testing route protection for unauthenticated users
Locale tests: Testing page content in different languages

# Testing
Tests are organized using the testng.xml file. You can run all tests using Maven with
the following command: mvn clean test -Dsurefire.suiteXmlFiles=testng.xml
