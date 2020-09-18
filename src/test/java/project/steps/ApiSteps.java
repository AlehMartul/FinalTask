package project.steps;

import utils.ApiUtil;

public class ApiSteps {

    private static String TOKEN;


    public static String getToken(String uri) {
        TOKEN = ApiUtil.post(uri).getBody().asString();
        return TOKEN;
    }

    public static String getTestList(String uri) {
        String tests = ApiUtil.post(uri).getBody().asString();
        return tests;
    }

}
