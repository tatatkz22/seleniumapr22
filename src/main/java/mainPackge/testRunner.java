package mainPackge;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/delegateAdd.feature",
        glue= "cucumberPkg",
        dryRun=false,
        monochrome = true,
        plugin={"pretty","html:cucumberreport"}
)
public class testRunner {
}
