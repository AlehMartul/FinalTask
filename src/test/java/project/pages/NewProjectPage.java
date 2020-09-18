package project.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class NewProjectPage extends BasePage {

    private static final String TEST_LIST = "//*[text()='%s']";
    private static final String TEST_NAME = "KS-707 adding info";
    private ILabel lblCreatedTest = AqualityServices.getElementFactory()
            .getLabel(By.xpath(String.format(TEST_LIST, TEST_NAME)), "Checking of existing new test");

    public NewProjectPage() {
        super(By.xpath("//*[text()='Home']"), "TestPage");
    }

    public boolean isTestAdded (){
        return lblCreatedTest.state().waitForDisplayed();
    }

    public void clickOnCreatedTestButton(){
        AqualityServices.getLogger().info("Clicking on new test link");
        lblCreatedTest.click();
    }

}
