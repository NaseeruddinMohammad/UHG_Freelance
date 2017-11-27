import java.text.ParseException;
import java.util.ArrayList;

public class Sample4 {

    public boolean processedTimeColumnIsDescendingForSameServiceDatesInClaimsTab() throws InterruptedException, ParseException{
        Thread.sleep(3000);
        boolean isDescending = false;
        int arr[] = {8,12,33};

        ArrayList<String> obtainedList = new ArrayList<String>();
        List<WebElement> elementList= driver.findElements(By.xpath("//*[@id='claimRow']/tbody/tr[8]/td"));//33 webelements
        for(WebElement we:elementList){
            obtainedList.add(we.getText()); // Storing all the texts of webelements
        }

        String[] sample1 = new String[arr.length];
        for(int i=0;i<arr.length;i++){
            sample1[i] = obtainedList.get((arr[i]));
        }

        List<WebElement> elementList1= driver.findElements(By.xpath("//*[@id='claimRow']/tbody/tr[9]/td"));

        for(WebElement we:elementList1){

            obtainedList.add(we.getText()); //

        }

        String[] sample2 = new String[arr.length];

        for(int i=0;i<arr.length;i++){
            sample2[i] = obtainedList.get((arr[i])); // sample array = dateservice, processed date and processed time for single row
        }

        SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");

        sample1[2] = sample1[2].replaceAll(".", ":");//row 8th processedTime formatting

        sample2[2] = sample2[2].replaceAll(".",":");//row 9th processedTime formatting

        Date processedTime1 = (Date)formatter.parse(sample1[2]);

        Date processedTime2 = (Date)formatter.parse(sample2[2]);

        if (processedTime1.before(processedTime2)) {
            isDescending = true;
        }
        return isDescending;
    }
}
