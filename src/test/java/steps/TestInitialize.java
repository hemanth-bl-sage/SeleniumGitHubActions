package steps;

import com.lowes.framework.base.DriverContext;

import com.lowes.framework.base.FrameworkInitialize;
import com.lowes.framework.base.LocalDriverContext;
import com.lowes.framework.config.ConfigReader;
import com.lowes.framework.config.Settings;
import com.lowes.framework.utilities.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;

/** Created by Hemanth BL **/
public class TestInitialize extends FrameworkInitialize {

    @Before
    public void Initialize(Scenario scenario) throws IOException, ClassNotFoundException {
        //Insert Scenario name
        try {
            ExtentReport.startScenario(scenario.getName());
        }catch (Exception e){
            System.out.println(e);
        }

        //Initialize Config
        ConfigReader.PopulateSettings();

        //Logging
        Settings.Logs = new LogUtil();
        Settings.Logs.CreateLogFile();
        Settings.Logs.Write("Framework Initialize");

        //Create Test Cycle for Reporting
        Settings.ReportingConnection = DatabaseUtil.Open(Settings.ReportingConnectionString);
        ReportingUtil.CreateTestCycle(Settings.ReportingConnection);

        Settings.Logs.Write("Test Cycle Created");
        InitializeBrowser(Settings.BrowserType);
        Settings.Logs.Write("Browser Initialized");
        DriverContext.GoToUrl(Settings.AUT);
        Settings.Logs.Write("Navigated to URL " + Settings.AUT);

        try {
            ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);
        } catch (Exception e) {
        }

    }

    @After
    public void tearDown(){
        LocalDriverContext.getWebDriver().close();
    }
}
