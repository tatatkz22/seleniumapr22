package tPkg;

import org.testng.annotations.Test;

public class testNGFuncts {

    @Test(groups="course1")
    public void courseMethod1() {
        System.out.println("Course Method1()");
    }

    @Test(groups="course2")
    public void courseMethod2() {
        System.out.println("Course Method2()");
    }

    @Test(groups="course1")
    public void courseMethod3() {
        System.out.println("Course Method3() ");
    }

    @Test(groups="course3")
    public void courseMethod4() {
        System.out.println("Course Method4()");
    }

}
