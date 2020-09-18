package utils;

import java.io.IOException;

public class TestRailApiUtils {

    public static final String RESOURCES_PATH = "src/main/resources/";
    public static final String PROPERTIES = "api.properties";
    private static final String URI = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("UriApiTestRail");
    static String ADD_RESULT = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("addResult");
    static String ADD_ATTACH = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("addAttach");
    static String TEST_ID = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("testId");
    static String RESULT_ID = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("resultId");
    static String BASE_URI = String.format(URI, ADD_RESULT, TEST_ID);
    static String BASE_URI_FOR_ATTACHMENT = String.format(URI, ADD_ATTACH, RESULT_ID);
    static String LOGIN = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("login");
    static String PASSWORD = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("password");
    static String BODY = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("body");
    static String NAME_OF_SCREENSHOT = new ReadPropertyUtil(TestRailApiUtils.RESOURCES_PATH, TestRailApiUtils.PROPERTIES)
            .getProperty("pathAndNameOfScreenshot");


    public static void addResultToRun(String result) {
        ApiUtil apiUtil = new ApiUtil();
        apiUtil.postResult(BASE_URI, LOGIN, PASSWORD, String.format(BODY, result));
    }

    public static void addAttachmentToResult() throws IOException {
        FilesUtil.takeScreenshot(NAME_OF_SCREENSHOT);
        ApiUtil apiUtil = new ApiUtil();
        apiUtil.postScreenshot(BASE_URI_FOR_ATTACHMENT, LOGIN, PASSWORD, NAME_OF_SCREENSHOT);
    }
}