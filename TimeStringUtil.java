package com.test.dafy.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TimeStringUtil {

	private String valueOfString(String str, int len) {
		String string = "";
		for (int i = 0; i < len - str.length(); i++) {
			string = string + "0";
		}
		return (str.length() == len) ? (str) : (string + str);
	}
	/**
	 * 返回当前时间，格式为：2014-12-18 15:11:50
	 * @return
	 */
	public String getSimpleDateFormat(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date()); 		 
	}

	/**
	 * 返回当前时间，格式为：2014-12-18
	 * @return
	 */
	public String getSimpleDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}

	/**
	 * 返回当前时间戳
	 * @return
	 */
	public String getTime(){
		return String.valueOf(new Date().getTime());
	}
	
	/**
	 * 生成一个长度为17的时间字符串，精确到毫秒
	 * @return
	 */
	public String getTimeString() {
		Calendar calendar = new GregorianCalendar();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = this.valueOfString(String.valueOf(calendar.get(Calendar.MONTH) + 1),2);	
		String day = this.valueOfString(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)),2);
		String hour = this.valueOfString(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)),2);
		String minute = this.valueOfString(String.valueOf(calendar.get(Calendar.MINUTE)),2);
		String second = this.valueOfString(String.valueOf(calendar.get(Calendar.SECOND)),2);
		String millisecond = this.valueOfString(String.valueOf(calendar.get(Calendar.MILLISECOND)),3);
		return year+month+day+hour+minute+second+millisecond;
	}

    /**
     * 得到二个日期间的间隔天数
     * @param endTime  结束时间
     * @param startTime 开始时间
     * @return
     */
    public static String getTwoDay(Date endTime, Date startTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        LogUtil.logInfo( "startTime="+format.format(startTime)+ " endTime="+format.format(endTime) );
        long day = 0;
        try {
            day = (endTime.getTime() - startTime.getTime()) / (24 * 60 * 60 * 1000)+1;
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }


	/**
	 * 当前日期加上天数后的日期
	 * @param num 为增加的天数
	 * @return
	 */
	public String plusDay(int num){
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currdate = format.format(d);
		LogUtil.logInfo("现在的日期是：" + currdate);

		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
		d = ca.getTime();
		String enddate = format.format(d);
		LogUtil.logInfo("增加天数以后的日期：" + enddate);
		return enddate;
	}

//    public int countTwoDate()   {
//        LocalDate today = LocalDate.now();
//        int year = today.getYear();
//        int month = today.getMonthValue();
//        int day = today.getDayOfMonth();
//        LogUtil.logInfo("当前的年 : %d  月 : %d  日 : %d%n", year, month, day);
//        return month;
//	}


    public static void main(String[] args) {
		TimeStringUtil ts = new TimeStringUtil();
		LogUtil.logInfo(ts.getTime());
		LogUtil.logInfo(ts.getSimpleDateFormat());
        LogUtil.logInfo(ts.getSimpleDate());
		LogUtil.logInfo(ts.getTimeString());

        LogUtil.logInfo(ts.plusDay(89));
//        LogUtil.logInfo(ts.getTwoDay(8,18));

	}
}
