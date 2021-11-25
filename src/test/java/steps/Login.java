package steps;

import com.aventstack.extentreports.GherkinKeyword;
import com.lowes.framework.base.Base;
import com.lowes.framework.base.DriverContext;
import com.lowes.framework.utilities.ExtentReport;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import model.userlogin;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class Login extends Base {

    @DataTableType
    public userlogin convertlogin(Map<String, String> entry){
        return userlogin.userLogin(entry);
    }

    @And("^I see application is launched$")
    public void iSeeApplicationIsLaunched() throws ClassNotFoundException {
        CurrentPage = GetInstance(HomePage.class);
        Assert.assertTrue("The Login page is not loaded", CurrentPage.As(HomePage.class).IsLogin());
        ExtentReport.getScenario().createNode(new GherkinKeyword("And"),"Application is successfully launched");
    }

    @Then("^I click on Login link$")
    public void iClickOnLoginLink() throws ClassNotFoundException, InterruptedException {
        CurrentPage = CurrentPage.As(HomePage.class).clickonSignIn();
        DriverContext.WaitForPageToLoad();
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"),"I click on Login link");
    }

    @When("I enter companyId, userId and password")
    public void iEnterCompanyIdUserIdAndPassword(List<userlogin> data) throws ClassNotFoundException, InterruptedException{
        CurrentPage.As(LoginPage.class).login(data.stream().findFirst().get());
        ExtentReport.getScenario().createNode(new GherkinKeyword("when"),"I enter username and password");
    }

    @Then("^I click on sign in$")
    public void iClickOnSignIn() throws ClassNotFoundException, InterruptedException {
        Thread.sleep(2000);
        CurrentPage = CurrentPage.As(LoginPage.class).clickSignIn();
        DriverContext.WaitForPageToLoad();
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"),"I click on sign in");
    }

    @Then("^I should be successfully logged into Homepage$")
    public void iShouldBeSuccessfullyLoggedIntoHomepage() throws ClassNotFoundException {
        Assert.assertEquals("The user is not admin", CurrentPage.As(HomePage.class).GetLoggedInUser(), ("Applications"));
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"),"I should be successfully logged into Homepage");
    }

}