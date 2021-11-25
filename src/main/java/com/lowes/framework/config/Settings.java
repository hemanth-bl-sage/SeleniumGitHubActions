package com.lowes.framework.config;

import com.lowes.framework.base.BrowserType;
import com.lowes.framework.utilities.LogUtil;

import java.sql.Connection;

/** Created by Hemanth BL **/
public class Settings {
    //For Application Backend
    public static Connection AUTConnection;
    //For Lowes Reporting
    public static Connection ReportingConnection;
    //For Application backend connection string
    public static String AUTConnectionString;
    public static String ReportingConnectionString;
    //Log Path for framework
    public static String LogPath;
    //Driver Type for SQL Server connectivity
    public static String DriverType;
    //Excel Path for framework
    public static String ExcelSheetPath;
    //Application under test url
    public static String AUT;
    public static BrowserType BrowserType;
    public static LogUtil Logs;
    public static String FeatureContext;
    public static String ScenarioContext;
    public static String SeleniumGridHub;
    public static String Execution;
    //Historical report capture
    public static String HistoricalReport;
}
