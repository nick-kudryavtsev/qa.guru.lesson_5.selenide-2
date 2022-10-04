package lesson;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ContributorTest {
    @Test
    void firstContributorIsAndreiSolntsev(){
        Configuration.headless=true;

        open("https://github.com/selenide/selenide");

        $$("[data-test-selector='grid-mode-element'] a")
                .first()
                .hover()
                .shouldHave(
                        Condition.attribute(
                                "href", "https://github.com/asolntsev"
                        ));

        sleep(5000);
    }
}
