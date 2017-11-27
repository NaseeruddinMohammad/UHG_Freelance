/*
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample {

    public boolean checkTopTwoRowsOfProcessDataInDecendingOrder() throws InterruptedException {
        Thread.sleep(5000);

       */
/* String firstDate = driver.findElement(By.xpath(""))
                .getText();
        System.out.println("firstDate:" + firstDate);
        String secondDate = driver.findElement(By.xpath(""))
                .getText();
        System.out.println("secondDate:" + secondDate); *//*


       String firstDate = "06/06/2006 23:49:12";
       String secondDate = "06/06/2007 13:49:12";


       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
        try {
            Date date1 = (Date) sdf.parse(firstDate);
            Date date2 = (Date) sdf.parse(secondDate);

            System.out.println(date1.getTime());

            System.out.println("date1:" + date1);
            System.out.println("date2:" + date2);

            if (date1.before(date2)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}


// HH:MM:SS -1
*/
