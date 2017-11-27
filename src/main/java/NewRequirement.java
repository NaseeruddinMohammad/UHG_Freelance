
//And the claims are sorted in descending order by Date of Service
//And claims exist with no Date of Service
//And claims with no Date of Service are sorted to the bottom of the results list
//And a hidden column ID: processTime exists
//And claims with the same Date of Service and Processed Date are sorted in descending order by Processed Time
//And the |Processed Date| column will be sortable
//And claims with the same Date of Service, including claims with no date of service, are sorted in descending order by Processed Date

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewRequirement {

    public static WebDriver driver;
    NewRequirement nr;
    public List<WebElement> serviceDateElements;
    public List<WebElement> processedDateElemnts;
    public List<WebElement> processedTimeElements;

    public ArrayList<String> serviceDateList;
    public ArrayList<String> processedDateList;
    public ArrayList<String> processedTimeList;

    public Date[] serviceDates;
    public Date[] noServiceDates;
    public Date[] processedDates;
    public Date[] processedTimes;

    public SimpleDateFormat formatter1;
    public SimpleDateFormat formatter2;
    public SimpleDateFormat formatter3;

    public String[] string1;
    public String[] string2;
    public String[] string3;

    @BeforeClass()
    public static void openDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/trainingip/IdeaProjects/DateSort/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("file:///Users/trainingip/Downloads/emptyColumn76.html");
        Thread.sleep(3000);
    }

    public NewRequirement(){
        serviceDateElements = driver.findElements(By.xpath("//*[@id=\"claimRow\"]/tbody/tr/td[8]"));
        processedDateElemnts = driver.findElements(By.xpath("//*[@id=\"claimRow\"]/tbody/tr/td[12]"));
        processedTimeElements = driver.findElements(By.xpath("//*[@id=\"claimRow\"]/tbody/tr/td[33]"));

        serviceDateList = returnArrayList(serviceDateElements);
        processedDateList = returnArrayList(processedDateElemnts);
        processedTimeList = returnArrayList(processedTimeElements);

        serviceDates = new Date[2];
        noServiceDates = new Date[2];
        processedDates = new Date[2];
        processedTimes = new Date[2];

        formatter1 = new SimpleDateFormat("MM/dd/yyyy - MM/dd/yyyy");
        formatter2 = new SimpleDateFormat("MM/dd/yyyy");
        formatter3 = new SimpleDateFormat("HH:mm:ss");

        string1 = getTexts(serviceDateList);
        string2 = getTexts(processedDateList);
        string3 = getTexts(processedTimeList);
    }
    @Test
    public void checkNoDateServiceSortedBottom() throws ParseException, InterruptedException {
        boolean isDecending = false;

        for (int i = 0; i < string1.length; i++) {
            serviceDates = returnDate(formatter1, string1);
            processedDates = returnDate(formatter2, string2);
            }

        if ((serviceDates[0].compareTo(serviceDates[1]) >= 0)){
            isDecending = true;
            System.out.println("Service Dates are in Descending Order...");
        }
    }

    @Test
    public void claimsWithTheSameDateOfServiceAndNoDateOfServiceSortedInDescendingOrderByProcessedDate() throws InterruptedException, ParseException {
        String currentServiceDate = "";
        String[] serviceDateText = new String[2];
        String[] processDateText = new String[2];
        String[] noServiceProcessedDateText = new String[2];

        for (int i = 0; i < serviceDateList.size(); i++) {
            if (i == 0) {
                currentServiceDate = serviceDateList.get(i).toString(); //Making the first value as currentServiceDate
            } else {
                if (currentServiceDate.equals(serviceDateList.get(i).toString())) {
                    System.out.println("CurrentServiceDate:: " + currentServiceDate + " ::: Next Service Date" + serviceDateList.get(i).toString());
                        System.out.println("processedDate:: " + processedDateList.get(i).toString() + " ::: Next Processed Date" + processedDateList.get(i - 1).toString());
                        for (int j = 1; j >= 0; j--) {
                            processDateText[1 - j] = processedDateList.get(i - j); // getting required processDateText
                        }
                        break;
                }
                currentServiceDate = serviceDateList.get(i).toString(); // Changing the next ServiceDate to currentServiceDate here...
            }
        }

        for (int i = 0; i < serviceDateList.size(); i++) {
            int index = 0;
            if (serviceDateList.get(i).isEmpty()) {
                System.out.println("EmptyServiceDate:: "+serviceDateList.get(i).toString()+"::NextEmptyServiceDate::"+serviceDateList.get(i+1).toString());
                index = i;
                for (int j = 0; j < 2; j++) {
                    noServiceProcessedDateText[j] = processedDateList.get(index).toString();
                    System.out.println("noServiceProcessedDate::" + noServiceProcessedDateText[j]);
                    index++;
                }
                break;
            }
        }

        Date[] formattedProcessedDate = returnDate(new SimpleDateFormat("MM/dd/yyyy"), processDateText); // formatting processedDate using SimpleDateFormat and store to formattedProcessedDate
        Date[] formattednoServiceProcessedDateText = returnDate(new SimpleDateFormat("MM/dd/yyyy"), noServiceProcessedDateText); // formatting processedDate using SimpleDateFormat and store to formattedProcessedDate

        System.out.println("claimsWithTheSameDateOfServiceAndNoDateOfServiceSortedInDescendingOrderByProcessedDate::"+(compareDate(formattedProcessedDate) && compareDate(formattednoServiceProcessedDateText)));
    }

    @Test
    public void checkRowsOfProcessDateAndTimeInDecendingOrder() throws InterruptedException, ParseException{
        String currentServiceDate = "";
        String[] serviceDateText = null;
        String[] processDateText = null;
        String[] noServiceProcessedDate = new String[2];

        for(int i=0;i<serviceDateList.size();i++) {
            int index = 0;
            if (serviceDateList.get(i).isEmpty()) {
                index = i;
                for (int j = 0; j < 2; j++) {
                    noServiceProcessedDate[j] = processedDateList.get(index).toString();
                    System.out.println("noServiceProcessedDate::" + noServiceProcessedDate[j]);
                    index++;
                }
                break;
            }
        }

        for (int i = 0; i < serviceDateList.size(); i++) {
            if (i == 0) {
                currentServiceDate = serviceDateList.get(i).toString(); //Making the first value as currentServiceDate
            }
            else {
                if (currentServiceDate.equals(serviceDateList.get(i).toString())) {
                        System.out.println("CurrentServiceDate:: "+ currentServiceDate +" ::: "+ serviceDateList.get(i).toString());

                    if (processedDateList.get(i).toString().equals(processedDateList.get(i - 1).toString())) {
                            System.out.println("CurrentServiceDate:: "+ currentServiceDate);
                        System.out.println("processedDate:: "+ processedDateList.get(i).toString()+" ::: "+processedDateList.get(i - 1).toString());

                        serviceDateText = getTexts(serviceDateList); // getting required serviceDateText

                        processDateText = getTexts(processedDateList); // getting required processDateText

                        break;
                    }
                }
                currentServiceDate = serviceDateList.get(i).toString(); // Changing the next ServiceDate to currentServiceDate here...
            }
        }


        Date[] formattedServiceDate = returnDate(new SimpleDateFormat("MM/dd/yyyy - MM/dd/yyyy"), serviceDateText); //formatting serviceDate using SimpleDateFormat and store to formattedServiceDate
        Date[] formattedProcessedDate = returnDate(new SimpleDateFormat("MM/dd/yyyy"), processDateText); // formatting processedDate using SimpleDateFormat and store to formattedProcessedDate
        Date[] formattednoServiceProcessedDateText = returnDate(new SimpleDateFormat("MM/dd/yyyy"), noServiceProcessedDate); // formatting processedDate using SimpleDateFormat and store to formattedProcessedDate

        System.out.println("formattednoServiceProcessedDateText ::"+formattednoServiceProcessedDateText[0]);
        for (int i = 0; i < 2; i++) {
            System.out.println("$$Date Formatted$$:" + formattedServiceDate[i].toString() + "::"
                    + formattedProcessedDate[i].toString() ); // Printing all formatted dates
        }

        System.out.println("checkRowsOfProcessDateAndTimeInDecendingOrder::"+ (compareDate(formattedProcessedDate)&&compareDate(formattedServiceDate)&&compareDate(formattednoServiceProcessedDateText)));
    }

    public static boolean compareDate(Date[] date) {
        return date[0].compareTo(date[1]) >= 0;
    }

    @Test
    public void noDateServiceExist1(){
        boolean isExist = false;
        for(WebElement we: serviceDateElements){
            if (we.getText().isEmpty()) {
                //And claims exist with no Date of Service
                isExist = true;
                System.out.println("No Service Date Exist");
                break;
            }
        }
        System.out.println("noDateServiceExist::"+isExist);
    }

    @Test
    public void noDateServiceExist(){
        boolean isExist = false;
        int count=0;
        int index=0;

        for(int i=0;i<serviceDateList.size();i++){
            if (serviceDateList.get(i).isEmpty()) {
                //isExist = true;
                index=i;
                System.out.println("No Service Date Exist " + i);
                for(int j=serviceDateList.size()-1;j>=index;j--) {
                    if (serviceDateList.get(j).isEmpty()) {
                        count++;
                    }
                }
                break;
            }
        }

        if(count==serviceDateList.size()-index){
            isExist = true;
            System.out.println("No Service Date sorted to botttom");
        }
        System.out.println("noDateServiceExist::"+isExist);
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

    public static ArrayList<String> returnArrayList(List<WebElement> list){
        ArrayList<String> arrayList = new ArrayList<String>();
        for(WebElement we: list){
                arrayList.add(we.getText());
        }
        return arrayList;
    }

    public static ArrayList<String> returnArrayListForNoServiceDate(List<WebElement> list){
        ArrayList<String> arrayList = new ArrayList<String>();
        for(WebElement we: list){
            if(!we.getText().isEmpty())
            arrayList.add(we.getText());
        }
        return arrayList;
    }

    @AfterClass
    public static void closeDriver(){
        driver.quit();
    }
}
