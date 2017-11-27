import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ParseDate {

    public static void main(String [] arr) throws InterruptedException, ParseException{
            //Thread.sleep(3000);
            //processTime ID exisit
            //driver.findElement(By.id("processTime")).isDisplayed();
           // boolean isDescending = false;
            //checking for xpath with highest time
            //String firstTime = driver.findElement(By.xpath("//*[@id='claimRow']/tbody/tr[1]/td[33]")).getText();
            // checking for xpath with 2nd highest
            //String secondTime = driver.findElement(By.xpath("//*[@id='claimRow']/tbody/tr[2]/td[33]")).getText();

            String firstTime = "07.19.12";
            String secondTime = "07.12.12";

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

            Date time1 = (Date)sdf.parse(firstTime);
            Date time2 = (Date)sdf.parse(secondTime);

            if(time1.getTime()>time2.getTime()){
                System.out.println("Yes");
            }
            else{
                System.out.println("Yes");
            }

        ArrayList<String> list = new ArrayList<String>();
            list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");

        String s = list.get(0);
        System.out.println(s);
    }
}
