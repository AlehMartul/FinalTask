package project.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class TestPage extends BasePage {

    private static final String X_PATHS = "//*[text()='%s']/following-sibling::p";
    private static final String TEST_NAME = "Test name";
    private static final String TEST_METHOD_NAME = "Test method name";
    private static final String ENVIRONMENT = "Environment";
    private static final String BROWSER = "Browser";
    private ILabel lblBrowser = AqualityServices.getElementFactory()
            .getLabel(By.xpath(String.format(X_PATHS, BROWSER)), "Checking browser");
    private ILabel lblTestName = AqualityServices.getElementFactory()
            .getLabel(By.xpath(String.format(X_PATHS, TEST_NAME)), "Checking test name");
    private ILabel lblTestMethodName = AqualityServices.getElementFactory()
            .getLabel(By.xpath(String.format(X_PATHS, TEST_METHOD_NAME)), "Checking test method name");
    private ILabel lblEnvironment = AqualityServices.getElementFactory()
            .getLabel(By.xpath(String.format(X_PATHS, ENVIRONMENT)), "Checking environment");

    public TestPage() {
        super(By.xpath("//*[text()='Home']"), "TestPage");
    }

    public String getBrowser () {
        return lblBrowser.getText();
    }

    public String getTestName () {
        return lblTestName.getText();
    }

    public String getTestMethodName () {
        return lblTestMethodName.getText();
    }

    public String getEnvironment () {
        return lblEnvironment.getText();
    }

}
