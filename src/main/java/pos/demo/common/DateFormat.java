package pos.demo.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static String getTimeNow(){
        Date date = new Date() ;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date) ;
    }
}
