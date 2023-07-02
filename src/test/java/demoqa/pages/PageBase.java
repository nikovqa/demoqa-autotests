package demoqa.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PageBase {

    public void closeFooter(){
        executeJavaScript("$('footer').remove()");

    }

    public void addRemove(){
        executeJavaScript("$('#fixedban').remove()");

    }

    public void clickSubmit(){
        $("#submit").click();

    }

}
