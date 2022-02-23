package org.testapp.Api.DataProvider.DataGenerator;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataGenerator {
    //Using GregorianCalendar to fetch the time details
    Calendar cal = new GregorianCalendar();
    //Month value is always 1 less than actual. For February, MONTH would return 1
    int month = cal.get(Calendar.MONTH);
    int year = cal.get(Calendar.YEAR);
    int sec = cal.get(Calendar.SECOND);
    int min = cal.get(Calendar.MINUTE);
    int date = cal.get(Calendar.DATE);
    int day = cal.get(Calendar.HOUR_OF_DAY);

    static DataGenerator dataGenerator;
    public static DataGenerator getDataGenerator(){
        return dataGenerator = new DataGenerator();
    }
    public String getRandomData(){
        return year + "_" + date+ "_" + (month + 1) + "_" + day + "_" + min + "_" + sec;
    }

}
