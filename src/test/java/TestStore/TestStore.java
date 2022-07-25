package TestStore;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStore {

    private StorePage storePage;

    @BeforeEach
    void BeforeEach() {

        storePage = Selenide.page(StorePage.class);
        storePage.openStore();
    }

    @Test
    void theProductShouldBeNotFound() {

        storePage.searchProduct("soap");
        storePage.responseFromShop("There is no product that matches the search criteria");
    }

    @Test
    void thereShouldBeOnlyOneProductFound() {

        storePage.searchProduct("gel");
        storePage.checkIfOnlyOneProduct();
    }


    @Test
    void thereShouldBeMoreThanOneProductFound() {
        storePage.searchProduct("cream");
        storePage.checkIfMoreThanOneProduct();
    }

    @AfterEach
    void afterEach() {
        Selenide.clearBrowserLocalStorage();
    }
}
