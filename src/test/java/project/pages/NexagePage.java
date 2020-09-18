package project.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class NexagePage extends BasePage {

    private ILabel header = AqualityServices.getElementFactory()
            .getLabel(By.xpath("//*[@class='panel-heading']"), "header");
    private static final String XPATH_HOME_BUTTON = "//a[@href='/web/projects']";
    private IButton btnHome= AqualityServices.getElementFactory()
            .getButton(By.xpath(XPATH_HOME_BUTTON), "Push Home button");

    public NexagePage() {
        super(By.xpath("//a[@href='/web/projects']"), "MainPage");
    }

    public void clickOnHomeButton() {
        AqualityServices.getLogger().info("Clicking on Save project");
        btnHome.click();
    }

    @Override
    public boolean isPageLoaded() {
        return header.state().waitForDisplayed();
    }

}
