package project.tests;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import project.models.TestDB;
import project.pages.MainPage;
import project.pages.NewProjectPage;
import project.pages.NexagePage;
import project.pages.TestPage;
import project.sqlQueries.Queries;
import project.steps.ApiSteps;
import project.steps.UISteps;
import utils.MySQLUtil;
import utils.ReadPropertyUtil;

import java.io.IOException;
import java.sql.SQLException;

public class FinalTest extends BaseTest {

    TestDB testDB = new TestDB();
    TestDB testDB1 = new TestDB();
    private static final String RESOURCES_PATH = "src/main/resources/";
    private static final String API_PROPERTIES = "api.properties";
    private static final String URI = new ReadPropertyUtil(FinalTest.RESOURCES_PATH, FinalTest.API_PROPERTIES)
            .getProperty("uri");
    private static final String DB_URL = new ReadPropertyUtil(FinalTest.RESOURCES_PATH, FinalTest.API_PROPERTIES)
            .getProperty("dbURL");
    private static final String DB_LOGIN = new ReadPropertyUtil(FinalTest.RESOURCES_PATH, FinalTest.API_PROPERTIES)
            .getProperty("dbLogin");
    private static final String DB_PASSWORD = new ReadPropertyUtil(FinalTest.RESOURCES_PATH, FinalTest.API_PROPERTIES)
            .getProperty("dbPassword");
    private static final String NAME_OF_COOKIE = "token";
    private static final String METHOD_TOKEN_GET = "token/get?";
    private static final String METHOD_TESTS_GET = "test/get/json?";
    private static final String PROJECT_ID = "projectId=1";
    private static final String SCREENSHOT = new ReadPropertyUtil(FinalTest.RESOURCES_PATH, FinalTest.API_PROPERTIES)
            .getProperty("pathAndNameOfScreenshot");
    private static final String VARIANT = new ReadPropertyUtil(FinalTest.RESOURCES_PATH, FinalTest.API_PROPERTIES)
            .getProperty("variant");
    private static final String PROJECT_NAME = new ReadPropertyUtil(FinalTest.RESOURCES_PATH, FinalTest.API_PROPERTIES)
            .getProperty("project");

    @Test
    @Parameters({"id", "name", "status_id", "method_name", "project_id", "session_id", "start_time", "end_time", "env",
            "browser"})
    public void testAddProjectAndTest(String id, String name, String status_id, String method_name, String project_id,
                                      String session_id, String start_time, String end_time, String env, String browser)
            throws JSONException, NumberFormatException, IOException, SQLException {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageLoaded(), "Main page didn't load");

        //step one - get token and set cookies
        UISteps.setTokenInCookies(URI + METHOD_TOKEN_GET + VARIANT, NAME_OF_COOKIE);
        UISteps.refreshPage();
        Assert.assertTrue(mainPage.isVariantSelected(), "Desired variant doesn't select");

        //step two - go to Nexage page and get tests list
        mainPage.clickOnNexageProjectButton();
        NexagePage nexagePage = new NexagePage();
        Assert.assertTrue(nexagePage.isPageLoaded(), "Nexage page didn't load");
        ApiSteps.getTestList(URI + METHOD_TESTS_GET + PROJECT_ID);

        //step three - back to  projects page
        nexagePage.clickOnHomeButton();
        UISteps.addNewProject(PROJECT_NAME);
        UISteps.refreshPage();
        Assert.assertTrue(mainPage.isProjectAdded(), "New project is added");

        //step four - adding test on the new project page
        mainPage.clickOnCreatedProjectButton();
        NewProjectPage newProjectPage = new NewProjectPage();
        Assert.assertTrue(newProjectPage.isPageLoaded(), "new Project Page page didn't load");
        MySQLUtil.connectToDataBase(DB_URL, DB_LOGIN, DB_PASSWORD);
        Queries.addTest(id, name, status_id, method_name, project_id, session_id, start_time, end_time,
                env, browser);
        MySQLUtil.closeConnection();
        UISteps.takeAScreenshot(SCREENSHOT);
        Assert.assertTrue(newProjectPage.isTestAdded());

        //step five - checking new test fields
        newProjectPage.clickOnCreatedTestButton();
        TestPage testPage = new TestPage();
        Assert.assertTrue(testPage.isPageLoaded(), "Test page page didn't load");
        UISteps.setTestObject(testDB, id, name, status_id, method_name, project_id, session_id, start_time, end_time,
                env, browser);
        UISteps.setTestObjectFromPage(testDB1, testPage.getTestName(), testPage.getTestMethodName(),
                testPage.getEnvironment(), testPage.getBrowser());
        Assert.assertEquals(testDB, testDB1, "Data on the site is wrong");

    }
}
