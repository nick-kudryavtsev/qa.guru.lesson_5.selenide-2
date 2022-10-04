package homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @Test
    void isPageComparePlans(){
        Configuration.baseUrl = "https://github.com/";

        open("/pricing");
        $("body > div.application-main > main > div.p-responsive.container-xl.text-center.mt-7.mt-md-8.mt-lg-9.mb-5.mb-lg-9 > h1")
                .should(Condition.text("Get the complete developer platform."));
    }

    @Test
    void DragAndDropTest(){
        Configuration.baseUrl = "https://the-internet.herokuapp.com";

        open("/drag_and_drop");

        SelenideElement sourceEl = $("#column-a");
        SelenideElement targetEl = $("#column-b");

//        isn't working
//        actions()
//                .clickAndHold(sourceEl)
//                .moveToElement(targetEl)
//                .release()
//                .build()
//                .perform();

        $(sourceEl).dragAndDropTo(targetEl);

        $(".column", 1).should(Condition.text("A"));

        sleep(5000);
    }
}
