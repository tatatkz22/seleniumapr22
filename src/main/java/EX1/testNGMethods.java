package EX1;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class testNGMethods {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void c_SoftwareTesting(){
        System.out.println("Software Testing its C -1");
    }
    @Test(priority = 2,enabled = true)
    public void b_Selenium(){
        System.out.println("Selenium its B");
    }
    @Test(priority = 3,dependsOnMethods={"b_Selenium"})
    public void a_JavaTraining(){
        System.out.println("Java Training is A");
    }
    @Test(priority = 4)
    public void e_DataBaseTesting(){
        System.out.println("Database Testing is E");
    }
    @Test(dependsOnMethods={"c_SoftwareTesting"})
    public void d_MobileAutomation(){
        System.out.println("Mobile Automation is D");
    }

}
