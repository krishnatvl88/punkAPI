package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class DateHelper {

    public static List<Date> getDateList(List<String> dateStringList) {
         //dateStringList = new ArrayList<String>();
        List<Date> dates = new ArrayList<>(dateStringList.size()); // ArrayList of dates
        for(String s : dateStringList)
        {
            try
            {
                Date dateObj = new SimpleDateFormat("MM/yyyy").parse(s);

                dates.add(dateObj);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        for(Date d : dates)
        {
            String str = new SimpleDateFormat("MM/yyyy").format(d);
        }
        return dates;
    }

}
