import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CountOfLinks {

    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://businesstoday.intoday.in");
        List<WebElement> lst = driver.findElements(By.xpath("//a"));
        System.out.println(lst.size());
        int countInt = 0;
        int countExt = 0;

        for(int i=0;i<lst.size();i++)
        {
            String links = lst.get(i).getAttribute("href");
            boolean b = links.startsWith("http://businesstoday");
            if(b){
                System.out.println("Internal links ="+links);
                countInt++;
            }
            else {
                System.out.println("External links="+links);
                countExt++;
            }
        }
        System.out.println("Total internal Links ="+countInt+" and  Total External links ="+countExt);
    }
}

