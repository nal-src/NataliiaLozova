package selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DynamicControlPage {
    private final SelenideElement checkbox = $("input[type='checkbox']");
    private final SelenideElement checkboxButton = $("#checkbox-example button");
    private final SelenideElement checkboxMsg = $("#checkbox-example #message");
    private final SelenideElement inputButton = $("#input-example button");
    private final SelenideElement inputMsg = $("#input-example #message");

    public DynamicControlPage setCheckbox() {
        checkbox.shouldBe(Condition.appear).shouldBe(Condition.visible).click();
        return this;
    }

    public DynamicControlPage removeCheckbox() {
        checkboxButton.shouldBe(Condition.appear).shouldBe(Condition.visible).click();
        checkbox.shouldBe(Condition.disappear);
        return this;
    }

    public DynamicControlPage addCheckbox() {
        checkboxButton.shouldBe(Condition.appear).shouldBe(Condition.visible).click();
        checkbox.shouldBe(Condition.appear);
        return this;
    }

    public String getCheckboxMsg() {
        return checkboxMsg.text();
    }

    public DynamicControlPage changeInputStatus() {
        inputButton.shouldBe(Condition.enabled).click();
        inputMsg.shouldBe(Condition.appear).shouldBe(Condition.visible);
        return this;
    }

    public String getInputMsg() {
        return inputMsg.text();
    }
}
