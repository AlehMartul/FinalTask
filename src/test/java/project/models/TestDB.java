package project.models;

import aquality.selenium.browser.AqualityServices;

public class TestDB {

    private String id;
    private String name;
    private String status_id;
    private String method_name;
    private String project_id;
    private String session_id;
    private String start_time;
    private String end_time;
    private String env;
    private String browser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public void setAllFields(TestDB test, String id, String name, String status_id, String method_name, String project_id,
                             String session_id, String start_time, String end_time, String env, String browser) {
        AqualityServices.getLogger().info("Setting all fields");
        test.setId(id);
        test.setName(name);
        test.setStatus_id(status_id);
        test.setMethod_name(method_name);
        test.setProject_id(project_id);
        test.setSession_id(session_id);
        test.setStart_time(start_time);
        test.setEnd_time(end_time);
        test.setEnv(env);
        test.setBrowser(browser);
    }

    public void setFieldsFromPage(TestDB test, String name, String method_name, String env, String browser) {
        AqualityServices.getLogger().info("Setting fields from test page");
        test.setName(name);
        test.setMethod_name(method_name);
        test.setEnv(env);
        test.setBrowser(browser);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode() + method_name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        TestDB test1 = (TestDB) obj;
        return (name == test1.name || (name != null && name.equals(test1.getName())))
                && (method_name == test1.method_name || (method_name != null && method_name.equals(test1.getMethod_name()))) &&
                (env == test1.env || (env != null && env.equals(test1.getEnv()))) &&
                (browser == test1.browser || (browser != null && browser.equals(test1.getBrowser())));
    }
}


