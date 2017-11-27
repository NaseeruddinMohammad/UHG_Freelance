//And multiple claims exist with the same Processed Date
//And claims with the same processed date are sorted in ascending order by processed time
//#And claims with Status: Keyed and blank processed date are sorted above claims with a processed date value
//#And I click the Processed Date column header again
//And claims with the same processed date are sorted in descending order
//And claims with the same processed date are sorted in descending order by processed time

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ClaimsTable {

    WebDriver driver;

    @Test
    public void commonMethod() throws ParseException, InterruptedException {

        boolean isDecending = false;
        System.setProperty("webdriver.chrome.driver", "/Users/trainingip/IdeaProjects/DateSort/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("file:///Users/trainingip/Downloads/ClaimsServiceDateClick3rdscneario.html");
        Thread.sleep(3000);

        List<WebElement> processedDateElements = driver.findElements(By.xpath("//*[@id=\"claimRow\"]/tbody/tr/td[12]"));
        List<WebElement> processedTimeElements = driver.findElements(By.xpath("//*[@id=\"claimRow\"]/tbody/tr/td[33]"));

        ArrayList<String> processedDateList = returnArrayList(processedDateElements);
        ArrayList<String> processedTimeList = getHiddenTextFromList(processedTimeElements);

        SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");

        Date[] processedDates = new Date[2];
        Date[] processedTimes = new Date[2];

        String[] string1 = getTexts(processedDateList);
        String[] string2 = getTexts(processedTimeList);

        System.out.println("processedTimeList$$$$$"+processedTimeList);

        System.out.println("multipleClaimsWithSameProcessedDate::"+ multipleClaimsWithSameProcessedDate(processedDateElements));
        System.out.println("claimsWithSameProcessedDateSortedInAscendingOrderByProcessedTime:: "+
                claimsWithSameProcessedDateSortedInAscendingOrderByProcessedTime(processedDateList,processedTimeList));
        System.out.println("claimsWithSameProcessedDateSortedInDescendingOrderByProcessedTime:: "+
        claimsWithSameProcessedDateSortedInDescendingOrderByProcessedTime(processedDateList,processedTimeList));
    }

    public boolean claimsWithSameDateOfServiceSortedInDescendingOrderByProcessedDate() throws ParseException {

        boolean isDecending = false;

        String currentServiceDate = "";
        String[] serviceDateText = null;
        String[] processDateText = null;
        List<WebElement> serviceDateElements = driver.findElements(By.xpath("//table/tbody/tr/td[8]"));
        List<WebElement> processedDateElemnts = driver.findElements(By.xpath("//table/tbody/tr/td[12]"));
        ArrayList<String> serviceDateList = returnArrayList(serviceDateElements);
        ArrayList<String> processedDateList = returnArrayList(processedDateElemnts);

        for (int i = 0; i < serviceDateList.size(); i++) {
            if (i == 0) {
                currentServiceDate = serviceDateList.get(i).toString(); //Making the first value as currentServiceDate
            }
            else {
                if (currentServiceDate.equals(serviceDateList.get(i).toString())) {
                    System.out.println("CurrentServiceDate:: "+ currentServiceDate +" ::: "+ serviceDateList.get(i).toString());
                        System.out.println("processedDate:: "+ processedDateList.get(i).toString()+" ::: "+processedDateList.get(i - 1).toString());
                        serviceDateText = getTexts(serviceDateList); // getting required serviceDateText
                        processDateText = getTexts(processedDateList); // getting required processDateText
                        break;
                }
                currentServiceDate = serviceDateList.get(i).toString(); // Changing the next ServiceDate to currentServiceDate here...
            }
        }

        Date[] formattedServiceDate = returnDate(new SimpleDateFormat("MM/dd/yyyy - MM/dd/yyyy"), serviceDateText);
        Date[] formattedProcessedDate = returnDate(new SimpleDateFormat("MM/dd/yyyy"), processDateText);

        if ((formattedServiceDate[0].compareTo(formattedServiceDate[1]) >= 0) && (formattedProcessedDate[0].compareTo(formattedProcessedDate[1]) >= 0)) {
            isDecending = true;
        }
        return isDecending;
    }

    public static boolean multipleClaimsWithSameProcessedDate(List<WebElement> processedDateElements) {
        boolean isExist = false;
        for(int i=0;i<processedDateElements.size();i++){
            for(int j=i+1;j<processedDateElements.size();j++){
                if(processedDateElements.get(j).toString().equals(processedDateElements.get(i).toString())) {
                    System.out.println("Multiple Claims with same processed date exist....!!!");
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    public boolean claimsWithSameProcessedDateSortedInDescendingOrderByProcessedTime(ArrayList<String> processedDateList, ArrayList<String> processedTimeList) throws ParseException {
        String currentProcessedDate = "";
        String[] processDateText = new String[2];
        String[] processTimeText = new String[2];

        for (int i = 0; i < processedDateList.size(); i++) {
            if (i == 0) {
                currentProcessedDate = processedDateList.get(i); //Making the first value as currentServiceDate
            }
            else {
                if (currentProcessedDate.equals(processedDateList.get(i))) {
                    System.out.println("CurrentProcessDate:: "+ currentProcessedDate +" ::: "+ processedDateList.get(i));
                    for(int j=1;j>=0;j--) {
                        processDateText[1-j] = processedDateList.get(i-j); // getting required processDateText
                        processTimeText[1-j] = processedTimeList.get(i-j);
                    }
                    break;
                }
                currentProcessedDate = processedDateList.get(i).toString(); // Changing the next ServiceDate to currentServiceDate here...
            }
        }

        String[] processedTimeParsed = new String[2]; // created processedTimeParsed array for storing 3 processedTimes

        for (int i = 0; i < 2; i++) {
            processedTimeParsed[i] = processTimeText[i].toString().replace(".", ":"); //replacing all processedTimes them with ":"
            System.out.println("processTimeText[i]$$$$"+processTimeText[i].toString());
        }

        System.out.println(processedTimeParsed[0]+"$$$$"+processedTimeParsed[1]);
        Date[] formattedProcessedDate = returnDate(new SimpleDateFormat("MM/dd/yyyy"), processDateText); // formatting processedDate using SimpleDateFormat and store to formattedProcessedDate
        Date[] formattedProcessedTime = returnDate(new SimpleDateFormat("HH:mm:ss"), processedTimeParsed); // formatting processedTime using SimpleDateFormat and store to formattedProcessedTime

        System.out.println("formattedProcessedTime::" +formattedProcessedTime);
        //return compareDate(formattedProcessedDate)&&compareTime(formattedProcessedTime);
        boolean b1 = compareDate(formattedProcessedDate);
        boolean b2 = compareTimeAscending(formattedProcessedTime);
        return b1&&b2;
    }

    public boolean claimsWithSameProcessedDateSortedInAscendingOrderByProcessedTime(ArrayList<String> processedDateList, ArrayList<String> processedTimeList) throws ParseException {
        String currentProcessedDate = "";
        String[] processDateText = new String[2];
        String[] processTimeText = new String[2];

        Collections.reverse(processedDateList);
        Collections.reverse(processedTimeList);

        for (int i = 0; i < processedDateList.size(); i++) {
            if (i == 0) {
                currentProcessedDate = processedDateList.get(i); //Making the first value as currentServiceDate
            }
            else {
                if (currentProcessedDate.equals(processedDateList.get(i))) {
                    System.out.println("CurrentProcessDate:: "+ currentProcessedDate +" ::: "+ processedDateList.get(i));
                    for(int j=1;j>=0;j--) {
                        processDateText[1-j] = processedDateList.get(i-j); // getting required processDateText
                        processTimeText[1-j] = processedTimeList.get(i-j);
                    }
                    break;
                }
                currentProcessedDate = processedDateList.get(i).toString(); // Changing the next ServiceDate to currentServiceDate here...
            }
        }

        String[] processedTimeParsed = new String[2]; // created processedTimeParsed array for storing 3 processedTimes

        for (int i = 0; i < 2; i++) {
            processedTimeParsed[i] = processTimeText[i].toString().replace(".", ":"); //replacing all processedTimes them with ":"
            System.out.println("processTimeText[i]$$$$"+processTimeText[i].toString());
        }

        System.out.println(processedTimeParsed[0]+"$$$$"+processedTimeParsed[1]);
        Date[] formattedProcessedDate = returnDate(new SimpleDateFormat("MM/dd/yyyy"), processDateText); // formatting processedDate using SimpleDateFormat and store to formattedProcessedDate
        Date[] formattedProcessedTime = returnDate(new SimpleDateFormat("HH:mm:ss"), processedTimeParsed); // formatting processedTime using SimpleDateFormat and store to formattedProcessedTime

        System.out.println("formattedProcessedTime::" +formattedProcessedTime);
        //return compareDate(formattedProcessedDate)&&compareTime(formattedProcessedTime);
        boolean b1 = compareDate(formattedProcessedDate);
        boolean b2 = compareTimeAscending(formattedProcessedTime);
        return b1&&b2;
    }

    public static boolean compareDate(Date[] date) {
        return date[0].compareTo(date[1]) >= 0;
    }

    public static boolean compareTimeAscending(Date[] time) {
        return time[0].before(time[1]);
    }

    public static ArrayList<String> returnArrayList(List<WebElement> list){
        ArrayList<String> arrayList = new ArrayList<String>();
        for(WebElement we: list){
            arrayList.add(we.getText());
        }
        return arrayList;
    }

    public static String[] getTexts(ArrayList<String> list) {
        String[] text = new String[2];
        for (int i = 0; i < text.length; i++) {
            text[i] = list.get(i + 1).toString();
        }
        return text;
    }

    public static Date[] returnDate(SimpleDateFormat formatter, String[] string) throws ParseException {
        Date[] date = new Date[2];
        for (int i=0;i<date.length;i++) {
            date[i] = (Date) formatter.parse(String.valueOf(string[i]));
        }
        return date;
    }

    public static ArrayList<String> getHiddenTextFromList(List<WebElement> list) {
        ArrayList<String> text = new ArrayList<String>();
        for (WebElement we : list) {
            text.add(we.getAttribute("innerHTML"));
        }
        return text;
    }
}