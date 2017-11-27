/*

public class Sample5 {

*/
/*if(sample1[0]==sample2[0]&&sample1[1]==sample2[1]&&proceesedTime1.before(processedTime2)){
        isDescending = true;
    }*//*

     public static void main(String[] args){

         String serviceDateText1 = driver.findElement(By.xpath("//*[@id='claimRow']/tbody/tr[8]/td[8]")).getText();
         String serviceDateText2 = driver.findElement(By.xpath("//*[@id='claimRow']/tbody/tr[9]/td[8]")).getText();

         String processedDateText1 = driver.findElement(By.xpath("//*[@id='claimRow']/tbody/tr[8]/td[12]")).getText();
         String processedDateText2 = driver.findElement(By.xpath("//*[@id='claimRow']/tbody/tr[9]/td[12]")).getText();

         String processedTimeText1 = driver.findElement(By.xpath("//*[@id='claimRow']/tbody/tr[8]/td[12]")).getText().replaceAll(".",":");
         String processedTimeText2 = driver.findElement(By.xpath("//*[@id='claimRow']/tbody/tr[9]/td[12]")).getText().replaceAll(".",":");

         SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

         Date serviceDate1 = (Date)formatter.parse(serviceDateText1);
         Date serviceDate2 = (Date)formatter.parse(serviceDateText2);

         Date processedDate1 = (Date)formatter.parse(processedDateText1);
         Date processedDate2 = (Date)formatter.parse(processedDateText2);

         Date processedTime1 = (Date)formatter.parse(processedTimeText1);

         Date processedTime2 = (Date)formatter.parse(processedTimeText2);

         if ((serviceDate1.before(serviceDate2))&&(processedDate1.before(processedDate1))&&(processedTime1.before(processedTime2))) {
             isDescending = true;
         }
         return isDescending;
     }

     }

}
*/
