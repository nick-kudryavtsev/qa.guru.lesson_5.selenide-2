package lesson;


import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browser_command_examples(){
        Configuration.baseUrl = "https://github.com/";

        // open with auth
        open("search?q=selenide",
                AuthenticationType.BASIC,
                new BasicAuthCredentials("user", "password")
        );

        //  back to page
        Selenide.back();
        //  refresh page
        Selenide.refresh();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();");

        Selenide.confirm();
        Selenide.dismiss();

        Selenide.closeWindow();
        Selenide.closeWebDriver();

        Selenide.switchTo().frame("frameName");
        Selenide.switchTo().defaultContent();
        Selenide.switchTo().window("Tab Name");

        //  add cookie
        var cookie = new Cookie("name", "value");
        WebDriverRunner
                .getWebDriver()
                .manage()
                .addCookie(cookie);

        sleep(5000);


    }

    void selectors_examples(){
        $("div").click();
        //  $ is reserved in Kotlin
        element("div").click();

        $("div", 2).click();
        $x("//h1");

        $(byText("random text")).click();
        $(withText("random text")).click();

        $(withTagAndText("div", "say"));
        $(byTagAndText("div", "say"));

        $("div")
                .parent()       //  ближайший родитель
                .sibling(1)      //  ищет сестер вниз
                .preceding(1)            //  ищет сестер вверх
                .closest("div")
                .ancestor("div");
        $("div:last-child");
    }

    void actions_examples(){
        $("div").click();
        $("div").doubleClick();
        $("div").contextClick();

        $("div").hover();

        $("div").setValue("smth");
        $("div").append("Smth");
        $("div").clear();
        $("div").setValue("");      //  clear

        $("div").sendKeys("k");                       //  hotk on element
        actions().sendKeys("k").perform();                                //  hotk out of element
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f"));         //   Ctrl + f

        $("div").pressEnter();
        $("div").pressEscape();
        $("div").pressTab();


        actions()
                .moveToElement($("div"))
                .clickAndHold()
                .moveByOffset(300, 300)
                .release()
                .perform();

    }

    void assertions_examples(){
        $("div").shouldBe();            //  грамотно
        $("div").shouldNotBe();         //  для
        $("div").shouldHave();          //  английского
        $("div").shouldNotHave();       //  языки
        $("div").should();
        $("div").shouldNot();

        //  longer timeouts
        $("")
                .shouldBe(
                        visible, Duration.ofSeconds(4)
                );




    }

    void conditions_examples(){
        $("").shouldHave(visible);
        $("").shouldHave(hidden);

        $("").shouldHave(text("blabla"));
        $("").shouldHave(exactText("blabla"));
        $("").shouldHave(textCaseSensitive("blabla"));
        $("").should(matchText("[0-9]blabla"));

        $("").shouldHave(cssClass("scored"));
        $("").shouldHave(cssValue("color", "green"));





    }
}
