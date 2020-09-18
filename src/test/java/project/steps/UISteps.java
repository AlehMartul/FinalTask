package project.steps;

import aquality.selenium.browser.AqualityServices;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import project.models.TestDB;
import project.pages.MainPage;
import utils.CookiesUtils;

import java.io.File;
import java.io.IOException;

public class UISteps {

    public static void refreshPage() {
        AqualityServices.getBrowser().refresh();
    }

    public static void setTokenInCookies(String uri, String cookieName) {
        Cookie cookie = new Cookie(cookieName, ApiSteps.getToken(uri));
        CookiesUtils.setCookie(cookie);
    }

    public static void takeAScreenshot(String pathAndName) throws IOException {
        File scrFile = ((TakesScreenshot) AqualityServices.getBrowser().getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(pathAndName));
    }

    public static void setTestObject(TestDB test, String id, String name, String status_id, String method_name, String project_id,
                                     String session_id, String start_time, String end_time, String env, String browser) {
        test.setAllFields(test, id, name, status_id, method_name, project_id, session_id,  start_time, end_time, env,
                browser);
    }

    public static void setTestObjectFromPage(TestDB test, String name, String method_name, String env, String browser) {
        test.setFieldsFromPage(test, name, method_name, env, browser);
    }

    public static void addNewProject(String text) {
        MainPage mainPage = new MainPage();
        mainPage.clickOnAddButton();
        mainPage.sendText(text);
        mainPage.clickOnSaveProjectButton();
    }
}
