import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownRequirement {

    public static WebDriver driver;
    NewRequirement nr;

    @BeforeClass()
    public static void openDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/trainingip/IdeaProjects/DateSort/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("file:///Users/trainingip/Downloads/TXLstorieshome.html");
        Thread.sleep(3000);
    }

    @Test
    public void AgentRolefieldisdisabled() throws InterruptedException {
        Thread.sleep(2000);
        WebElement agentRoleDropDown = driver.findElement(By.id("routing_AgentRole"));

        if (agentRoleDropDown.isEnabled())
            System.out.println("Its EnableD");
        else
            System.out.println("Its Disabled");
    }

    @Test
    public void TeamQuickListsdisabled() throws InterruptedException {
        Thread.sleep(2000);
        WebElement TeamQuickListDropDown = driver.findElement(By.id("favorites"));

        if (TeamQuickListDropDown.isEnabled())
            System.out.println("Its EnableD");
         else
            System.out.println("Its Disabled");
    }

    @Test
    public void selectServiceRequestStatus() {
        String checkservicestatus = "";
        WebElement serviceRequestStatus = driver.findElement(By.id("serviceStatus"));
        checkservicestatus = new Select(serviceRequestStatus).getFirstSelectedOption().getText();

        if (checkservicestatus.equals("CLOSED"))
            System.out.println("Closed");
        else
            System.out.println("Open");
    }

    @AfterClass
    public static void closeDriver(){
        driver.quit();
    }
}
