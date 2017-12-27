package com.test.dafy.utils;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class LogUtil {
	private static Logger logger;

    private static String filePath = "src/log4j.properties";

//    private static boolean flag = false;

//    private static synchronized void getPropertyFile() {
//        logger = Logger.getLogger("TestProject");
//        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
//        flag = true;
//    }
//
//    private static void getFlag() {
//        if (flag == false)
//            LogUtil.getPropertyFile();
//    }
    
    static{
    	 logger = Logger.getLogger("DafyUIAutomation");
         //PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
    }

    public static void logInfo(Object message) {
//        LogUtil.getFlag();
        logger.info(message);
        Reporter.log(new TimeStringUtil().getSimpleDateFormat()+" : "+message);
    }

    public static void logError(Object message) {
//        LogUtil.getFlag();
        logger.error(message);
        Reporter.log(new TimeStringUtil().getSimpleDateFormat()+" : "+message);
    }

    public static void logWarn(Object message) {
//        LogUtil.getFlag();
        logger.warn(message);
        Reporter.log(new TimeStringUtil().getSimpleDateFormat()+" : "+message);
    }
}
