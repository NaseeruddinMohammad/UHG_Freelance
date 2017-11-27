import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebDriverSample {

    WebDriver driver;

    @Test
    public void doLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/trainingip/IdeaProjects/DateSort/src/main/resources/chromedriver");
        driver = new ChromeDriver();

        
        driver.get("http://www.whiteboxqa.com/");
        driver.findElement(By.xpath("(//a[text()='Login'])")).click();
        driver.findElement(By.id("username")).sendKeys("wbl.demo@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Innova456path");
        driver.findElement(By.xpath("//button[text()='Login']")).submit();
        System.out.println("Driver::"+driver.getTitle());
        Thread.sleep(10000);

        driver.get("file:///Users/trainingip/Desktop/sample.html");
        List<WebElement> we = driver.findElements(By.xpath("//table/tbody/tr/td[8]"));

        System.out.println(we);
        Thread.sleep(10000);*//*

        driver.get("file:///Users/trainingip/Downloads/emptyColumn76.html");
        List<WebElement> serviceDateElements = driver.findElements(By.xpath("//*[@id=\"claimRow\"]/tbody/tr/td[8]"));
        ArrayList<String> serviceDateList = returnArrayList(serviceDateElements);

        for(int i=0; i<serviceDateList.size();i++){
            System.out.println("List::"+ serviceDateList.get(i));
        }

        int count = 0;
        for(WebElement we: serviceDateElements){
            if (we.getText().isEmpty()) {
                count++;
            }
                //And claims exist with no Date of Service
                System.out.println("Yes, Its contains empty No service Date");
            }
            System.out.println(count);

        Thread.sleep(3000);
        driver.quit();
    }


    public static ArrayList<String> returnArrayList(List<WebElement> list){
        ArrayList<String> arrayList = new ArrayList<String>();
        for(WebElement we: list){
            arrayList.add(we.getText());
        }
        return arrayList;
    }
}
