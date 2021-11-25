package com.lowes.framework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Platform;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent = new ExtentReports();
    private static Platform platform;
    private static String reportFileName = "AutomationExtentReport.html";
    private static String macPath = System.getProperty("user.dir")+"/TestReport";
    private static String windowsPath = System.getProperty("user.dir")+"\\TestReport";
    private static String macReportFileLoc = macPath+"/"+reportFileName;
    private static String winReportFileLoc = windowsPath+"\\"+reportFileName;
    private static ExtentKlovReporter klovReporter = new ExtentKlovReporter("Automation", "build: 11.34");

    public static ExtentReports createInstance(){
        platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
//        ExtentHtmlReporter reporter = new ExtentHtmlReporter(fileName);
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
//        ExtentHtmlReporterConfiguration extentHtmlReporterConfiguration = new ExtentHtmlReporterConfiguration(reporter);
//        extentHtmlReporterConfiguration.setTheme(Theme.DARK);
//        extentHtmlReporterConfiguration.setDocumentTitle(fileName);
//        extentHtmlReporterConfiguration.setEncoding("utf-8");
//        extentHtmlReporterConfiguration.setReportName(fileName);
        ExtentSparkReporterConfiguration extentSparkReporterConfiguration = new ExtentSparkReporterConfiguration(extentSparkReporter);
        extentSparkReporterConfiguration.setTheme(Theme.DARK);
        extentSparkReporterConfiguration.setDocumentTitle(fileName);
        extentSparkReporterConfiguration.setEncoding("utf-8");
        extentSparkReporterConfiguration.setReportName(fileName);
        extent.attachReporter(extentSparkReporter);

//        //attach Klov reporter only if its historical flag true
//        if(Settings.HistoricalReport.equalsIgnoreCase("Y")) {
//            //Initialize Klov reporter
//            klovReporter = initKlovReporter();
//            extent.attachReporter(extentSparkReporter, klovReporter);
//        }else{
//            extent.attachReporter(extentSparkReporter);
//        }
        return extent;
    }

    //Select the extent report file location based on platform
    private static String getReportFileLocation(Platform platform){
        String reportFileLocation = null;
        switch (platform){
            case MAC:
                reportFileLocation = macReportFileLoc;
                createReportPath(macPath);
                System.out.println("ExtentReport Path for Mac :"+ macPath +"\n");
                break;
            case WINDOWS:
                reportFileLocation = winReportFileLoc;
                createReportPath(windowsPath);
                System.out.println("ExtentReport Path for WINDOWS :"+ windowsPath +"\n");
                break;
            default:
                System.out.println("ExtentReport Path has not been set! There is a problem!\n");
                break;
        }
        return reportFileLocation;
    }

    //Create the report path if it does not exist
    private static void createReportPath(String path){
        File testDirectory = new File(path);
        if(!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory :" + path + " is created!");
            } else {
                System.out.println("Failed to create Directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

    //Get Current platform
    private static Platform getCurrentPlatform(){
        if (platform==null){
            String operSys = System.getProperty("os.name").toLowerCase();
            if(operSys.contains("win")){
                platform = Platform.WINDOWS;
            }else if(operSys.contains("mac")){
                platform = Platform.MAC;
            }
        }
        return platform;
    }

    private static ExtentKlovReporter initKlovReporter() {
        //ToDo: These settings will be taken into consideration in settings, once we start using it in full fledged
        klovReporter.initMongoDbConnection("localhost", 27017);
        klovReporter.setProjectName("Test");
        klovReporter.setReportName("1.0");
        //ToDo: These settings will be taken into consideration in settings, once we start using it in full fledged
        klovReporter.initKlovServerConnection("http://localhost");
        return klovReporter;
    }

//    public static void ExtentReportsScreenshot(WebDriver driver){
//        var src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        Screendef.fail("details").addScreenCaptureFromPath(reportFileName+"failure.png");
//    }
}
