# E-Commerce

### Tools and technologies used in the project:
* Selenium Webdriver
* TestNG
* Allure Report
* Extent Reports

### Project Design:
* Page Object Model (POM) design pattern
* Data Driven framework
* Fluent design approach (method chaining)
* The ***"Engine"*** package in *in/automationtesting/practice/engine* provides the core functionality to power and execute this project's automated tests

### How to run the project main test cases locally:
* A properties files can be found in *resources* package including all the configurations needed in the execution.
* Can find the test senarios in the *src/test/java* folder mainly in the *testscenario* package.
* To start the execution, open a command-line terminal on the project root path and type `mvn clean test`.
* After executing, you can easily generate the ***Allure Report*** by opening a command-line terminal on the project root path and type `allure serve target/allure-results` (needs to be able to execute mvn commands); Or you can find the Extent Report in this path 'target/extend-report'.

### Followed several best practices, including:
* Avoiding Page Factory.
* Did not use BaseTest and BasePage classes.
* Dynamic Configuration: Avoid using a static testing.xml file in favor of a more dynamic approach.
* Ensured not to mix implicit and explicit waits.
* Did not ignore exceptions.
* Applied only one assertion per method as this is considered a best practice.
* In XPath, utilized 'contains(@class, ...)' instead of 'equals(@class, ...)' to mitigate errors caused by auto-generated class names.
* Used 'test scenario' instead of 'test' to emphasize the end-to-end nature of the test.

### To further enhance our code ###
* Added ActionsBot to use Bot pattten recommeded by selenium team.
* Replaced hard-coded paths with a constants file to centralize configurations.
* Implemented regions to make the code more readable and organized.

### Running test cases on Chrome ###
https://github.com/user-attachments/assets/c3257a1c-66a9-4069-a6b3-38f52f36361a


### Allure Report ##
![image](https://github.com/user-attachments/assets/6802a613-f919-4d32-bc08-a483f9be4551)

### Extent Report ##
![image](https://github.com/user-attachments/assets/949237ed-2ce9-4fe6-b4b6-d6e088923580)


