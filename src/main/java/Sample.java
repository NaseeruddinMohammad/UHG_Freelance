import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample {

    public static void main(String[] arg) throws ParseException {

        Date[] date = new Date[2];
        String[] processedTimeParsed = new String[2];// created processedTimeParsed array for storing 3 processedTimes
        String[] processTimeText = {"17.39.00","17.40.00"};

        for (int i = 0; i < 2; i++) {
            processedTimeParsed[i] = processTimeText[i].toString().replace(".", ":"); //replacing all processedTimes them with ":"
            //System.out.println("processTimeText[i]$$$$"+ processTimeText[i].toString());
            System.out.println("processTimeText[i]$$$$"+ processedTimeParsed[i].toString());
        }

        Date[] formattedProcessedTime = returnDate(new SimpleDateFormat("HH:mm:ss"), processedTimeParsed); // formatting processedTime using SimpleDateFormat and store to formattedProcessedTime
        System.out.println("formattedProcessedTime:: "+formattedProcessedTime);
        System.out.println("Boolean :: "+compareTime(formattedProcessedTime));
    }

    public static boolean compareTime(Date[] time) {
        System.out.println(time[0]+"::"+time[1]);
        return time[1].after(time[0]);
    }


    public static Date[] returnDate(SimpleDateFormat formatter, String[] string) throws ParseException {
        Date[] date = new Date[2];
        for (int i=0;i<date.length;i++) {
            date[i] = (Date) formatter.parse(String.valueOf(string[i]));
        }
        return date;
    }

}
