package com.example.parkingapp.util;

import android.text.format.DateFormat;


import java.util.Calendar;
import java.util.Date;


public class CalendarParking {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public Date getDateToday (){
        return  Calendar.getInstance().getTime();
    }

    public static String formatDateTimeFromDate(String mDateFormat, Date date) {
        if (date == null) {
            return null;
        }
        return DateFormat.format(mDateFormat, date).toString();
    }


}
