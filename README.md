# **Selenium Cucumber Framework**

This repository provides a UI testing (using Selenium). It leverages **Cucumber** for Behavior-Driven Development, **TestNG** for test management, and integrates seamlessly with CI/CD pipelines for scalable, maintainable, and robust test automation.

**WEBSITE**: [Best Buy Canada](https://www.bestbuy.ca/en-ca)

---

## **Features**

### **1. Testing Support**
- **UI Testing**: Driven by Selenium with Page Object Model (POM).
- **BDD Support**: Cucumber for behavior-driven testing.
- **Test Management**: TestNG ensures structured and organized execution.

### **2. Reporting**
- Extent Reports and Cucumber Reports for detailed test insights.
- Logs available in `logs/automation.log` for debugging.

---

## **Framework Structure**

### **1. UI Testing**
- **Pages**: Implements POM design (`com/bestbuy/PageObjectRepository`).
  - Pages include `LoginPage`, `CreateNewAccountPage`, etc.
- **Step Definitions**: Cucumber step implementations (`com/bestbuy/stepdefinitions`).
- **Runners**: Test execution using Cucumber-junit (`com/bestbuy/runners`).

### **2. Utilities**
- **ConfigProperties**: Reads data from any properties file.
- **ExtentReportManager**: Manages all the extend report configurations.
- **LoggerManager**: Manages the logger instance for complete automation.
- **ScreenShotManager**: Manages all the related screenshot methods to interact with webdriver.

---

## **File and Folder Details**

| **Folder/File**             | **Description**                                                                 |
|-----------------------------|-------------------------------------------------------------------------------  |
| `logs`                      | Logs generated during test execution.                                          |
| `target/Extent-Reports`     | Extent Reports and Cucumber HTML reports.                                      |
| `resources/features`        | Gherkin feature files for BDD tests.                                           |
| `stepdefinitions`           | Test data steps with respective functionality                                  |
| `pom.xml`                   | Maven configuration file for dependencies and project setup.                   |

---

### **Dependencies**

The project relies on the following major dependencies:  
- **Selenium**: For browser automation.  
- **Cucumber**: For behavior-driven testing.  
- **TestNG**: For test management and parallel execution.   
- **ExtentReports**: For generating HTML test reports.  
- **Faker**: For generating random test data.  
- **Log4j**: For logging framework and debugging.   

---

**Happy Testing! 🎉**
