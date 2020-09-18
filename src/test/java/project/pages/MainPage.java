package project.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import utils.ReadPropertyUtil;

public class MainPage extends BasePage {

    private static final String RESOURCES_PATH = "src/main/resources/";
    private static final String API_PROPERTIES = "api.properties";
    private IButton link = AqualityServices.getElementFactory()
            .getButton(By.xpath("//a[@href='/web/projects']"), "link");
    private static final String PROJECT_LINKS = "//*[text()='%s']";
    private static final String PROJECT_NAME = new ReadPropertyUtil(MainPage.RESOURCES_PATH, MainPage.API_PROPERTIES)
            .getProperty("project");
    private static final String NEW_PROJECT_LINK =String.format(PROJECT_LINKS, PROJECT_NAME);
    private IButton btnOfNewProject = AqualityServices.getElementFactory()
            .getButton(By.xpath(NEW_PROJECT_LINK), "");
    private static final String XPATH_NEXAGE_PROJECT = "//*[text()='Nexage']";
    private static final String XPATH_ADD_BUTTON = "//button[@data-toggle='modal']";
    private IButton btnAdd = AqualityServices.getElementFactory()
            .getButton(By.xpath(XPATH_ADD_BUTTON), "Push Add button");
    private static final String XPATH_SAVE_PROJECT_BUTTON = "//button[@type='submit']";
    private IButton btnSaveProject = AqualityServices.getElementFactory()
            .getButton(By.xpath(XPATH_SAVE_PROJECT_BUTTON), "Push Save Project button");
    private IButton btnNexageProject = AqualityServices.getElementFactory()
            .getButton(By.xpath(XPATH_NEXAGE_PROJECT), "Go to Nexage project page");
    private static final String XPATH_FOOTER_VARIANT = "//*[text()='Version: %s']";
    private static final String N_OF_VARIANT = "1";
    private ILabel lblFooter = AqualityServices.getElementFactory()
            .getLabel(By.xpath(String.format(XPATH_FOOTER_VARIANT, N_OF_VARIANT)), "Checking N of variant in footer");
    private final ITextBox txtMainField = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[@type='text']"), "texBox");


    public MainPage() {
        super(By.xpath("//a[@href='/web/projects']"), "MainPage");
    }


    public void clickOnNexageProjectButton() {
        AqualityServices.getLogger().info("Clicking on 'Nexage'");
        btnNexageProject.click();
    }

    public void clickOnCreatedProjectButton() {
        AqualityServices.getLogger().info("Clicking on 'Nexage'");
        btnOfNewProject.click();
    }

    public void clickOnAddButton() {
        AqualityServices.getLogger().info("Clicking on Add'");
        btnAdd.click();
    }

    public boolean isProjectAdded (){
        return btnOfNewProject.state().waitForDisplayed();
    }

    public void sendText(String text) {
        txtMainField.sendKeys(text);
    }

    public void clickOnSaveProjectButton() {
        AqualityServices.getLogger().info("Clicking on Save project");
        btnSaveProject.click();
    }

    public boolean isVariantSelected() {
        AqualityServices.getLogger().info("Checking N of variant in footer");
        return lblFooter.state().waitForDisplayed();
    }

    @Override
    public boolean isPageLoaded() {
        return link.state().waitForDisplayed();
    }

}
