package mainPackge;

import org.testng.annotations.Test;

public class tesngFunctts2 {


    @Test
    public void c_Method1() {
        System.out.println("First Method and c");
    }

    @Test(dependsOnMethods ={"a_Method1"} )
    public void b_Method1() {
        System.out.println("First Method and b");
    }

    @Test(enabled = false)
    public void a_Method1() {
        System.out.println("First Method and a");
    }

}
