package com.example.demo.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Date strToDate(String s) {
        Date date = null;

        try {
            // yyyy-MM-ddで解釈できた場合

            long ms = sdf.parse(s).getTime();
            date = new Date(ms);

        } catch (ParseException e) {
            // 変換できなかった場合

            // date は null のまま
            e.printStackTrace();
        }

        return date;
    }
}
