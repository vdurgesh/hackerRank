package com.hack.code30;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static Calendar getCalendar(String dateString) throws Exception {
        DateFormat df = new SimpleDateFormat("dd MM yyyy");
        Date parsed = df.parse(dateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(parsed);
        return calendar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String actualReturn = scanner.nextLine();
        String expectedReturn = scanner.nextLine();
        try {
            Calendar actualDate = getCalendar(actualReturn);
            Calendar expectedDate = getCalendar(expectedReturn);
            int fine = 0;
            if(actualDate.after(expectedDate)) {
                if (actualDate.get(Calendar.YEAR) > expectedDate.get(Calendar.YEAR)) {
                    fine = 10000;
                } else if (actualDate.get(Calendar.MONTH) > expectedDate.get(Calendar.MONTH)) {
                    fine = 500 * (actualDate.get(Calendar.MONTH) - expectedDate.get(Calendar.MONTH));
                } else if(actualDate.get(Calendar.DAY_OF_MONTH) > expectedDate.get(Calendar.DAY_OF_MONTH)) {
                    fine = 15 * (actualDate.get(Calendar.DAY_OF_MONTH) - expectedDate.get(Calendar.DAY_OF_MONTH));
                }
            }
            System.out.println(fine);
        } catch(Exception re) {
            return;
        }
    }
}
