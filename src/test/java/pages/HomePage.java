package pages;

import com.lowes.framework.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[text()='Applications']")
    public WebElement homePage;

    @FindBy(how = How.ID, using = "retbutton")
    public WebElement btnSignIn;

    public LoginPage clickonSignIn() {
        return GetInstance(LoginPage.class);
    }

    public Boolean IsLogin() {
        return btnSignIn.isDisplayed();
    }

    public String GetLoggedInUser() {
        return homePage.getText();
    }

}