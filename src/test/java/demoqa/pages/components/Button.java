package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

public class Button {

    private final String NAME;
    private final SelenideElement SELECTOR;

    public Button (String name, SelenideElement selector) {
        this.NAME = name;
        this.SELECTOR = selector;
    }

   // @Step("Click button {this.name}")
    public void click(){
        System.out.printf( "Click button " + NAME );
        SELECTOR.click();
    }

}
