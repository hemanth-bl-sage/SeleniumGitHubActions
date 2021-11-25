package com.lowes.framework.utilities;

import java.sql.Connection;
import java.util.Hashtable;

/** Created by Hemanth BL **/
public class ReportingUtil {

    public static void CreateTestCycle(Connection connection) {

        //Params
        Hashtable table = new Hashtable();
        table.put("AUT", "Lowes for Pros");
        table.put("ExecutedBy", "JJ");
        table.put("RequestedBy", "Release Team");
        table.put("BuildNo", "1.0");
        table.put("ApplicationVersion", "1.0");
        table.put("MachineName", "Windows 10");
        table.put("TestType", 1);

//        DatabaseUtil.ExecuteStoredProc("sp_CreateTestCycleID", table, connection);

    }

}