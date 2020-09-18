package project.tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.ITestResult;
import utils.ReadPropertyUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.TestRailApiUtils;

import java.io.IOException;

public abstract class BaseTest {

    private static final String RESOURCES_PATH = "src/main/resources/";
    private static final String API_PROPERTIES = "api.properties";
    private static final String MAIN_URL = new ReadPropertyUtil(BaseTest.RESOURCES_PATH, BaseTest.API_PROPERTIES)
            .getProperty("mainUrl");

    protected BaseTest() {
    }

    @BeforeMethod
    protected void beforeMethod() {
        getBrowser().maximize();
        getBrowser().goTo(MAIN_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestMethod(ITestResult result) throws IOException {
        TestRailApiUtils.addAttachmentToResult();
        if (result.getStatus() == ITestResult.SUCCESS) {
            TestRailApiUtils.addResultToRun("passed");
        } else {
            TestRailApiUtils.addResultToRun("failed");
        }
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
            AqualityServices.getLogger().info("Closing browser");
        }
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
}
