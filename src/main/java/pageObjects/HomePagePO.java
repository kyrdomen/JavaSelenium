package pageObjects;

import common.Commands;
import org.openqa.selenium.By;

public class HomePagePO extends Commands {
    // Locators
    private By acceptTermsButton = By.cssSelector("button[data-testid='cookieBanner-confirmButton']");

    /**
     * Accept Terms
     */
    public HomePagePO clickAcceptTermsButton(){
        waitForElement(acceptTermsButton);
        press(acceptTermsButton);
        return this;
    }

}
