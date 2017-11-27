import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSort {
    public static void main(String [] arr) throws InterruptedException, ParseException {

        String firstTime = "07.19.12";
        String secondTime = "07.12.12";

        String s = firstTime.replace(".",":");
        String s1 = secondTime.replace(".",":");

        System.out.println(firstTime);
        System.out.println(secondTime);
        System.out.println(s);
        System.out.println(s1);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

       Date time1 = (Date)sdf.parse(s);
        Date time2 = (Date)sdf.parse(s1);

        if(time1.getTime()>time2.getTime()){
            System.out.println("Yes");
        }
        else{
            System.out.println("Yes");
        }
    }
}
