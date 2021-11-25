package pages;

import com.lowes.framework.base.BasePage;
import model.userlogin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "company")
    public WebElement txtCompanyId;

    @FindBy(how = How.ID, using = "login")
    public WebElement txtUserId;

    @FindBy(how = How.ID, using = "passwd")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "retbutton")
    public WebElement btnSignIn;

    public void login(String companyId, String userId, String password) throws InterruptedException {
        txtCompanyId.sendKeys(companyId);
        txtUserId.sendKeys(userId);
        txtPassword.sendKeys(password);
    }

    public void login(userlogin userlogin) throws InterruptedException {
        txtCompanyId.sendKeys(userlogin.companyId);
        txtUserId.sendKeys(userlogin.userId);
        txtPassword.sendKeys(userlogin.password);
    }

    public HomePage clickSignIn() {
        btnSignIn.click();
        return GetInstance(HomePage.class);
    }

}