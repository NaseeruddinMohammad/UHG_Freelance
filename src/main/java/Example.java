import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Example {

     public static void main(String[] args) throws ParseException, InterruptedException {

         WebDriver driver = new ChromeDriver();
         Thread.sleep(6000);
         boolean isDecending = false;

         List<WebElement> serviceDateElements = driver.findElements(By.xpath("//table/tbody/tr/td[8]"));
         List<WebElement> processedDateElemnts = driver.findElements(By.xpath("//table/tbody/tr/td[12]"));
         List<WebElement> processedTimeElements = driver.findElements(By.xpath("//table/tbody/tr/td[33]"));

         ArrayList<String> serviceDateList = returnArrayList(serviceDateElements, "visible");
         ArrayList<String> processedDateList = returnArrayList(processedDateElemnts, "visible");
         ArrayList<String> processedTimeList = returnArrayList(processedTimeElements, "hidden");

         String[] string1 = returnStrings(serviceDateList);
         String[] string2 = returnStrings(processedDateList);
         String[] string3 = returnStrings(processedTimeList);

         SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy - MM/dd/yyyy");
         SimpleDateFormat formatter2 = new SimpleDateFormat("MM/dd/yyyy");
         SimpleDateFormat formatter3 = new SimpleDateFormat("HH:mm:ss");

         Date[] serviceDates = new Date[2];
         Date[] processedDates = new Date[2];
         Date[] processedTimes = new Date[2];
         for (int i = 0; i < string1.length; i++) {
             serviceDates = returnDate(formatter1, string1[i].toString());
             processedDates = returnDate(formatter2, string2[i].toString());
             processedTimes = returnDate(formatter3, string3[i].toString().replace(".", ":"));
         }

         if ((serviceDates[0].compareTo(serviceDates[1]) >= 0) && (processedDates[0].compareTo(processedDates[1]) >= 0) &&
                 (processedTimes[0].before(processedTimes[1]))) {
             isDecending = true;
         }
         System.out.println("$$$$$$$$$$$$$$$$$$"+serviceDates[0]+"::"+processedDates[0]+"::"+processedTimes[0]);
         System.out.println("$$$$$$$$$$$$$$$$$$"+serviceDates[1]+"::"+processedDates[1]+"::"+processedTimes[1]);
     }

    public static ArrayList<String> returnArrayList(List<WebElement> list, String type){
        ArrayList<String> arrayList = new ArrayList<String>();
         for(WebElement we: list){
             if(type.equals("hidden")){
                 arrayList.add(we.getAttribute("innerHTML"));
             }
             else{
                 arrayList.add(we.getText());
             }
        }
        return arrayList;
    }

    public static Date[] returnDate(SimpleDateFormat formatter, String string) throws ParseException {
        Date[] date = new Date[2];
        for (int i=0;i<date.length;i++) {
            date[i] = (Date) formatter.parse(String.valueOf(string));
        }
        return date;
    }


    public static String[] returnStrings(ArrayList list){
        String[] string = new String[2];
        for(int i=0;i<string.length;i++){
            string[i] = list.get(i+1).toString();
        }
        return string;
    }
}


