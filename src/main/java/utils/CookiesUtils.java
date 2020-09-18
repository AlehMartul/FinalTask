package utils;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.Cookie;

public class CookiesUtils {

    public static void setCookie(Cookie cookie) {
        AqualityServices.getBrowser().getDriver().manage().addCookie(cookie);
    }
}