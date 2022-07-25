package TestStore;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StorePage {

    private final SelenideElement searchBar = $(".search-bar input");

    private final SelenideElement shopResponse = $(".contentpanel > div:not(.form-inline)");

    private final SelenideElement breadcrumbs = $(".breadcrumb");

    private final ElementsCollection listOfProducts = $$(".prdocutname");

    public void openStore() {
        Selenide.open("https://automationteststore.com/");
    }

    public void searchProduct(String nameOfProduct) {
        searchBar.setValue(nameOfProduct);
        searchBar.pressEnter();
    }

    public void responseFromShop(String response) {
        shopResponse.shouldHave(Condition.text(response));
    }

    public void checkIfOnlyOneProduct() {

        breadcrumbs.shouldNotHave(Condition.text("Search"));

    }

    public void checkIfMoreThanOneProduct() {
        listOfProducts.shouldHave(CollectionCondition.sizeGreaterThan(1));
    }

}
