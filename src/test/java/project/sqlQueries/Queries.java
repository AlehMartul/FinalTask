package project.sqlQueries;

import utils.MySQLUtil;

import java.sql.SQLException;

public class Queries {

        private static final String QUERY = "INSERT INTO union_reporting.test (id, name, status_id, method_name," +
                " project_id, session_id, start_time, end_time, env, browser) values('%s', '%s', '%s', '%s', '%s', '%s'," +
                " '%s', '%s', '%s', '%s')";
    private static final String QUERY1 = "INSERT INTO union_reporting.test (id, name, status_id, method_name, project_id," +
            " session_id, start_time, end_time, env, browser, author_id) values('401', 'KS-707 adding info', '1'," +
            " 'com.hellsbells.tests.test', '7', '12', '2016-10-12 18:56:58', '2016-10-12 18:56:58', 'GRIGORYEVS', 'chrome', null)";

        public static void addTest(String id, String name, String status_id, String method_name, String project_id,
                                   String session_id, String start_time, String end_time, String env, String browser)
                throws SQLException {
            MySQLUtil.makeQuery(String.format(QUERY, id, name, status_id, method_name,
                project_id, session_id, start_time, end_time, env, browser));
        }
    }
